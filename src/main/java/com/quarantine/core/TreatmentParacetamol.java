package com.quarantine.core;

public class TreatmentParacetamol extends AbstractTreatment {

	public TreatmentParacetamol(final Medicine medicineName) {
		super(medicineName);
	}

	@Override
	public void accept(final Patient patient) {
		if (patient.getHealthStatus().equals(HealthStatus.FEVER)) {
			patient.changeHealthStatus(HealthStatus.HEALTHY);
			patient.treatmentApplied(this.getMedicineName());

		}
		if (patient.getAppliedTreatment().contains(Medicine.ASPIRIN))
			killSubject(patient);
			patient.treatmentApplied(this.getMedicineName());

	}

	private void killSubject(Patient patient) {
		patient.changeHealthStatus(HealthStatus.DEAD);
	}

}
