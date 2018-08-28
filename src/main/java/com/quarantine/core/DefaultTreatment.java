package com.quarantine.core;

import com.quarantine.core.HealthStatus;
import com.quarantine.core.Medicine;
import com.quarantine.core.Quarantine;

public class DefaultTreatment extends AbstractTreatment {

	@Override
	public void accept(final Quarantine quarantine) {
		
		
		
		if(!quarantine.checkIfhasTreatment(Medicine.INSULIN)){
			System.out.println("testRebase");
			System.out.println("testRebase2");
			System.out.println("testRebase3");
			System.out.println("testRebase4");
			quarantine.getPatientGroups().get(HealthStatus.DEAD).combine(quarantine.getPatientGroups().get(HealthStatus.DIABATIC));
		}
		

	}

}
