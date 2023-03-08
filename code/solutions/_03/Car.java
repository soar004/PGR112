package solutions._03;

public class Car
{
    private String model;
    private int year;
    private int horsePower;

    private CarEngineType engine;


    public Car(String model, int year, int horsePower) {
        this.model = model;
        this.year = year;
        this.horsePower = horsePower;
    }


    public String getModel() {
        return this.model;
    }

    public int getYear() {
        return this.year;
    }

    public int getHorsePower() {
        return this.horsePower;
    }

    public CarEngineType getEngine() {
        return this.engine;
    }

    public void setModel(String value) {
        this.model = value;
    }

    public void setYear(int value) {
        this.year = value;
    }

    public void setHorsePower(int value) {
        this.horsePower = value;
    }

    public void setEngine(CarEngineType value) {
        this.engine = value;
    }


    public void printState() {
        System.out.println(
                "Model of the car: " + this.getModel()
        );

        System.out.println(
                "Year the car was released: " + this.getYear()
        );

        System.out.println(
                "Horse power the car has: " + this.getHorsePower()
        );

        System.out.println(
                "Type of engine in the car: " + this.getEngine()
        );
    }


    public static void main(String[] args) {
        Car futuristicCar = new Car("Smart Car 3000", 2032, 9001);

        futuristicCar.setEngine(CarEngineType.HYBRID);

        futuristicCar.printState();
    }
}