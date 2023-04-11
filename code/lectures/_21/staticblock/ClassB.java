package lectures._21.staticblock;

public class ClassB
{
    static {
        System.out.println("Class B Static-block");
    }

    public static void method() {
        System.out.println("Class B static method");
    }

    public void instanceeMethod() {
        System.out.println("Class B instance method");
    }

    public ClassB() {
        System.out.println("Class B constructor");
    }
}
