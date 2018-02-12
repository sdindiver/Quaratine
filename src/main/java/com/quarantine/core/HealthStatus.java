package com.quarantine.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
//F:0 H:3 D:0 T:1 X:3
public enum HealthStatus {
	FEVER("F"),HEALTHY("H"),DIABATIC("D"),TUBERCLOSIS("T"),DEAD("X");
	private final String healthStatus;

	HealthStatus(String healthStatus) {
		this.healthStatus = healthStatus;
	}

	public static String getCode(HealthStatus patientType) {
		for (HealthStatus type : HealthStatus.values())
			if (type.equals(patientType))
				return type.healthStatus;
		return null;
	}

	private static final Map<String, HealthStatus> codeMap = new HashMap<>();

	static {
		for (HealthStatus type : HealthStatus.values()) {
			codeMap.put(type.healthStatus, type);
		}
	}

	public static HealthStatus getByCode(String code) {
		HealthStatus retval = codeMap.get(code);
		if (retval == null)
			throw new NoSuchElementException(code);
		return retval;
	}

	public static List<Patient> createPatientList(String codeString) {
		ArrayList<Patient> patientList = new ArrayList<>();
		for (String code : codeString.split(",")) {
			HealthStatus type = getByCode(code);
			Patient patient = new Patient(type);
			patientList.add(patient);
		}
		return patientList;
	}

}
