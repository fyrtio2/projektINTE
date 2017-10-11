import java.util.HashMap;

public class Bag {

    private int size;
    private HashMap<String,Item> bag = new HashMap<>();

    public Bag(){


    }



    public void addToBag(Item item){
        bag.put(item.getName(),item);
    }

  public HashMap getBagMap(){
        return bag;
  }
}
