// Superclass, The Person class is the base class for both the Patient and Doctor classes.
public class Person {
    private int id = 1;
    private String name = "John Doe";
    private int age  = 0;
    private String phoneNumber = "000-000-0000";

    public Person(int id, String name, int age, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.phoneNumber = phoneNumber;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String toString() {
        return "ID: " + id + " Name: " + name + " Age: " + age + " Phone Number: " + phoneNumber;
        }
}
