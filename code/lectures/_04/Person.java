package lectures._04;

public class Person
{
    //# Felter
    private String name;
    private int age;

    private String phrase = "";

    //# Konstruktør
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    //# Gettere
    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public String getPhrase() {
        return this.phrase;
    }

    //# Settere
    public void setName(String value) {
        this.name = value;
    }

    public void setAge(int value) {
        this.age = value;
    }

    public void setPhrase(String value) {
        this.phrase = value;
    }

    //# Metoder
    public void increaseAge() {
        this.age = this.age + 1;
    }

    public void birthday() {
        this.increaseAge();
    }
}
