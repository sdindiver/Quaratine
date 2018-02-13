package com.quarantine.core;

import java.util.TreeMap;

public class PatientGroupMap extends TreeMap<HealthStatus, Patients>{
	
	private static final long serialVersionUID = 1L;
	private  Patients patientCount;
	private  HealthStatus healthStatus;
	//private final List<Medicine> appliedTreatment = new ArrayList<>();

	public PatientGroupMap() {
		this.putIfAbsent(HealthStatus.DEAD, new Patients(0));
		this.putIfAbsent(HealthStatus.TUBERCLOSIS, new Patients(0));
		this.putIfAbsent(HealthStatus.FEVER, new Patients(0));
		this.putIfAbsent(HealthStatus.HEALTHY, new Patients(0));
		this.putIfAbsent(HealthStatus.DIABATIC, new Patients(0));
	}

	public Patients put(HealthStatus key, Patients value) {
		return super.put(key, value);
	}
	
	Patients get(HealthStatus key) {
		return super.get(key);
	}

	public Patients getPatientCount() {
		return patientCount;
	}


	HealthStatus getHealthStatus() {
		return healthStatus;
	}
//
//
//
//	public List<Medicine> getAppliedTreatment() {
//		return Collections.unmodifiableList(appliedTreatment);
//	}
//	
//	public void treatmentApplied(Medicine medicine) {
//		this.appliedTreatment.add(medicine);
//	}



	
}
