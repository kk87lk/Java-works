public class Test {

    public static void main(String[] args) {
        PlantFarm plantFarm = new PlantFarm();
        AnimalFarm animalFarm = new AnimalFarm();
        Shop shop = new Shop(plantFarm, animalFarm);
        shop.printMenu();
    }
}