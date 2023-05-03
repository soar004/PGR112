package solutions._19;

public class Shop {
    public static void main(String[] args) {
        Storage storage = Storage.getStorage();

        storage.addProduct(24, "Vannflaske", 19);
        storage.addProduct(12, "Pepsi Max Boks", 14);
        storage.addProduct(100, "Eple", 5);

        storage.getInventory().printInformation();
    }
}
