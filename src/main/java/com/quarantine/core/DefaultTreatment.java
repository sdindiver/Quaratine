package com.quarantine.core;

public class DefaultTreatment extends AbstractTreatment {

	@Override
	public void accept(final Quarantine quarantine) {
		if (!quarantine.checkIfhasTreatment(Medicine.INSULIN)) {
			quarantine.getPatientGroups().get(HealthStatus.DEAD)
					.combine(quarantine.getPatientGroups().get(HealthStatus.DIABATIC));
		}

	}

}
