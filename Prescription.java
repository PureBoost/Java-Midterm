import java.time.LocalDate;
import java.util.Random;

/**
 * Represents a prescription issued by a doctor for a patient.
 * Links a doctor, patient, and medication with a prescription expiry date.
 */
public class Prescription {
    private int id = 1;
    private Doctor doctor;
    private Patient patient;
    private Medication medication;
    private LocalDate prescriptionExpiry;

    /**
     * Constructs a new Prescription with linked doctor, patient, and medication.
     * The prescription expiry date is generated randomly.
     */
    public Prescription(int id, Doctor doctor, Patient patient, Medication medication) {
        this.id = id;
        this.doctor = doctor;
        this.patient = patient;
        this.medication = medication;
        this.prescriptionExpiry = generateRandomExpiryDate();
    }

    /**
     * Generates a random prescription expiry date.
     */
    private LocalDate generateRandomExpiryDate() {
        Random random = new Random();
        int randomDays = random.nextInt(731) - 365;
        return LocalDate.now().plusDays(randomDays);
    }

    /**
     * Gets the unique identifier of this prescription.
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the unique identifier of this prescription.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets the doctor who issued this prescription.
     */
    public Doctor getDoctor() {
        return doctor;
    }

    /**
     * Sets the doctor who issued this prescription.
     */
    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    /**
     * Gets the patient for this prescription.
     */
    public Patient getPatient() {
        return patient;
    }

    /**
     * Sets the patient for this prescription.
     */
    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    /**
     * Gets the medication associated with this prescription.
     */
    public Medication getMedication() {
        return medication;
    }

    /**
     * Sets the medication associated with this prescription.
     */
    public void setMedication(Medication medication) {
        this.medication = medication;
    }

    /**
     * Gets the expiry date of this prescription.
     */
    public LocalDate getPrescriptionExpiry() {
        return prescriptionExpiry;
    }

    /**
     * Sets the expiry date of this prescription.
     */
    public void setPrescriptionExpiry(LocalDate prescriptionExpiry) {
        this.prescriptionExpiry = prescriptionExpiry;
    }

    /**
     * Returns a string representation of this prescription.
     */
    public String toString() {
        return "ID: " + id + " Doctor: " + doctor + " Patient: " + patient + " Medication: " + medication + " Prescription Expiry: " + prescriptionExpiry;
    }
}
