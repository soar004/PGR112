package lectures._21.staticblock;

public class ClassA
{
    static {
        System.out.println("Class A Static-block");
    }

    public static void method() {
        System.out.println("Class A static method");
    }

    public ClassA() {
        System.out.println("Class A constructor");
    }
}
