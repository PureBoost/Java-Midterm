# Pharmacy Management System - User Documentation

### Application Overview
The Pharmacy Management System is an application designed to manage patient medications, prescriptions, doctors, and pharmaceutical inventory. this system provides a complete solution for tracking medications, managing patient-doctor relationships, and monitoring prescription data.





### Classes

## 1. Person (Super Class)
The foundational class for both Patient and Doctor classes.

# Attributes:
- `id` (int): Unique identifier for each person
- `name` (String): Person's full name
- `age` (int): Person's age
- `phoneNumber` (String): Contact phone number

# Key Methods:
- `getId()`, `setId(int)`: Get/set person ID
- `getName()`, `setName(String)`: Get/set person name
- `getAge()`, `setAge(int)`: Get/set person age
- `getPhoneNumber()`, `setPhoneNumber(String)`: Get/set phone number
- `toString()`: Returns formatted string with person details

# Purpose: 
Provides common attributes and methods inherited by Patient and Doctor classes, promoting code reusability.

## 2. Patient (Extends Person)
Represents a patient in the pharmacy system.

# Attributes:
- `medications[]` (Medication array): List of medications the patient is taking
- `prescriptions[]` (Prescription array): List of active prescriptions
- `medicationCount` (int): Number of medications assigned
- `prescriptionCount` (int): Number of prescriptions assigned

# Key Methods:
- `addMedication(Medication)`: Adds a medication to the patient's list
- `removeMedication(int)`: Removes a medication by index
- `addPrescription(Prescription)`: Adds a prescription to the patient's list
- `getMedications()`: Returns all medications
- `getPrescriptions()`: Returns all prescriptions
- `getMedicationCount()`: Returns count of medications
- `getPrescriptionCount()`: Returns count of prescriptions

# Purpose:
Manages individual patient data including their medications and prescription history.

## 3. Doctor (Extends Person)
Represents a doctor in the pharmacy system.

# Additional Attributes:
- `specialization` (String): Doctor's medical specialization
- `patients[]` (Patient array): List of patients under the doctor's care
- `patientCount` (int): Number of assigned patients

# Key Methods:
- `getSpecialization()`, `setSpecialization(String)`: Get/set specialization
- `addPatient(Patient)`: Assigns a patient to the doctor
- `removePatient(int)`: Removes a patient by index
- `getPatients()`: Returns all assigned patients
- `getPatientCount()`: Returns count of patients
- `toString()`: Returns formatted string with doctor details including specialization

# Purpose:
Manages doctor information and tracks their patient assignments.

## 4. Medication
Represents a medication in the pharmacy inventory.

# Attributes:
- `id` (int): Unique medication identifier
- `name` (String): Medication name
- `dosage` (String): Dosage information (e.g., "100mg")
- `quantityInStock` (String): Current stock quantity
- `expiryDate` (LocalDate): Expiration date

# Key Methods:
- `getId()`, `setId(int)`: Get/set medication ID
- `getName()`, `setName(String)`: Get/set medication name
- `getDosage()`, `setDosage(String)`: Get/set dosage information
- `getQuantityInStock()`, `setQuantityInStock(String)`: Get/set stock quantity
- `getExpiryDate()`, `setExpiryDate(LocalDate)`: Get/set expiry date
- `isExpired()`: Checks if medication is expired
- `generateRandomExpiryDate()`: Generates random expiry date (past or future)
- `toString()`: Returns formatted string with medication details

# Purpose:
Tracks medication inventory, stock levels, and expiration dates to ensure safe dispensing.

## 5. Prescription
Represents a prescription issued by a doctor for a patient.

# Attributes:
- `id` (int): Unique prescription identifier
- `doctor` (Doctor): Prescribing doctor
- `patient` (Patient): Patient receiving the prescription
- `medication` (Medication): Prescribed medication
- `prescriptionExpiry` (LocalDate): Prescription expiration date

# Key Methods:
- `getId()`, `setId(int)`: Get/set prescription ID
- `getDoctor()`, `setDoctor(Doctor)`: Get/set prescribing doctor
- `getPatient()`, `setPatient(Patient)`: Get/set patient
- `getMedication()`, `setMedication(Medication)`: Get/set medication
- `getPrescriptionExpiry()`, `setPrescriptionExpiry(LocalDate)`: Get/set expiry date
- `generateRandomExpiryDate()`: Generates random expiry date
- `toString()`: Returns formatted string with prescription details

# Purpose:
Links doctors, patients, and medications together to track prescription information.

## 6. MedicationSystem
The main system class that manages all entities and operations.

# Attributes:
- `patients[]` (Patient array): All patients in the system
- `doctors[]` (Doctor array): All doctors in the system
- `medications[]` (Medication array): All medications in inventory
- `prescriptions[]` (Prescription array): All prescriptions issued
- Count variables for each entity type

# Key Methods:

# Adding Operations:
- `addPatient(Patient)`: Adds a new patient to the system
- `addDoctor(Doctor)`: Adds a new doctor to the system
- `addMedication(Medication)`: Adds a new medication to inventory

# Search Operations:
- `searchPatientDetails(String)`: Searches for patient by name
- `searchDoctorDetails(String)`: Searches for doctor by name
- `searchMedicationDetails(String)`: Searches for medication by name

# Management Operations:
- `addPatientToDoctor(String, String)`: Assigns a patient to a doctor
- `acceptPrescription(int, String, String, String)`: Creates a new prescription

# Edit Operations:
- `editMedication(String, String, String, String)`: Updates medication details
- `editPatient(String, String, int, String)`: Updates patient information
- `editDoctor(String, String, int, String, String)`: Updates doctor information

# Delete Operations:
- `deleteMedication(String)`: Removes a medication from inventory
- `deletePatient(String)`: Removes a patient from the system
- `deleteDoctor(String)`: Removes a doctor from the system

# Reporting Operations:
- `generateReport()`: Generates comprehensive system report
- `checkExpiredMedications()`: Reports all expired medications
- `getPrescriptionsByDoctor(String)`: Lists all prescriptions by a specific doctor
- `pastYearPrescriptionReport()`: Reports prescriptions from the past year

# Inventory Operations:
- `restockMedication(String, int)`: Restocks a specific medication
- `restockAllMedications(int, int)`: Restocks all medications with random amounts

# Purpose:
Central management hub that coordinates all system operations and maintains data integrity.





### How to Start the Application

## Step 1: Compile the Java Files
Open a terminal/command prompt in the project directory and run:

javac *.java


## Step 2: Run the Application
Execute the Test class to start the system:

java Test


## Step 3: Observe Output
The test program will demonstrate all system functionalities and display results to the console.