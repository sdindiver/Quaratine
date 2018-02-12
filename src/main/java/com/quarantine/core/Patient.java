package com.quarantine.core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Patient implements Comparable<Patient> {

	private HealthStatus healthStatus;
	private final List<Medicine> applyingTreatment = new ArrayList<>();
	private final List<Medicine> appliedTreatment = new ArrayList<>();

	public Patient(HealthStatus healthStatus){
		this.healthStatus=healthStatus;
	}

	public HealthStatus getHealthStatus() {
		return healthStatus;
	}

	public void changeHealthStatus(HealthStatus diseaseType) {
		this.healthStatus = diseaseType;
	}

	public List<Medicine> getAppllyingTreatementQueue() {
		return Collections.unmodifiableList(applyingTreatment);
	}
	
	public void addAppllyingTreatementQueue(Medicine treatment) {
		this.applyingTreatment.add(treatment);
	}

	public List<Medicine> getAppliedTreatment() {
		return Collections.unmodifiableList(appliedTreatment);
	}
	
	public void treatmentApplied(Medicine medicine) {
		this.applyingTreatment.remove(medicine);
		this.appliedTreatment.add(medicine);
	}

	public boolean isInsulineInjected() {
		return this.appliedTreatment.contains(Medicine.INSULIN) || this.applyingTreatment.contains(Medicine.INSULIN);
	}

	@Override
	public int compareTo(Patient o) {
		return this.healthStatus.compareTo(o.healthStatus);
	}

	

}
