package com.quarantine.core;

import com.quarantine.core.treatmentImpl.TreatmentAntibiotic;
import com.quarantine.core.treatmentImpl.TreatmentAspirin;
import com.quarantine.core.treatmentImpl.TreatmentInsulin;
import com.quarantine.core.treatmentImpl.TreatmentParacetamol;

public class Quarantine {

	private final PatientGroupMap patientGroupMap;
	private final AbstractTreatment treatmentHandler;

	private Quarantine(PatientGroupMap patientGroupMap) {
		this.patientGroupMap = patientGroupMap;
		this.treatmentHandler = new AbstractTreatment();
	}

	public boolean checkIfhasTreatment(Medicine medicine) {
		boolean allowed = false;
		AbstractTreatment handler = this.treatmentHandler;
		while (handler != null) {
			allowed = medicine.equals(handler.getMedicineName());
			handler = handler.getNextHandler();
		}
		return allowed;
	}

	public PatientGroupMap getPatientGroups() {
		return patientGroupMap;
	}

	public static Quarantine createFromCodeString(final String codeString) {
		return new Quarantine(HealthStatus.createPatientList(codeString));
	}

	public String report() {
		final String[] result = { "" };
		this.patientGroupMap.forEach((k, v) -> result[0] += HealthStatus.getCode(k) + ":" + v.get() + " ");
		return result[0].trim();
	}

	public void wait40Days() {
		treatmentHandler.treat(this, new DefaultTreatment());
	}

	public void aspirin() {
		treatmentHandler.setNextHandler(new TreatmentAspirin(Medicine.ASPIRIN));
	}

	public void antibiotic() {
		treatmentHandler.setNextHandler(new TreatmentAntibiotic(Medicine.ANTIBIOTIC));

	}

	public void insulin() {
		treatmentHandler.setNextHandler(new TreatmentInsulin(Medicine.INSULIN));
	}

	public void paracetamol() {
		treatmentHandler.setNextHandler(new TreatmentParacetamol(Medicine.PARACETOL));
	}

}
