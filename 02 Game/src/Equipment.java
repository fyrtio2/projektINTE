public class Equipment extends Item {


    private int stat, durability;
    private boolean isEnchanted;
    private int lvlReq;
    private boolean isBroken;




    public Equipment(String name,int stat,int lvlReq, int durability,int weight,int value){
        super(name,value,weight);

        this.stat = stat;
        isEnchanted = false;
        this.lvlReq = lvlReq;
        this.durability = durability;


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
