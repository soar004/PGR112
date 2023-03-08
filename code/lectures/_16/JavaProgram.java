package lectures._16;

public class JavaProgram
{
    public static void main(String[] args) {
        Waffle vaffel1 = WaffleFactory.createWaffleWithStrawberryJam(false, false);

        System.out.println(vaffel1);

        WaffleBuilder vaffelBygger =  new WaffleBuilder();

        vaffelBygger
                .addTopping(WaffleFactory.waffleToppings.get("Jordbærsyltetøy"))
                .addTopping(WaffleFactory.waffleToppings.get("Sukker"))
                .addTopping(WaffleFactory.waffleToppings.get("Brunost"))
                .setGlutenFree(true);

        Waffle vaffel2 = vaffelBygger.build();

        System.out.println(vaffel2);



    }
}
