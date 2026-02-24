// Superclass, The Medication class represents a medication. It contains the following attributes:

import java.time.LocalDate;
import java.util.Random;

public class Medication {
    private int id = 1;
    private String name = "Medication Name";
    private String dosage = "Dosage Information";
    private String quantityInStock = "0";
    private LocalDate expiryDate;

    // Constructor
    public Medication(int id, String name, String dosage, String quantityInStock, String expiryDate) {
        this.id = id;
        this.name = name;
        this.dosage = dosage;
        this.quantityInStock = quantityInStock;
        this.expiryDate = generateRandomExpiryDate();
    }

    // Generate random expiry date
    private LocalDate generateRandomExpiryDate() {
        Random random = new Random();
        int randomDays = random.nextInt(730) - 365;
        return LocalDate.now().plusDays(randomDays);
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    public boolean isExpired() {
        return expiryDate.isBefore(LocalDate.now());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    public String getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(String quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    public String toString() {
        return "ID: " + id + " Name: " + name + " Dosage: " + dosage + " Quantity in Stock: " + quantityInStock + " Expiry Date: " + expiryDate;
    }
}

