package quarantine;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class TreatmentInsulin implements ITreatment{

	@Override
	public void treat(Quarantine quaratine) {
		LinkedHashMap<PatientType, Integer> patientInfoMap= quaratine.patientInfoMap;
		ArrayList<Medicines> appliedTreatementList = quaratine.appliedTreatementList;
		if(appliedTreatementList.contains(Medicines.INSULIN)){
			LinkedHashMap<PatientType, Integer> map = patientInfoMap;
			quaratine.isInsulineInjected = true;
			if(appliedTreatementList.contains(Medicines.ANTIBIOTIC)){
				map.put(PatientType.FEVER, map.get(PatientType.HEALTHY) + map.get(PatientType.FEVER)-quaratine.treatedTBPatientCount);
                map.put(PatientType.HEALTHY, quaratine.treatedTBPatientCount);
               
			}
		}
		
	}

}
