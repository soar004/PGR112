package lectures._12;

interface Animal
{
    String getName();

    default void makeNoise() {
        System.out.println("Jeg er et dyr!");
    }
}

class Cat implements Animal {
    private String name;

    public Cat(String name) {
        this.setName(name);
    }

    @Override
    public String getName() {
        return this.name;
    }

    public void setName(String value) {
        this.name = value;
    }

    // Her overskriver vi default implementasjonen fra grensesnittet
    @Override
    public void makeNoise() {
        System.out.println("Jeg er en katt!");
    }
}