import java.util.HashMap;

public class Bag {

    private int maxWeight = 100;
    private HashMap<String, Item> bag = new HashMap<>();

    public Bag(int size) {
        this.maxWeight = size;
    }

    public void addToBag(Item item) {
        bag.put(item.getName(), item);
    }
    public HashMap getHashMap() {
        return bag;
    }
}
