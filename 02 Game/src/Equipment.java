public class Equipment {

    private String type;
    private int stat, durability;
    private boolean isEnchanted;
    private int lvlReq;
    private boolean isBroken;


    public Equipment(String type,int stat,int lvlReq, int durability){
        this.type = type;
        this.stat = stat;
        isEnchanted = false;
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
        return isEnchanted;
    }

    public void enchantItem(){
        isEnchanted = true;

    }


    public boolean isWearableBy(Character player){
        if(isBroken){
            return false;
        }
        if(player.getLevel() >= lvlReq){
            return true;
        }else{
            return false;
        }

    }

    public int getDurability(){
        return durability;
    }

    public void damageEquipment(int damage){
        durability -= damage;
        if (durability <= 0){
            isBroken = true;
        }
    }

    public boolean isBroken(){
        return isBroken;
    }
}
