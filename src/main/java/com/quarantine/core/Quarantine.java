package com.quarantine.core;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Quarantine {

	private List<Patient> patientList;

	private Quarantine(List<Patient> patientList) {
		this.patientList = patientList;
	}

	public static Quarantine createFromCodeString(String codeString) {
		return new Quarantine(HealthStatus.createPatientList(codeString));
	}

	public String report() {
		Map<HealthStatus, Integer> patientSummaryMap = getReportMap();

		final String[] result = { "" };
		patientSummaryMap.forEach((k, v) -> result[0] += HealthStatus.getCode(k) + ":" + v.toString() + " ");
		return result[0].trim();
	}

	private Map<HealthStatus, Integer> getReportMap() {
		Map<HealthStatus, Integer> patientSummaryMap = new TreeMap<>();
		for (Patient patient : this.patientList) {
			patientSummaryMap.merge(patient.getHealthStatus(), 1, Integer::sum);
		}
		patientSummaryMap.put(HealthStatus.FEVER, 0);
		patientSummaryMap.put(HealthStatus.DEAD, 0);
		patientSummaryMap.put(HealthStatus.TUBERCLOSIS, 0);
		patientSummaryMap.put(HealthStatus.HEALTHY, 0);
		patientSummaryMap.put(HealthStatus.DIABATIC, 0);
		return patientSummaryMap;
	}

	public void wait40Days() {
		for (Patient patient : patientList) {
			List<AbstractTreatment> patientTreatmentList = TreatmentRepository.getTreatments(patient);
			for (AbstractTreatment treatment : patientTreatmentList) {
				treatment.treat(patient);
			}
			if (patient.getHealthStatus().equals(HealthStatus.DIABATIC)) {
				if (!patient.isInsulineInjected()) {
					patient.changeHealthStatus(HealthStatus.DEAD);
				}
			}
		}
	}

	public void aspirin() {
		for (Patient patient : patientList) {
			patient.addAppllyingTreatementQueue(Medicine.ASPIRIN);
		}

	}

	public void antibiotic() {
		for (Patient patient : patientList) {
			patient.addAppllyingTreatementQueue(Medicine.ANTIBIOTIC);
		}
	}

	public void insulin() {
		for (Patient patient : patientList) {
			patient.addAppllyingTreatementQueue(Medicine.INSULIN);
		}
	}

	public void paracetamol() {
		for (Patient patient : patientList) {
			patient.addAppllyingTreatementQueue(Medicine.PARACETOL);
		}

	}

}
