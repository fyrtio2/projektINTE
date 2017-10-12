import java.util.HashMap;

public class Bag {

    private int size;
    private HashMap<String, Item> bag = new HashMap<>();

    public Bag(int size) {
        this.size = size;

    }


    public void addToBag(Item item) {
        bag.put(item.getName(), item);
    }

    public HashMap getHashMap() {
        return bag;
    }
}
