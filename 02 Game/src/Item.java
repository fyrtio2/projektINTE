public class Item {

    private String name;
    private int value;
    private int weight;
    private int durability;

    public Item(String name, int value, int weight, int durability) {
        this.name = name;
        this.value = value;
        this.weight = weight;
        this.durability = durability;
    }

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }

    public int getWeight() {
        return weight;
    }

    protected int getDurability(){
        return durability;
    }

    protected void setDurability(int durability){
        this.durability = durability;
    }
}
