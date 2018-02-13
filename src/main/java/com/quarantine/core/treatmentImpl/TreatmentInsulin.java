package com.quarantine.core.treatmentImpl;

import com.quarantine.core.AbstractTreatment;
import com.quarantine.core.Medicine;
import com.quarantine.core.Quarantine;

public class TreatmentInsulin extends AbstractTreatment{

	public TreatmentInsulin(final Medicine medicineName) {
		super(medicineName);
	}

	@Override
	public void accept(final Quarantine quarantine){	
	}

}
