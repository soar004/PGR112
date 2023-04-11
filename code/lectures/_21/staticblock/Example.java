package lectures._21.staticblock;

import java.util.ArrayList;

public class Example
{
    public static void main(String[] args) {

        ClassA.method();
        ClassB.method();

        ClassA classA1 = new ClassA();
        ClassA classA2 = new ClassA();
        ClassA classA3 = new ClassA();

        ClassB classB1 = new ClassB();
        ClassB classB2 = new ClassB();
        ClassB classB3 = new ClassB();

        classB2.method();
        classB2.instanceeMethod();
    }
}
