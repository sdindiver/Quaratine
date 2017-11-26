package quarantine;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class TreatmentAntibiotic implements ITreatment{

	@Override
	public void treat(Quarantine quaratine) {
		LinkedHashMap<PatientType, Integer> patientInfoMap= quaratine.patientInfoMap;
		ArrayList<Medicines> appliedTreatementList = quaratine.appliedTreatementList;
		if(appliedTreatementList.contains(Medicines.ANTIBIOTIC)){
			quaratine.isInsulineInjected = false;
			LinkedHashMap<PatientType, Integer> map = patientInfoMap;
			quaratine.treatedTBPatientCount = map.get(PatientType.TUBERCLOSIS);
			map.put(PatientType.HEALTHY, map.get(PatientType.HEALTHY) + map.get(PatientType.TUBERCLOSIS));
	        map.put(PatientType.TUBERCLOSIS, 0);
		}
		
		
		
	}

}
