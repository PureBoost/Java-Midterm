
/**
 * Represents a patient in the pharmacy management system.
 * Manages patient medications and prescriptions.
 */
public class Patient extends Person {
    private Medication[] medications;
    private Prescription[] prescriptions;
    private int medicationCount = 0;
    private int prescriptionCount = 0;

    /**
     * Constructs a new Patient with specified personal details.
     * Initializes empty arrays for medications and prescriptions.
     */
    public Patient(int id, String name, int age, String phoneNumber) {
        super(id, name, age, phoneNumber);
        this.medications = new Medication[100];
        this.prescriptions = new Prescription[100];
    }

    /**
     * Gets all medications assigned to this patient.
     */
    public Medication[] getMedications() {
        return medications;
    }

    /**
     * Adds a medication to this patient's medication list.
     */
    public void addMedication(Medication medication) {
        if (medicationCount < medications.length) {
            medications[medicationCount++] = medication;
        }
    }

    /**
     * Removes a medication from this patient's medication list by index.
     */
    public void removeMedication(int index) {
        if (index >= 0 && index < medicationCount) {
            for (int i = index; i < medicationCount - 1; i++) {
                medications[i] = medications[i + 1];
            }
            medicationCount--;
        }
    }

    /**
     * Gets the count of medications assigned to this patient.
     */
    public int getMedicationCount() {
        return medicationCount;
    }

    /**
     * Gets all prescriptions for this patient.
     */
    public Prescription[] getPrescriptions() {
        return prescriptions;
    }

    /**
     * Adds a prescription to this patient's prescription list.
     */
    public void addPrescription(Prescription prescription) {
        if (prescriptionCount < prescriptions.length) {
            prescriptions[prescriptionCount++] = prescription;
        }
    }

    /**
     * Removes a prescription from this patient's prescription list by index.
     */
    public void removePrescription(int index) {
        if (index >= 0 && index < prescriptionCount) {
            for (int i = index; i < prescriptionCount - 1; i++) {
                prescriptions[i] = prescriptions[i + 1];
            }
            prescriptionCount--;
        }
    }

    /**
     * Gets the count of prescriptions assigned to this patient.
     */
    public int getPrescriptionCount() {
        return prescriptionCount;
    }

    /**
     * Returns a string representation of this patient including medication and prescription counts.
     */
    public String toString() {
        return super.toString() + " | Medications: " + medicationCount + " | Prescriptions: " + prescriptionCount;
    }
}
