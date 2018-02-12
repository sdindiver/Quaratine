package com.quarantine.core;

public class TreatmentAntibiotic extends AbstractTreatment{
	
	
	public TreatmentAntibiotic(final Medicine medicineName){
		super(medicineName);
	}

	
	@Override
	public void accept(Patient patient) {
	
		if(patient.isInsulineInjected()){
			if(patient.getHealthStatus().equals(HealthStatus.HEALTHY)){
				patient.changeHealthStatus(HealthStatus.FEVER);
				patient.treatmentApplied(this.getMedicineName());
			}
		}
		if(patient.getHealthStatus().equals(HealthStatus.TUBERCLOSIS)){
				patient.changeHealthStatus(HealthStatus.HEALTHY);
				patient.treatmentApplied(this.getMedicineName());

		}
		

	}

}
