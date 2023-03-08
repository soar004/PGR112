package lectures._05.bank;

public class Terminal
{
    public static void clear() {
        System.out.print('\u000C');
    }

    public static void info(String topic, String message) {
        System.out.printf("[%s]: %s%n", topic, message);
    }
}