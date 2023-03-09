package examples.project.bank;

public class Person {
    private String name;
    private long securityNumber; // fødelsnumber


    public String getName() {
        return this.name;
    }
    public long getSecurityNumber() {
        return this.securityNumber;
    }

    public void setName(String value) {
        this.name = value;
    }

    public void setSecurityNumber(long value) {
        this.securityNumber = value;
    }

    //# Constructor
    public Person(String name, long securityNumber) {
        this.setName(name);
        this.setSecurityNumber(securityNumber);
    }
}
