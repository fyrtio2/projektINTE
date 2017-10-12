public class Weapon extends Item {

    WeaponAttributes weaponAttributes;
    private boolean isBroken;
    private int lvlReq;

    public Weapon(String name,int value,int weight,int durability, WeaponAttributes weaponAttributes, int lvlReq){
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
