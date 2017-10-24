public class Weapon extends Item {
    WeaponAttributes weaponAttributes;
    private boolean isWielded, isBroken;
    private int lvlReq;

    public Weapon(String name, int weight, int durability, WeaponAttributes weaponAttributes, int lvlReq) {
        super(name, weight, durability);
        this.lvlReq = lvlReq;
    }

    public boolean isUsableBy(GameCharacter player) {
        if (isBroken) {
            return false;
        }
        return player.getLevel() >= lvlReq;
    }

    public void damageWeapon(int damage) {
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

    public boolean isWielded() {
        return isWielded;
    }

    public void setWielded(Boolean isWielded) {
        this.isWielded = isWielded;
    }
}
