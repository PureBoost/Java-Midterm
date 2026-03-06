/**
 * Represents a doctor in the pharmacy management system.
 * Each doctor has a specialization and a list of patients they are managing.
 */
public class Doctor extends Person {
	private String specialization;
	private Patient[] patients;
	private int patientCount = 0;

	/**
	 * Constructs a new Doctor with personal details and specialization.
	 * Initializes an empty patient list with capacity of 100.
	 */
	public Doctor(int id, String name, int age, String phoneNumber, String specialization) {
		super(id, name, age, phoneNumber);
		this.specialization = specialization;
		this.patients = new Patient[100];
	}

	/**
	 * Gets the medical specialization of this doctor.
	 */
	public String getSpecialization() {
		return specialization;
	}

	/**
	 * Sets the medical specialization of this doctor.
	 */
	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	/**
	 * Gets all patients managed by this doctor.
	 */
	public Patient[] getPatients() {
		return patients;
	}

	/**
	 * Gets the count of patients currently managed by this doctor.
	 */
	public int getPatientCount() {
		return patientCount;
	}

	/**
	 * Adds a patient to this doctor's patient list.
	 */
	public void addPatient(Patient patient) {
		if (patientCount < patients.length) {
			patients[patientCount++] = patient;
		}
	}

	/**
	 * Removes a patient from this doctor's patient list by index.
	 */
	public void removePatient(int index) {
		if (index >= 0 && index < patientCount) {
			for (int i = index; i < patientCount - 1; i++) {
				patients[i] = patients[i + 1];
			}
			patientCount--;
		}
	}

	/**
	 * Returns a string representation of this doctor including specialization and patient count.
	 */
	public String toString() {
		return super.toString() + " | Specialization: " + specialization + " | Patients: " + patientCount;
	}
}
