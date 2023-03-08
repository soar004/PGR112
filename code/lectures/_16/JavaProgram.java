package lectures._16;

public class JavaProgram
{
    public static void main(String[] args) {
        Waffle vaffel = WaffleFactory.createWaffleWithStrawberryJam(false, false);

        System.out.println(vaffel);
    }
}
