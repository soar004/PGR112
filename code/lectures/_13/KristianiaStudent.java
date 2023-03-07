package lectures._13;

public class KristianiaStudent {
    private String name;
    private int age;

    // Her velger vi static, da vi ikke ønsker at hver
    // eneste instans av en KristianiaStudent skal lagre
    // følgende String-verdi i minne, trenger det kun ét sted!
    private static final String school = "Kristiania";

    public KristianiaStudent(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    private void setName(String value) {
        this.name = value;
    }

    private void setAge(int value) {
        this.age = value;
    }
}