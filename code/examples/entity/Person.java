package examples.entity;

public class Person {
    //# Fields
    private String name;
    private int age;

    //# Constructor
    public Person(String name, int age) {
        this.setName(name);
        this.setAge(age);
    }

    //# Getter methods
    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    //# Setter methods
    public void setName(String value) {
        this.name = value;
    }

    private void setAge(int value) {
        this.age = value;
    }

    //# Methods
    @Override
    public String toString() {
        return "Person[name=\"%s\"; age=%d;]".formatted(
                this.getName(),
                this.getAge()
        );
    }
}
