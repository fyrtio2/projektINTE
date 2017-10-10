public class Equipment {

    private String type;
    private int stat, durability;
    private boolean enchanted;
    private int lvlReq;


    public Equipment(String type,int stat, boolean enchanted, int lvlReq, int durability){
        this.type = type;
        this.stat = stat;
        this.enchanted = enchanted;
        this.lvlReq = lvlReq;
        this.durability = durability;




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

    public int getLvlReq(){
        return lvlReq;
    }

    public boolean canWear(Character player){
        if(player.getLvl() >= lvlReq){
            return true;
        }else{
            return false;
        }

    }

    public int getDurability(){
        return durability;
    }
}
