package com.quarantine.core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TreatmentRepository {

	private static Set<AbstractTreatment> availableTreatementSet = new HashSet<>();
	
	static{
		availableTreatementSet.add(new TreatmentAntibiotic(Medicine.ANTIBIOTIC));
		availableTreatementSet.add(new TreatmentAspirin(Medicine.ASPIRIN));
		availableTreatementSet.add(new TreatmentInsulin(Medicine.INSULIN));
		availableTreatementSet.add(new TreatmentParacetamol(Medicine.PARACETOL));
		
		availableTreatementSet = Collections.unmodifiableSet(availableTreatementSet);
	}
	
	
	public static List<AbstractTreatment> getTreatments(Patient patient){
		List<AbstractTreatment> treatmentList = new ArrayList<>();
		for(AbstractTreatment treatment :availableTreatementSet){
			if(patient.getAppllyingTreatementQueue().contains(treatment.getMedicineName()))
				treatmentList.add(treatment);
		}
		return treatmentList;
	}
	
	
}
