public class Equipment extends Item {
    private int lvlReq;
    private boolean isBroken;
    private Enum type;
    private EquipmentAttributes attributes;

    public enum Type {
        helmet, chestPlate, legPlate, shoes, shield, gloves, jewelry
    }

    public Equipment(Enum type, String name, int lvlReq, int durability, int weight, EquipmentAttributes attributes) {
        super(name, weight, durability);
        if (name == null || name.isEmpty())
            throw new IllegalArgumentException("Something went wrong");
        this.type = type;
        this.lvlReq = lvlReq;
        this.attributes = attributes;
    }

    public boolean isWearableBy(GameCharacter player) {
        if (isBroken)
            return false;
        if (player.getLevel() >= lvlReq)
            return true;
        else
            return false;
    }

    public void damageEquipment(int damage) {
        int durability = getDurability();
        durability -= damage;
        setDurability(durability);
        if (durability <= 0)
            isBroken = true;
    }

    public boolean isBroken() {
        return isBroken;
    }

    public Enum getType() {
        return type;
    }

    public EquipmentAttributes getAttributes(){
        return attributes;
    }

}
