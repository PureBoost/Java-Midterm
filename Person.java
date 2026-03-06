/**
 * Represents a person in the pharmacy management system.
 * Base class for both Patient and Doctor.
 */
public class Person {
    private int id = 1;
    private String name = "John Doe";
    private int age  = 0;
    private String phoneNumber = "000-000-0000";

    /**
     * Constructs a new Person with basic personal details.
     */
    public Person(int id, String name, int age, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.phoneNumber = phoneNumber;
    }

    /**
     * Gets the unique identifier of this person.
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the unique identifier of this person.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets the name of this person.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of this person.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the age of this person.
     */
    public int getAge() {
        return age;
    }

    /**
     * Sets the age of this person.
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Gets the phone number of this person.
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Sets the phone number of this person.
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Returns a string representation of this person.
     */
    public String toString() {
        return "ID: " + id + " Name: " + name + " Age: " + age + " Phone Number: " + phoneNumber;
        }
}
