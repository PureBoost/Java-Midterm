// Superclass, The Prescription class represents a prescription issued by a doctor for a patient
public class Prescription {
    private int id = 1;
    private String doctor = "REFRENCE DOCTOR CLASS";
    private String patient = "REFRENCE PATIENT CLASS";
    private String medication = "REFRENCE MEDICATION CLASS";
    private String prescriptionExpiry = "00/00/0000";

    // Constructor
    public Prescription(int id, String doctor, String patient, String medication, String prescriptionExpiry) {
        this.id = id;
        this.doctor = doctor;
        this.patient = patient;
        this.medication = medication;
        this.prescriptionExpiry = prescriptionExpiry;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }

    public String getPatient() {
        return patient;
    }

    public void setPatient(String patient) {
        this.patient = patient;
    }

    public String getMedication() {
        return medication;
    }

    public void setMedication(String medication) {
        this.medication = medication;
    }

    public String getPrescriptionExpiry() {
        return prescriptionExpiry;
    }

    public void setPrescriptionExpiry(String prescriptionExpiry) {
        this.prescriptionExpiry = prescriptionExpiry;
    }

    public String toString() {
        return "ID: " + id + " Doctor: " + doctor + " Patient: " + patient + " Medication: " + medication + " Prescription Expiry: " + prescriptionExpiry;
    }
}
