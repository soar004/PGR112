package lectures._17.pkg;

import lectures._17.Lecture17;
import solutions.large01._01.MiniBank;

public class Packages {
    public static void main(String[] args) {
        Lecture17 lecture = new Lecture17();

        lecture = null;

        MiniBank.main(new String[]{});
    }
}
