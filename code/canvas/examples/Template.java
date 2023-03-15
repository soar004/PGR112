package canvas.examples;

import canvas.API;
import canvas.Plugin;
import canvas.Program;

/*
 * Utgangspunkt som kan brukes for å komme i gang
 *
 * For å bruke det visuelle grensesnittet utenfor mappene:
 *  - code/canvas/sandbox/*
 *  - student/BRUKERNAVN/canvas/*
 *
 * Så trenger du main-metoden nedenfor.
 */

public class Template extends Plugin
{
    public static void main(String[] args) {
        Program.run(new Template());
    }

    public void render(API canvas) {
        // programkode
    }
}
