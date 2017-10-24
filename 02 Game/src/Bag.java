import java.util.HashMap;

public class Bag {
    private int weight;
    private HashMap<String, Item> bag = new HashMap<>();

    public Bag(int weight) {
        this.weight = weight;
    }

    public void addToBag(Item item) {
        addWeight(item);
        bag.put(item.getName(), item);
    }

    public HashMap getHashMap() {
        return bag;
    }

    public void removeFromBag(Item item) {
        weight -= item.getWeight();
        bag.remove(item.getName(), item);
    }

    public int getWeight() {
        return weight;
    }

    public void addWeight(Item item) {
        weight += item.getWeight();
    }
}