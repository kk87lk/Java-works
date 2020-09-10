import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PlantFarm implements Farm {

    List<FarmItem> farmItems;

    public PlantFarm() {
        farmItems = new ArrayList<>();
        addItem("Ñ©²Ë", 1.0);
        addItem("Çà½·", 1.0);
        addItem("¾Â²Ë", 1.0);
        addItem("½ðÕë¹½", 1.0);
    }

    public void addItem(String name, double price) {
        FarmItem FarmItem = new FarmItem(name, price);
        farmItems.add(FarmItem);
    }

    @Override
    public Iterator<FarmItem> createIterator() {
        return new PlantFarmIterator(farmItems);
    }
}