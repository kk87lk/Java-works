import java.util.Iterator;

public class AnimalFarm implements Farm {

    static final int MAX_ITEMS = 4;

    int indexOfItems = 0;

    FarmItem[] farmItems;

    public AnimalFarm() {
        farmItems = new FarmItem[MAX_ITEMS];
        addItem("¼¦µ°", 10.0);
        addItem("ÖíÈâ", 10.0);
        addItem("Å£Èâ", 15.0);
        addItem("¼¦Èâ", 10.0);
    }

    public void addItem(String name, double price) {
        FarmItem FarmItem = new FarmItem(name, price);
        if (indexOfItems >= MAX_ITEMS) {
            System.out.println("Å©³¡ÒÑÂú£¡");
        } else {
            farmItems[indexOfItems] = FarmItem;
            indexOfItems++;
        }
    }

    @Override
    public Iterator<FarmItem> createIterator() {
        return new AnimalFarmIterator(farmItems);
    }
}