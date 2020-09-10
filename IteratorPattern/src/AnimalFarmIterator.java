import java.util.Iterator;

public class AnimalFarmIterator implements Iterator {

    FarmItem[] farmItems;

    int position = 0;

    public AnimalFarmIterator(FarmItem[] farmItems) {
        this.farmItems = farmItems;
    }

    @Override
    public boolean hasNext() {
        if (position >= farmItems.length || farmItems[position] == null) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public Object next() {
        FarmItem FarmItem = farmItems[position];
        position += 1;
        return FarmItem;
    }
}