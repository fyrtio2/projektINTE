import java.util.HashMap;

public class ItemBag {

    private int size;
    private HashMap<String,Equipment> equipments = new HashMap<>();

    private ItemBag(){


    }

    public void pickUp(Equipment equipment){
        equipments.put(equipment.getName(),equipment);
    }

}
