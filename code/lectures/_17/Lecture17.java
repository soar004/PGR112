package lectures._17;


import java.util.HashMap;

public class Lecture17
{
    String date;
    final HashMap<String, String> quotes = new HashMap<>();

    public Lecture17() {
        this.date = "2022-03-14";
    }



    // package-private
    String aMethodNameWithoutAccessModifier() {
        return "package-private";
    }

    private void aMethodNameHere() {

    }

    protected void aProtectedMethodNameHere() {

    }

    public static void main(String[] args) {

    }
}
