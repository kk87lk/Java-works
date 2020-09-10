import java.util.Iterator;
import java.util.List;

public class PlantFarmIterator implements Iterator {

    List<FarmItem> farmItems;

    int position = 0;

    public PlantFarmIterator(List<FarmItem> farmItems) {
        this.farmItems = farmItems;
    }

    @Override
    public boolean hasNext() {
        if (position >= farmItems.size() || farmItems.get(position) == null) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public Object next() {
        FarmItem FarmItem = farmItems.get(position);
        position += 1;
        return FarmItem;
    }
}