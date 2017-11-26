package quarantine;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class TreatmentAspirin implements ITreatment{
	

	@Override
	public void treat(Quarantine quaratine) {
		LinkedHashMap<PatientType, Integer> patientInfoMap= quaratine.patientInfoMap;
		ArrayList<Medicines> appliedTreatementList = quaratine.appliedTreatementList;
		
		if(appliedTreatementList.contains(Medicines.ASPIRIN)){
			LinkedHashMap<PatientType, Integer> map = patientInfoMap;
			
			if(appliedTreatementList.contains(Medicines.PARACETOL)){
				quaratine.isInsulineInjected = true; //Because They are Dead
				map.put(PatientType.DEAD, map.get(PatientType.DEAD) + map.get(PatientType.FEVER) + map.get(PatientType.HEALTHY) + map.get(PatientType.DIABATIC) + map.get(PatientType.TUBERCLOSIS));
                map.put(PatientType.HEALTHY, 0);
                map.put(PatientType.DIABATIC, 0);
                map.put(PatientType.TUBERCLOSIS, 0);
			}else{
				quaratine.isInsulineInjected = false;
				map.put(PatientType.HEALTHY, map.get(PatientType.HEALTHY) + map.get(PatientType.FEVER));
	            map.put(PatientType.FEVER, 0);
			}
			
		}
		
	}

}
