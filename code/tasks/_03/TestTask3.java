package tasks._03;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.stream.Stream;


@DisplayName("Oppgavesett 03")
public class TestTask3
{
    @Test
    @DisplayName("Klassen \"Book\" eksisterer")
    //# Oppgave 3
    void classCreated() {
        //# Check if class has been created
        assertDoesNotThrow(
                () -> Class.forName("tasks._03.src.Book"),
                "Klassen \"Book\" eksisterer ikke!"
        );
    }

    @Test
    @DisplayName("Klassen \"Book\" eksisterer med 3 felter")
    //# Oppgave 3
    void classCreatedWithThreeFields() {
        //# Check if class has been created
        this.classCreated();

        try {
            Class<?> BookClass = Class.forName("tasks._03.src.Book");

            Field[] fields = BookClass.getDeclaredFields();

            assertTrue(fields.length >= 3, "Er forventet at det er minst 3 felter i klassen Book");

            String[] fieldNames = new String[] {
                    "title",
                    "author",
                    "numberOfPages"
            };

            for (Field field : fields) {
                assertTrue(
                        Stream.of(fieldNames).anyMatch(
                                name -> name.equals(field.getName())
                        ),
                        "Feltet \"%s\" eksisterer ikke i klassen Book!".formatted(field.getName())
                );
            }
        } catch (ClassNotFoundException ignored) {}
    }
}
