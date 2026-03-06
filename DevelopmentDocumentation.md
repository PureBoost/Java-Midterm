# Pharmacy Management System - Development Documentation

### Source Code Directory Structure

This project uses a single-folder Java structure where each class has their own file.

Java Midterm/
- DevelopmentDocumentation.md
- Person.java
- Patient.java
- Doctor.java
- Medication.java
- Prescription.java
- MedicationSystem.java
- Test.java
- UserDocumentation.md





### Build Process

## 1 Open terminal in project folder

Crtl + Shift + `

Make sure your in the Java Midterm Folder on the command line. (.../Java Midterm)

## 2 Compile all source files

Compile every Java file in the folder:

javac *.java

This command generates `.class` files for each `.java` file.

## 3 Run the program

Run the test entry point:

java Test

The console will print the output from the system demo in `Test.java`.





### Compiler-Time Dependencies

This project has very light compile-time dependencies.

## Required packages

The code uses only built-in Java packages (no external libraries):

- `java.time.LocalDate`
	- Used in `Medication` and `Prescription` for expiry date handling.

- `java.util.Random`
	- Used for random expiry date generation and random restocking behavior.





### Development Standards

These are the development standards used in this project.

## 1 Naming conventions

- Class names use PascalCase (example: `MedicationSystem`, `Prescription`).
- Method and variable names use camelCase (example: `addPatient`, `medicationCount`).
- File names match class names exactly (example: `Doctor.java` contains `Doctor` class).

## 2 Class design standards

- One main public class per file.
- Shared person fields are centralized in the superclass `Person`.
- `Patient` and `Doctor` extend `Person` to reduce duplicate code.

## 3 Code formatting standards

- Keep indentation consistent within each file.
- Use clear spacing and line breaks for readability.
- Keep methods focused on one main task.
- Use comments/Javadocs to explain class and method purpose.

## 4 Defensive programming standards

- Check array capacity before adding new items.
- Use safe parsing for stock quantity conversion.

## 5 Project structure standards

- Keep all source files in one folder.
- Keep documentation files separate from Java source files.
- Use `Test.java` as the execution entry point for demos.

## 6 Version control standards

- Use Git for source tracking.
- Make clear commits grouped by feature or fix.

## 7 Quality standards for this assignment

- Code should compile cleanly with `javac *.java`.
- Console output should clearly show results of each system operation.
- Documentation should be detailed, organized, and readable.





### Database Design

The project uses arrays in memory, but in a real system this data would be stored in a relational database.

## Example PostgresSQL

CREATE TABLE persons (
  person_id INT PRIMARY KEY,
  name VARCHAR(100) NOT NULL,
  age INT NOT NULL,
  phone_number VARCHAR(30)
);

CREATE TABLE doctors (
  doctor_id INT PRIMARY KEY,
  specialization VARCHAR(100) NOT NULL,
  FOREIGN KEY (doctor_id) REFERENCES persons(person_id)
);

CREATE TABLE patients (
  patient_id INT PRIMARY KEY,
  FOREIGN KEY (patient_id) REFERENCES persons(person_id)
);

CREATE TABLE medications (
  medication_id INT PRIMARY KEY,
  name VARCHAR(100) NOT NULL,
  dosage VARCHAR(100) NOT NULL,
  quantity_in_stock INT NOT NULL,
  expiry_date DATE NOT NULL
);

CREATE TABLE prescriptions (
  prescription_id INT PRIMARY KEY,
  doctor_id INT NOT NULL,
  patient_id INT NOT NULL,
  medication_id INT NOT NULL,
  prescription_expiry DATE NOT NULL,
  FOREIGN KEY (doctor_id) REFERENCES doctors(doctor_id),
  FOREIGN KEY (patient_id) REFERENCES patients(patient_id),
  FOREIGN KEY (medication_id) REFERENCES medications(medication_id)
);

CREATE TABLE doctor_patients (
  doctor_id INT NOT NULL,
  patient_id INT NOT NULL,
  PRIMARY KEY (doctor_id, patient_id),
  FOREIGN KEY (doctor_id) REFERENCES doctors(doctor_id),
  FOREIGN KEY (patient_id) REFERENCES patients(patient_id)
);




### How to Get the Source Code from GitHub

## Step 1: Clone the repository

Open a terminal and run:

git clone https://github.com/PureBoost/Java-Midterm

## Step 2: Navigate into the project folder


cd Java Midterm

## Step 3: Compile and run

Follow the build process from earlier in this document:


javac *.java

Then 

java Test

## Download as ZIP

Go to: https://github.com/PureBoost/Java-Midterm in your browser

Click: Code

Click: Download ZIP

### Class Diagram

  # class Person {
      -int id
      -String name
      -int age
      -String phoneNumber
      +getId()
      +getName()
      +getAge()
      +getPhoneNumber()
      +toString()
    }

  # class Patient {
      -Medication[] medications
      -Prescription[] prescriptions
      -int medicationCount
      -int prescriptionCount
      +addMedication(Medication)
      +addPrescription(Prescription)
      +removeMedication(int)
      +getMedications()
      +getPrescriptions()
    }

  # class Doctor {
      -String specialization
      -Patient[] patients
      -int patientCount
      +addPatient(Patient)
      +removePatient(int)
      +getPatients()
      +getSpecialization()
    }

  # class Medication {
      -int id
      -String name
      -String dosage
      -String quantityInStock
      -LocalDate expiryDate
      +isExpired()
      +toString()
    }

  # class Prescription {
      -int id
      -Doctor doctor
      -Patient patient
      -Medication medication
      -LocalDate prescriptionExpiry
      +getDoctor()
      +getPatient()
      +getMedication()
      +toString()
    }

  # class MedicationSystem {
      -Patient[] patients
      -Doctor[] doctors
      -Medication[] medications
      -Prescription[] prescriptions
      +addPatient(Patient)
      +addDoctor(Doctor)
      +addMedication(Medication)
      +acceptPrescription(int,String,String,String)
      +generateReport()
      +checkExpiredMedications()
      +restockAllMedications(int,int)
    }