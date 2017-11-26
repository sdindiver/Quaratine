package quarantine;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class TreatmentParacetamol implements ITreatment{

	@Override
	public void treat(Quarantine quaratine) {
		LinkedHashMap<PatientType, Integer> patientInfoMap= quaratine.patientInfoMap;
		ArrayList<Medicines> appliedTreatementList = quaratine.appliedTreatementList;
		if(appliedTreatementList.contains(Medicines.PARACETOL)){
			quaratine.isInsulineInjected = false;
			LinkedHashMap<PatientType, Integer> map = patientInfoMap;
			map.put(PatientType.HEALTHY, map.get(PatientType.HEALTHY) + map.get(PatientType.FEVER));
            map.put(PatientType.FEVER, 0);
		}
		
	}

}
