public class Item {
    private String name;
    private int weight;
    private int durability;

    public Item(String name, int weight, int durability) {
        this.name = name;
        this.weight = weight;
        this.durability = durability;
    }

    public String getName() {
        return name;
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
