import java.util.Iterator;

public class Shop {

    PlantFarm plantFarm;

    AnimalFarm animalFarm;

    public Shop(PlantFarm plantFarm, AnimalFarm animalFarm) {
        this.plantFarm = plantFarm;
        this.animalFarm = animalFarm;
    }

    public void printMenu() {
        Iterator<FarmItem> iterator = plantFarm.createIterator();
        Iterator<FarmItem> iterator1 = animalFarm.createIterator();
        System.out.println("农场为：");
        printMenu(iterator);
        System.out.println("牧场为：");
        printMenu(iterator1);
    }

    private void printMenu(Iterator iterator) {
        while (iterator.hasNext()) {
            FarmItem farmItem = (FarmItem) iterator.next();
            System.out.print(farmItem.getName() + ": ");
            System.out.println(farmItem.getPrice());
        }
    }
}