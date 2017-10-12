public class Equipment extends Item {

    private int lvlReq;
    private boolean isBroken;
    private String type;

    private enum type{
        helmet,chestplate,legplate,shoes,shield,gloves,jewelry
    }


    public Equipment(Enum type,String name, int lvlReq, int durability, int weight, int value) {
        super(name, value, weight, durability);


        this.lvlReq = lvlReq;


    }

    public boolean isWearableBy(GameCharacter player) {
        if (isBroken) {
            return false;
        }
        if (player.getLevel() >= lvlReq) {
            return true;
        } else {
            return false;
        }

    }

    public void damageEquipment(int damage) {
        int durability = getDurability();
        durability -= damage;
        setDurability(durability);
        if (durability <= 0) {
            isBroken = true;
        }
    }

    public boolean isBroken() {
        return isBroken;
    }


}
