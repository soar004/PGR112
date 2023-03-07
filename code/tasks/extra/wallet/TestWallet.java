package tasks.extra.wallet;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import tasks.extra.wallet.src.Wallet;


public class TestWallet {
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    Wallet wallet = new Wallet();

    //# Preparation
    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(this.outputStreamCaptor));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }

    //# Helper
    /** Local helper method */
    private String getOutputString() {
        return outputStreamCaptor.toString().replaceAll("\\p{Cntrl}", "");
    }

    //# Tests
    @Test
    @DisplayName("Printer konstruktøren ut noe som helst som tekst til terminalen?")
    public void testWalletConstructionPrintsAnyLengthAboutCoins() {
        wallet.printCoins();

        assertTrue(this.getOutputString().length() > 0);
    }

    @Test
    @DisplayName("Eksisterer feltet \"zipper\" med datatypen boolean?")
    public void testWalletZipperExistsAsFieldTypeBoolean() throws NoSuchFieldException {
        String fieldName = "zipper";
        Field field;

        try {
            field = wallet.getClass().getDeclaredField(fieldName);
        }
        catch (NoSuchFieldException e) {
            throw new NoSuchFieldException("Kunne ikke finne feltet \"zipper\" inne i klassen");
        }

        assertEquals(Modifier.PRIVATE, field.getModifiers(), "Feltet har ikke private tilgangsmodifikator");
        assertTrue(field.getType().isPrimitive(), "Feltets typeforventet å være av en primitiv datatype");
        assertEquals(field.getType().toString(), "boolean", "Feltet er forventet å være booleansk");
    }

    @Test
    @DisplayName("Kan lommeboken åpnes og lukkes?")
    public void testWalletZipperCanOpenAndClose() throws NoSuchMethodException {
        Method open;
        Method close;

        // open zipper functionality
        try {
            open = wallet.getClass().getDeclaredMethod("zipperOpen");
        }
        catch(NoSuchMethodException e) {
            throw new NoSuchMethodException("Kunne ikke finne en metode med navn zipperOpen");
        }

        assertEquals(Modifier.PUBLIC, open.getModifiers(), "På grunn av innkapsling, forventer vi at zipperOpen er public");
        assertEquals(open.getReturnType().toString(), "void", "Vi forventer at zipperOpen ikke skal returnere noe");

        // close zipper functionality
        try {
            close = wallet.getClass().getDeclaredMethod("zipperClose");
        }
        catch(NoSuchMethodException e) {
            throw new NoSuchMethodException("Kunne  ikke finne en metode med navn zipperOpen");
        }

        assertEquals(Modifier.PUBLIC, close.getModifiers(), "På grunn av innkapsling, forventer vi at zipperClose er public");
        assertEquals(close.getReturnType().toString(), "void", "Vi forventer at zipperClose ikke skal returnere noe");

    }
}
