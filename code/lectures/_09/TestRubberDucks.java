package lectures._09;

public class TestRubberDucks
{
    public static void main(String[] args) {
        RubberDuck rubberduck1 = new RubberDuck(true);
        RubberDuck rubberduck2 = new RubberDuck("green", false, false);

        if (rubberduck1.doesMakeSound()) {
            System.out.println("Den første gummianden lager lyd!");

            System.out.println(rubberduck1);
        }

        if (rubberduck2.hasEyelashes()) {
            System.out.println("Den andre anden har øyevipper");
        }
        else {
            System.out.println("Den andre anden har ikke øyevipper");
        }
    }
}
