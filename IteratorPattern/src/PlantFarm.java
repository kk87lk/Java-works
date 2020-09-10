import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PlantFarm implements Farm {

    List<FarmItem> farmItems;

    public PlantFarm() {
        farmItems = new ArrayList<>();
        addItem("ѩ��", 1.0);
        addItem("�ཷ", 1.0);
        addItem("�²�", 1.0);
        addItem("���빽", 1.0);
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