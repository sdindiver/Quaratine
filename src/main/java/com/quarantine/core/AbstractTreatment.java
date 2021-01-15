package com.quarantine.core;

public class AbstractTreatment {
	private AbstractTreatment nextHandler = null;

	private final Medicine medicine;

	public AbstractTreatment(final Medicine medicineName) {
		this.medicine = medicineName;
	}

	public AbstractTreatment() {
		medicine = null;
	}

	AbstractTreatment getNextHandler() {
		return this.nextHandler;
	}

	protected Medicine getMedicineName() {
		return medicine;
	}

	void treat(final Quarantine quarantine) {
		treat(quarantine, null);
	}

	void treat(final Quarantine quarantine, AbstractTreatment callBack) {
		accept(quarantine);
		if (this.nextHandler != null) {
			this.nextHandler.treat(quarantine, callBack);
		} else {
			if (callBack != null)
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

	public void accept(Quarantine quarantine) {

	};

}
