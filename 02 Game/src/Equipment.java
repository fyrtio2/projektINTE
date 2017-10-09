public class Equipment {

    private String type;
    private int stat, durability;
    private boolean enchanted;

    public Equipment(int durability){
        this.durability = durability;
    }

    public Equipment(String type,int stat, boolean enchanted,){
        this.type = type;
        this.stat = stat;
        this.enchanted = enchanted;

    }

    public String getType(){
     return type;
    }

    public int getStat(){
        return stat;
    }

    public boolean isEnchanted(){
        return enchanted;
    }

    public int getDurability(){
        return durability;
    }
}
