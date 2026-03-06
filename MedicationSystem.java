/**
 * Manages the entire pharmacy management system.
 * Central controller for managing patients, doctors, medications, and prescriptions.
 */
public class MedicationSystem {
	private Patient[] patients;
	private Doctor[] doctors;
	private Medication[] medications;
	private Prescription[] prescriptions;
	private int patientCount = 0;
	private int doctorCount = 0;
	private int medicationCount = 0;
	private int prescriptionCount = 0;

	/**
	 * Constructs a new MedicationSystem.
	 * Initializes empty arrays for patients, doctors, medications, and prescriptions.
	 */
	public MedicationSystem() {
		this.patients = new Patient[100];
		this.doctors = new Doctor[100];
		this.medications = new Medication[100];
		this.prescriptions = new Prescription[100];
	}

	/**
	 * Adds a new patient to the system.
	 */
	public void addPatient(Patient patient) {
		if (patientCount < patients.length) {
			patients[patientCount++] = patient;
		}
	}

	/**
	 * Adds a new doctor to the system.
	 */
	public void addDoctor(Doctor doctor) {
		if (doctorCount < doctors.length) {
			doctors[doctorCount++] = doctor;
		}
	}

	/**
	 * Adds a new medication to the inventory.
	 */
	public void addMedication(Medication medication) {
		if (medicationCount < medications.length) {
			medications[medicationCount++] = medication;
		}
	}

	/**
	 * Searches for a patient by name and returns their details.
	 */
	public String searchPatientDetails(String name) {
		Patient patient = findPatientByName(name);
		return patient == null ? "Patient not found." : patient.toString();
	}

	/**
	 * Searches for a doctor by name and returns their details.
	 */
	public String searchDoctorDetails(String name) {
		Doctor doctor = findDoctorByName(name);
		return doctor == null ? "Doctor not found." : doctor.toString();
	}

	/**
	 * Searches for a medication by name and returns its details.
	 */
	public String searchMedicationDetails(String name) {
		Medication medication = findMedicationByName(name);
		return medication == null ? "Medication not found." : medication.toString();
	}

	/**
	 * Assigns a patient to a doctor's patient list.
	 */
	public void addPatientToDoctor(String patientName, String doctorName) {
		Patient patient = findPatientByName(patientName);
		Doctor doctor = findDoctorByName(doctorName);
		if (patient != null && doctor != null) {
			doctor.addPatient(patient);
		}
	}

	/**
	 * Creates and registers a new prescription linking a doctor, patient, and medication.
	 */
	public void acceptPrescription(int id, String doctorName, String patientName, String medicationName) {
		Doctor doctor = findDoctorByName(doctorName);
		Patient patient = findPatientByName(patientName);
		Medication medication = findMedicationByName(medicationName);

		if (doctor == null || patient == null || medication == null) {
			return;
		}

		Prescription prescription = new Prescription(id, doctor, patient, medication);

		if (prescriptionCount < prescriptions.length) {
			prescriptions[prescriptionCount++] = prescription;
		}

		patient.addPrescription(prescription);
		patient.addMedication(medication);
	}

	/**
	 * Edits the details of an existing medication.
	 */
	public void editMedication(String currentName, String newName, String newDosage, String newQuantity) {
		Medication medication = findMedicationByName(currentName);
		if (medication != null) {
			medication.setName(newName);
			medication.setDosage(newDosage);
			medication.setQuantityInStock(newQuantity);
		}
	}

	/**
	 * Edits the details of an existing patient.
	 */
	public void editPatient(String currentName, String newName, int newAge, String newPhoneNumber) {
		Patient patient = findPatientByName(currentName);
		if (patient != null) {
			patient.setName(newName);
			patient.setAge(newAge);
			patient.setPhoneNumber(newPhoneNumber);
		}
	}

	/**
	 * Edits the details of an existing doctor.
	 */
	public void editDoctor(String currentName, String newName, int newAge, String newPhoneNumber,
			String newSpecialization) {
		Doctor doctor = findDoctorByName(currentName);
		if (doctor != null) {
			doctor.setName(newName);
			doctor.setAge(newAge);
			doctor.setPhoneNumber(newPhoneNumber);
			doctor.setSpecialization(newSpecialization);
		}
	}

	/**
	 * Deletes a medication from the inventory by name.
	 */
	public void deleteMedication(String name) {
		int index = findMedicationIndexByName(name);
		if (index >= 0) {
			for (int i = index; i < medicationCount - 1; i++) {
				medications[i] = medications[i + 1];
			}
			medicationCount--;
		}
	}

	/**
	 * Deletes a patient from the system by name and removes them from all doctors.
	 */
	public void deletePatient(String name) {
		int index = findPatientIndexByName(name);
		if (index >= 0) {
			Patient patient = patients[index];
			for (int i = index; i < patientCount - 1; i++) {
				patients[i] = patients[i + 1];
			}
			patientCount--;
			removePatientFromAllDoctors(patient);
		}
	}

	/**
	 * Deletes a doctor from the system by name.
	 */
	public void deleteDoctor(String name) {
		int index = findDoctorIndexByName(name);
		if (index >= 0) {
			for (int i = index; i < doctorCount - 1; i++) {
				doctors[i] = doctors[i + 1];
			}
			doctorCount--;
		}
	}

	/**
	 * Generates a comprehensive report of all system data.
	 */
	public String generateReport() {
		StringBuilder builder = new StringBuilder();
		builder.append("--- Medications ---\n");
		for (int i = 0; i < medicationCount; i++) {
			builder.append(medications[i].toString()).append("\n");
		}

		builder.append("--- Patients ---\n");
		for (int i = 0; i < patientCount; i++) {
			builder.append(patients[i].toString()).append("\n");
		}

		builder.append("--- Doctors ---\n");
		for (int i = 0; i < doctorCount; i++) {
			builder.append(doctors[i].toString()).append("\n");
		}

		builder.append("--- Prescriptions ---\n");
		for (int i = 0; i < prescriptionCount; i++) {
			builder.append(prescriptions[i].toString()).append("\n");
		}

		return builder.toString();
	}

	/**
	 * Checks for expired medications and generates a report.
	 */
	public String checkExpiredMedications() {
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < medicationCount; i++) {
			Medication medication = medications[i];
			if (medication.isExpired()) {
				builder.append("Expired: ").append(medication.toString());
			}
		}

		if (builder.length() == 0) {
			return "No expired medications found.";
		}

		return builder.toString();
	}

	/**
	 * Gets all prescriptions issued by a specific doctor.
	 */
	public String getPrescriptionsByDoctor(String doctorName) {
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < prescriptionCount; i++) {
			Prescription prescription = prescriptions[i];
			Doctor doctor = prescription.getDoctor();
			if (doctor != null && doctor.getName().equalsIgnoreCase(doctorName)) {
				builder.append(prescription.toString());
			}
		}

		return builder.length() == 0 ? "No prescriptions found for doctor." : builder.toString();
	}

	/**
	 * Generates a report of all prescriptions from the past year with medication names.
	 */
	public String pastYearPrescriptionReport() {
		StringBuilder builder = new StringBuilder();
		java.time.LocalDate now = java.time.LocalDate.now();
		java.time.LocalDate oneYearAgo = now.minusYears(1);

		for (int i = 0; i < prescriptionCount; i++) {
			Prescription prescription = prescriptions[i];
			java.time.LocalDate expiry = prescription.getPrescriptionExpiry();
			if (expiry != null && (expiry.isEqual(oneYearAgo) || expiry.isAfter(oneYearAgo))
					&& (expiry.isEqual(now) || expiry.isBefore(now))) {
				Medication medication = prescription.getMedication();
				if (medication != null) {
					builder.append(medication.getName()).append("\n");
				}
			}
		}

		return builder.length() == 0 ? "No prescriptions from the past year." : builder.toString();
	}

	/**
	 * Restocks a specific medication by adding a specified amount.
	 */
	public void restockMedication(String name, int amountToAdd) {
		Medication medication = findMedicationByName(name);
		if (medication == null || amountToAdd <= 0) {
			return;
		}

		int currentQuantity = parseQuantity(medication.getQuantityInStock());
		int newQuantity = currentQuantity + amountToAdd;
		medication.setQuantityInStock(String.valueOf(newQuantity));
	}

	/**
	 * Restocks all medications with random amounts within a specified range.
	 */
	public void restockAllMedications(int minAdd, int maxAdd) {
		if (minAdd <= 0 || maxAdd < minAdd) {
			return;
		}

		java.util.Random random = new java.util.Random();
		int range = maxAdd - minAdd + 1;
		for (int i = 0; i < medicationCount; i++) {
			int amountToAdd = minAdd + random.nextInt(range);
			Medication medication = medications[i];
			int currentQuantity = parseQuantity(medication.getQuantityInStock());
			int newQuantity = currentQuantity + amountToAdd;
			medication.setQuantityInStock(String.valueOf(newQuantity));
		}
	}

	/**
	 * Parses a quantity string to an integer value.
	 */
	private int parseQuantity(String value) {
		try {
			return Integer.parseInt(value);
		} catch (NumberFormatException ex) {
			return 0;
		}
	}

	/**
	 * Finds a patient by name using case-insensitive search.
	 */
	private Patient findPatientByName(String name) {
		for (int i = 0; i < patientCount; i++) {
			if (patients[i].getName().equalsIgnoreCase(name)) {
				return patients[i];
			}
		}
		return null;
	}

	/**
	 * Finds a doctor by name using case-insensitive search.
	 */
	private Doctor findDoctorByName(String name) {
		for (int i = 0; i < doctorCount; i++) {
			if (doctors[i].getName().equalsIgnoreCase(name)) {
				return doctors[i];
			}
		}
		return null;
	}

	/**
	 * Finds a medication by name using case-insensitive search.
	 */
	private Medication findMedicationByName(String name) {
		for (int i = 0; i < medicationCount; i++) {
			if (medications[i].getName().equalsIgnoreCase(name)) {
				return medications[i];
			}
		}
		return null;
	}

	/**
	 * Finds the index of a patient by name.
	 */
	private int findPatientIndexByName(String name) {
		for (int i = 0; i < patientCount; i++) {
			if (patients[i].getName().equalsIgnoreCase(name)) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * Finds the index of a doctor by name.
	 */
	private int findDoctorIndexByName(String name) {
		for (int i = 0; i < doctorCount; i++) {
			if (doctors[i].getName().equalsIgnoreCase(name)) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * Finds the index of a medication by name.
	 */
	private int findMedicationIndexByName(String name) {
		for (int i = 0; i < medicationCount; i++) {
			if (medications[i].getName().equalsIgnoreCase(name)) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * Removes a patient from all doctors' patient lists.
	 */
	private void removePatientFromAllDoctors(Patient patient) {
		for (int i = 0; i < doctorCount; i++) {
			Doctor doctor = doctors[i];
			Patient[] managed = doctor.getPatients();
			int managedCount = doctor.getPatientCount();

			for (int j = 0; j < managedCount; j++) {
				if (managed[j] == patient) {
					doctor.removePatient(j);
					break;
				}
			}
		}
	}
}
