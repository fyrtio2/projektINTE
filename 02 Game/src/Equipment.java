public class Equipment {

    private String type;
    private int stat, durability;
    private boolean isEnchanted;
    private int lvlReq;
    private boolean isBroken;
    private int weight;



    public Equipment(String type,int stat,int lvlReq, int durability,int weight){
        this.type = type;
        this.stat = stat;
        isEnchanted = false;
        this.lvlReq = lvlReq;
        this.durability = durability;
        this.weight = weight;

    }



    public boolean isEnchanted(){
        return isEnchanted;
    }

    public void enchantItem(){
        isEnchanted = true;

        durability += 20;
        stat += 10;

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
