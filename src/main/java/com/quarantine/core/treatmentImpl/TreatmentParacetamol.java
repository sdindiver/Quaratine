package com.quarantine.core.treatmentImpl;

import com.quarantine.core.AbstractTreatment;
import com.quarantine.core.HealthStatus;
import com.quarantine.core.Medicine;
import com.quarantine.core.Quarantine;

public class TreatmentParacetamol extends AbstractTreatment {

	public TreatmentParacetamol(final Medicine medicineName) {
		super(medicineName);
	}

	@Override
	public void accept(final Quarantine quarantine) {
		quarantine.getPatientGroups().get(HealthStatus.HEALTHY)
				.combine(quarantine.getPatientGroups().get(HealthStatus.FEVER));

		if (quarantine.checkIfhasTreatment(Medicine.ASPIRIN))
			killSubject(quarantine);
	}

	private void killSubject(Quarantine quarantine) {
		quarantine.getPatientGroups().get(HealthStatus.DEAD)
				.combine(quarantine.getPatientGroups().get(HealthStatus.FEVER))
				.combine(quarantine.getPatientGroups().get(HealthStatus.HEALTHY))
				.combine(quarantine.getPatientGroups().get(HealthStatus.DIABATIC))
				.combine(quarantine.getPatientGroups().get(HealthStatus.TUBERCLOSIS));
	}

}
