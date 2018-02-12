package quarantine;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;

public enum PatientType {
	DEAD("X"),
	DIABATIC("D"),
	FEVER("F"),
	TUBERCLOSIS("T"),
	HEALTHY("H");
	private final String disease;
	
	PatientType(String disease) {
	        this.disease = disease;
	}
	public static String getCode(PatientType patientType)
    {
        for (PatientType type : PatientType.values())
            if (type.equals(patientType))
                return type.disease;
        return null;
    }

	
	private static final Map<String, PatientType> codeMap = new HashMap<>();
	
	static {
	  for ( PatientType type : PatientType.values() ) {
	    codeMap.put( type.disease, type);
	  }
	}

	public static PatientType getByCode(String code) {
	  PatientType retval = codeMap.get(code);
	  if ( retval == null ) throw new NoSuchElementException(code);
	  return retval;
	}
	
	public static LinkedHashMap<PatientType, Integer> createFrequencyMap(String codeString) {
		LinkedHashMap<PatientType, Integer> frequency = new LinkedHashMap<>(codeString.length() / 2 + 1);
		  for ( String code : codeString.split(",") ) {
		    PatientType type = getByCode(code);
		    frequency.merge(type, 1, Integer::sum);
		  }
		  frequency.put( PatientType.DEAD, 0);
		  return frequency;
		}
	

}
