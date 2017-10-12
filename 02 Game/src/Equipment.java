public class Equipment extends Item {



    private boolean isEnchanted;
    private int lvlReq;
    private boolean isBroken;




    public Equipment(String name,int lvlReq,int weight,int value, int durability){
        super(name,value,weight,durability);


        isEnchanted = false;
        this.lvlReq = lvlReq;



    }



    public boolean isEnchanted(){
        return isEnchanted;
    }

    public void enchantItem(){
        isEnchanted = true;

    }



    public boolean isWearableBy(GameCharacter player){
        if(isBroken){
            return false;
        }
        if(player.getLevel() >= lvlReq){
            return true;
        }else{
            return false;
        }

    }


    public void damageEquipment(int damage){
        int durability = itemAttributes.getDurability();
        int newDurability = durability -= damage;
        itemAttributes.setDurability(newDurability);
        if (durability <= 0){
            isBroken = true;
        }
    }

    public boolean isBroken(){
        return isBroken;
    }


}
