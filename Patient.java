
// The Patient class represents a patient. It contains the following attributes:
public class Patient extends Person {
    private Medication[] medications;
    private Prescription[] prescriptions;
    private int medicationCount = 0;
    private int prescriptionCount = 0;

    // Constructor
    public Patient(int id, String name, int age, String phoneNumber) {
        super(id, name, age, phoneNumber);
        this.medications = new Medication[100];
        this.prescriptions = new Prescription[100];
    }

    // Medications Management
    public Medication[] getMedications() {
        return medications;
    }

    public void addMedication(Medication medication) {
        if (medicationCount < medications.length) {
            medications[medicationCount++] = medication;
        }
    }

    public void removeMedication(int index) {
        if (index >= 0 && index < medicationCount) {
            for (int i = index; i < medicationCount - 1; i++) {
                medications[i] = medications[i + 1];
            }
            medicationCount--;
        }
    }

    public int getMedicationCount() {
        return medicationCount;
    }

    // Prescriptions Management
    public Prescription[] getPrescriptions() {
        return prescriptions;
    }

    public void addPrescription(Prescription prescription) {
        if (prescriptionCount < prescriptions.length) {
            prescriptions[prescriptionCount++] = prescription;
        }
    }

    public void removePrescription(int index) {
        if (index >= 0 && index < prescriptionCount) {
            for (int i = index; i < prescriptionCount - 1; i++) {
                prescriptions[i] = prescriptions[i + 1];
            }
            prescriptionCount--;
        }
    }

    public int getPrescriptionCount() {
        return prescriptionCount;
    }

    public String toString() {
        return super.toString() + " | Medications: " + medicationCount + " | Prescriptions: " + prescriptionCount;
    }
}
