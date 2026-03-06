public class Test {
	public static void main(String[] args) {
		MedicationSystem system = new MedicationSystem();

		Doctor doctor = new Doctor(1, "Alice Smith", 45, "555-111-2222", "Cardiology");
		Patient patient = new Patient(1, "Bob Jones", 30, "555-333-4444");
		Medication medication = new Medication(1, "Aspirin", "100mg", "25", "01/01/2030");

		system.addDoctor(doctor);
		system.addPatient(patient);
		system.addMedication(medication);

		system.addPatientToDoctor("Bob Jones", "Alice Smith");
		system.acceptPrescription(1, "Alice Smith", "Bob Jones", "Aspirin");

		System.out.println(system.searchDoctorDetails("Alice Smith"));
		System.out.println();
		System.out.println(system.searchPatientDetails("Bob Jones"));
		System.out.println();
		System.out.println(system.searchMedicationDetails("Aspirin"));
		System.out.println();

		System.out.println(system.getPrescriptionsByDoctor("Alice Smith"));
		System.out.println();
		System.out.println(system.pastYearPrescriptionReport());
		System.out.println();

		System.out.println(system.checkExpiredMedications());
		System.out.println();

		system.restockAllMedications(5, 15);
		System.out.println(system.searchMedicationDetails("Aspirin"));
		System.out.println();

		System.out.println(system.generateReport());
	}
}
