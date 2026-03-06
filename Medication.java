import java.time.LocalDate;
import java.util.Random;

/**
 * Represents a medication in the pharmacy inventory.
 * Tracks medication details including stock levels and expiration dates.
 */
public class Medication {
    private int id = 1;
    private String name = "Medication Name";
    private String dosage = "Dosage Information";
    private String quantityInStock = "0";
    private LocalDate expiryDate;

    /**
     * Constructs a new Medication with specified details.
     * The expiry date is generated randomly.
     */
    public Medication(int id, String name, String dosage, String quantityInStock, String expiryDate) {
        this.id = id;
        this.name = name;
        this.dosage = dosage;
        this.quantityInStock = quantityInStock;
        this.expiryDate = generateRandomExpiryDate();
    }

    /**
     * Generates a random expiry date ranging from 365 days in the past to 365 days in the future.
     */
    private LocalDate generateRandomExpiryDate() {
        Random random = new Random();
        int randomDays = random.nextInt(730) - 365;
        return LocalDate.now().plusDays(randomDays);
    }

    /**
     * Gets the expiration date of this medication.
     */
    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    /**
     * Sets the expiration date of this medication.
     */
    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    /**
     * Checks if this medication is expired.
     */
    public boolean isExpired() {
        return expiryDate.isBefore(LocalDate.now());
    }

    /**
     * Gets the unique identifier for this medication.
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the unique identifier for this medication.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets the name of this medication.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of this medication.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the dosage information for this medication.
     */
    public String getDosage() {
        return dosage;
    }

    /**
     * Sets the dosage information for this medication.
     */
    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    /**
     * Gets the quantity in stock for this medication.
     */
    public String getQuantityInStock() {
        return quantityInStock;
    }

    /**
     * Sets the quantity in stock for this medication.
     */
    public void setQuantityInStock(String quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    /**
     * Returns a string representation of this medication including all details.
     */
    public String toString() {
        return "ID: " + id + " Name: " + name + " Dosage: " + dosage + " Quantity in Stock: " + quantityInStock + " Expiry Date: " + expiryDate;
    }
}

