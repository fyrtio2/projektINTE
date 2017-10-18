import java.util.HashMap;
import java.util.HashSet;

public class Bag {

    private int weight;
    private HashMap<String, Item> bag = new HashMap<>();


    public Bag(int weight) {
        this.weight = weight;
    }

    public void addToBag(Item item) {
        bag.put(item.getName(), item);
        addWeight(item);
    }
    public HashMap getHashMap() {
        return bag;
    }

    public void removeFromBag(Item item){
        bag.remove(item.getName(),item);
    }

    public int getWeight() {
        return weight;
    }

    public void addWeight(Item item) {
        weight += item.getWeight();
    }


}