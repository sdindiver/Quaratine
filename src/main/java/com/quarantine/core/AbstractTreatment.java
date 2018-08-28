package com.quarantine.core;

import com.quarantine.core.Medicine;
import com.quarantine.core.Quarantine;

public class AbstractTreatment {
	private AbstractTreatment nextHandler = null;

	
	
	
	
	private final Medicine medicineName;

	public AbstractTreatment(final Medicine medicineName) {
		this.medicineName = medicineName;
	}

	public AbstractTreatment() {
		medicineName = null;
	}

	AbstractTreatment getNextHandler() {
		return this.nextHandler;
	}

	protected Medicine getMedicineName() {
		return medicineName;
	}
	
	void treat(final Quarantine quarantine){
		treat(quarantine,null);
	}

	void treat(final Quarantine quarantine, AbstractTreatment callBack) {
		accept(quarantine);
		if (this.nextHandler != null) {
			this.nextHandler.treat(quarantine, callBack);
		} else {
			if(callBack !=null)
				callBack.treat(quarantine);
		}
	}

	void setNextHandler(AbstractTreatment handler) {
		AbstractTreatment processHandler = this;
		while (processHandler.nextHandler != null) {
			processHandler = processHandler.nextHandler;
		}
		processHandler.nextHandler = handler;
	}

	public  void accept(Quarantine quarantine){
		
	};

}
