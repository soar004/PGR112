package lectures._21.namespacing;

public class JavaProgram
{
    public static void main(String[] args) {

        Example example = new Example();

        System.out.println(Example.getData());
        System.out.println(example.data);

        Example.setData("This is now another line of text!");

        System.out.println(Example.getData());
        System.out.println(example.data);

        // Bruk Singleton istedenfor kun statisk kontekst i en klasse!
    }
}
