package lectures._06;

import java.time.LocalDate;
import java.time.LocalTime;

public class Terminal {
    public static void clear() {
        System.out.print('\u000c');
    }

    public static void log(String context, String message) {
        LocalDate date = LocalDate.now();
        LocalTime time = LocalTime.now();

        System.out.printf("[%s][%s][%s]: %s%n", date, time, context, message);
    }
}