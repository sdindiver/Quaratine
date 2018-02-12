package com.quarantine.core;

import java.util.List;

public class PatientGroup {
	private List<Patient> patientList;
	private HealthStatus healthStatus;

	public PatientGroup(List<Patient> patientList, HealthStatus healthStatus) {
		super();
		this.patientList = patientList;
		this.healthStatus = healthStatus;
	}

	public List<Patient> getPatientList() {
		return patientList;
	}

	public void setPatientList(List<Patient> patientList) {
		this.patientList = patientList;
	}

	public HealthStatus getHealthStatus() {
		return healthStatus;
	}

	public void setHealthStatus(HealthStatus healthStatus) {
		this.healthStatus = healthStatus;
	}

}
