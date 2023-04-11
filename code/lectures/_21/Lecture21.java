package lectures._21;

import lectures._21.webshop.Store;


public class Lecture21
{
    public static void main(String[] args) {
        Store.Registration registration = new Store.Registration(
                1,
                "Nettbutikken I Norge",
                918273645L,
                Store.Type.Digital
        );

        Store.addRegistration(registration);


        try {
            Store store = new Store(registration);


        } catch(Exception e) {
            e.printStackTrace();
        }

    }
}
