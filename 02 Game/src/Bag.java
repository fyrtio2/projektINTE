import java.util.HashMap;

public class Bag {

    private int size;
    private HashMap<String,Equipment> bag = new HashMap<>();

    private Bag(){


    }



    public void pickUp(Equipment equipment){
        bag.put(equipment.getName(),equipment);
    }

}
