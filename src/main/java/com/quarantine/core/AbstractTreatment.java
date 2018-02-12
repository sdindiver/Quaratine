package com.quarantine.core;

abstract class AbstractTreatment {
	 private final Medicine medicineName;

	public AbstractTreatment(final Medicine medicineName) {
		this.medicineName = medicineName;
	}
	
	public Medicine getMedicineName(){
		return medicineName;
	}

	public void treat(final Patient patient){
		if(patient.getAppllyingTreatementQueue().contains(medicineName)){
			accept(patient);
		}
	}
	
	public abstract void accept(final Patient patient);
}
