package lectures._12;

public class ExampleSwitchCases {
    public static void main(String[] args) {
        String[] tags = new String[] {
                "FOO",
                "BAR",
                "BAZ"
        };

        // Her velges manuelt hvilken case som skal kjøres
        String tag = tags[0];

        switch (tag) {
            case "FOO" -> fooMethod();
            case "BAR" -> barMethod();
            case "BAZ" -> bazMethod();
        }
    }

    private static void fooMethod() {
        System.out.println("foo");
    }

    private static void barMethod() {
        System.out.println("bar");
    }

    private static void bazMethod() {
        System.out.println("baz");
    }
}
