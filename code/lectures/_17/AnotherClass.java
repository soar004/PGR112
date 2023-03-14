package lectures._17;

import lectures._17.extra.ObjectWithDate;

import java.util.HashMap;

public class AnotherClass {
    public static void main(String[] args) {
        Lecture17 lecture = new Lecture17();
        System.out.println(lecture.date);
        HashMap<String, String> actualQuotes = new HashMap<>();

        // lecture.quotes = actualQuotes;


        ObjectWithDate object = new ObjectWithDate();

        System.out.println(object.getDate());
    }
}
