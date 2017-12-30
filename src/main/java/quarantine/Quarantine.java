package quarantine;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class Quarantine {
	
	LinkedHashMap<PatientType,Integer> patientInfoMap =  new LinkedHashMap<>();
	ArrayList<Medicines> appliedTreatementList = new ArrayList<>();
	 ArrayList<ITreatment> treatementRepository = new ArrayList<>();
	int treatedTBPatientCount=0;
	boolean isInsulineInjected = false;

	public Quarantine(LinkedHashMap<PatientType, Integer> patientCount) {
		System.out.println("indiver demo233sdfa");
		this.patientInfoMap =patientCount;
	}

	public static Quarantine createFromCodeString(String codeString) {
		  return new Quarantine( PatientType.createFrequencyMap(codeString));
		}

	public String report() {
		final String[] result = {""};
        patientInfoMap.forEach((k, v) -> result[0] += PatientType.getCode(k) + ":" + v.toString() + " ");
        return result[0].trim();
	}
	
	public void wait40Days() {
		for(ITreatment treatment : treatementRepository){
			treatment.treat(this);
		}
		if(!isInsulineInjected){
			dieDiabticPatient();
		}
	}

	private void dieDiabticPatient() {
		patientInfoMap.put(PatientType.DEAD, patientInfoMap.get(PatientType.DIABATIC));
		patientInfoMap.put(PatientType.DIABATIC, 0);
		
	}

	public void aspirin() {
		appliedTreatementList.add(Medicines.ASPIRIN);
		treatementRepository.add(new TreatmentAspirin());
		
	}

	public void antibiotic() {
		appliedTreatementList.add(Medicines.ANTIBIOTIC);
		treatementRepository.add(new TreatmentAntibiotic());
		
	}

	public void insulin() {
		appliedTreatementList.add(Medicines.INSULIN);
		treatementRepository.add(new TreatmentInsulin());
		
	}

	public void paracetamol() {
		appliedTreatementList.add(Medicines.PARACETOL);
		treatementRepository.add(new TreatmentParacetamol());
		
	}

}
