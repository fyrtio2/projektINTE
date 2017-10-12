public class Equipment extends Item {


    private ItemAttributes itemAttributes;
    private boolean isEnchanted;
    private int lvlReq;
    private boolean isBroken;




    public Equipment(String name,int lvlReq, ItemAttributes itemAttributes,int weight,int value){
        super(name,value,weight);
        this.itemAttributes = itemAttributes;

        isEnchanted = false;
        this.lvlReq = lvlReq;



    }



    public boolean isEnchanted(){
        return isEnchanted;
    }

    public void enchantItem(){
        isEnchanted = true;

    }

    public ItemAttributes getItemAttributes(){
        return itemAttributes;
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
