package com.quarantine.core;

public class TreatmentInsulin extends AbstractTreatment{

	public TreatmentInsulin(final Medicine medicineName) {
		super(medicineName);
	}

	@Override
	public void accept(final Patient patient) {	
	
		
		if(patient.getHealthStatus().equals(HealthStatus.DIABATIC)){
			patient.treatmentApplied(this.getMedicineName());
		}
		
	}

}
