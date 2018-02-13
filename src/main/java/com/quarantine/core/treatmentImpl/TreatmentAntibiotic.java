package com.quarantine.core.treatmentImpl;

import com.quarantine.core.AbstractTreatment;
import com.quarantine.core.HealthStatus;
import com.quarantine.core.Medicine;
import com.quarantine.core.Quarantine;

public class TreatmentAntibiotic extends AbstractTreatment {

	public TreatmentAntibiotic(final Medicine medicineName) {
		super(medicineName);
	}

	@Override
	public void accept(final Quarantine quarantine) {
		if (quarantine.checkIfhasTreatment(Medicine.INSULIN)) {
			quarantine.getPatientGroups().get(HealthStatus.FEVER)
					.combine(quarantine.getPatientGroups().get(HealthStatus.HEALTHY));
			}
		quarantine.getPatientGroups().get(HealthStatus.HEALTHY)
				.combine(quarantine.getPatientGroups().get(HealthStatus.TUBERCLOSIS));
	}

}
