package lectures._21.namespacing;

public class Example
{
    public static String data = "This is a line of text";

    public static String getData() {
        return Example.data;
    }

    public static void setData(String value) {
        Example.data = value;
    }
}
