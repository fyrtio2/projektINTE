import java.util.HashMap;

public class GameCharacter {
    private int currentHp, maxHp, level, experience;
    private String name;
    private double xPos = 20.0;
    private double yPos = 10.0;
    private boolean isInCombat;
    private boolean isAlive = true;
    private CharacterAttributes charAttributes;
    private Bag bag;
    private Weapon weapon;

    private HashMap<Enum, Equipment> equippedEquipment = new HashMap<>();

    public GameCharacter(String name) {
        level = 1;
        this.name = nameCheck(name);
        charAttributes = new CharacterAttributes(10, 10, 10, 10);
        bag = new Bag(0);
        maxHp = charAttributes.convertVitalityToHp();
        currentHp = maxHp;
    }

    public String nameCheck(String name) {
        if (name == null || name.isEmpty() || name.trim().equals("")) {
            return "A.Nonym";
        } else if (name.length() > 20)
            throw new IllegalArgumentException("Namn får inte överskrida 20 tecken");
        return name;
    }

    public int checkForNegativeHp(int health) {
        if (health < 0) {
            currentHp = 0;
            return currentHp;
        }
        return health;
    }

    // Level up Methods
    public void levelUp(int amount) {
        level += amount;
        for(int i = 0; i < amount; i++){
            charAttributes.increasePrimaryAttribute("Strength", 2);
            charAttributes.increasePrimaryAttribute("Dexterity", 2);
            charAttributes.increasePrimaryAttribute("Intellegence", 2);
            charAttributes.increasePrimaryAttribute("Vitality", 1);
            maxHp = charAttributes.convertVitalityToHp();
            currentHp = maxHp;
        }
    }

    public void resetLevel() {
        level = 1;
        charAttributes.resetPrimaryAttributeValues();
        charAttributes.resetCarryWeight();
        maxHp = charAttributes.convertVitalityToHp();
        currentHp = maxHp;
    }

    public void resetExperience() {
        experience = 0;
    }

    // GameCharacter Combat
    public boolean enterCombat() {
        isInCombat = true;
        return isInCombat;
    }

    public boolean outOfCombat() {
        isInCombat = false;
        return isInCombat;
    }

    public boolean getIsInCombat() {
        return isInCombat;
    }

    public void afterCombat(boolean isInCombat) {
        if (isInCombat) {
            outOfCombat();
            experience += 10;
            if (experience > 30) {
                levelUp(1);
                resetExperience();
            }
        }
    }

    public int meleeAttack() {
        return getCharAttributes().determineIfCritIsSuccessfulAndReturnDamage();
    }

    public int takeDamage(int damageTaken) {
        currentHp -= damageTaken;
        return checkForNegativeHp(currentHp);
    }

    // GameCharacter Alive or Dead
    public void killCharacter() {
        if (isInCombat && currentHp == 0) {
            isAlive = false;
            resetExperience();
            resetPosition();
        }
    }

    public void hpCounter(int hp) {
        for (int i = 0; i < hp; i++)
            currentHp = currentHp - 1;
    }

    // Movement & Position methods
    public void moveRight() {
        xPos += charAttributes.getMovementSpeed();
    }

    public void moveLeft() {
        xPos -= charAttributes.getMovementSpeed();
    }

    public void moveUp() {
        yPos += charAttributes.getMovementSpeed();
    }

    public void moveDown() {
        yPos -= charAttributes.getMovementSpeed();
    }

    public void resetPosition() {
        if (!isAlive) {
            xPos = 20;
            yPos = 10;
        }
    }

    // Equipment Methods
    public void useEquipment(Equipment equipment) {

        if (equippedEquipment.containsKey(equipment.getType())) {
            System.out.printf("%s already equipped%n", equipment.getType());
        } else {
            equippedEquipment.put(equipment.getType(), equipment);
            bag.removeFromBag(equipment);
            System.out.println("added");
            charAttributes.addEquipmentAttributesToCharacter(equipment.getAttributes());
            charAttributes.increaseDefense(equipment.getAttributes().getDefense());
            charAttributes.calculateCharacterDamage();
            charAttributes.calcMaxCarryWeight();
            maxHp = charAttributes.convertVitalityToHp();

            if (equippedEquipment.size() >= 4) {
                charAttributes.giveHalfArmorBonus();
            }

            if (equippedEquipment.size() == 7) {
                charAttributes.giveFullArmorBonus();
            }
        }
    }

    public void wieldWeapon(Weapon w) {
        if (weapon == null || !(weapon.isWielded())) {
            weapon = w;
            weapon.setWielded(true);
        } else {
            System.out.println("cant wield two weapons\n");
        }
    }

    public boolean checkIfEquipmentIsUsed(Equipment equipment) {
        boolean isEquipped;
        if (equippedEquipment.containsKey(equipment.getType())) {
            isEquipped = equippedEquipment.get(equipment.getType()).equals(equipment);
        } else {
            isEquipped = false;
        }
        return isEquipped;
    }

    public boolean isCharacterWieldingWeapon(Weapon w) {
        if (w.isWielded() && weapon.equals(w)) {
            System.out.println();
            return true;
        } else {
            return false;
        }
    }

    public void unEquip(Item item) {
        if (item instanceof Equipment) {
            unEquipEquipment(item);
            charAttributes.removeEquipmentAttributesFromCharacter(((Equipment) item).getAttributes());
            maxHp = charAttributes.convertVitalityToHp();
        } else {
            unWield(item);
        }
    }

    private void unEquipEquipment(Item item) {
        Equipment equipment = (Equipment) item;
        if (checkIfEquipmentIsUsed(equipment)) {
            equippedEquipment.remove(equipment.getType());
            pickUpItem(equipment);
        } else {
            System.out.printf("that %s is not equipped%n", equipment.getType());
        }
    }

    private void unWield(Item item) {
        Weapon w = (Weapon) item;
        if (isCharacterWieldingWeapon(w)) {
            weapon.setWielded(false);
            pickUpItem(w);
            if (equippedEquipment.size() < 4)
                charAttributes.removeHalfArmorBonus();
            else if (equippedEquipment.size() < 7)
                charAttributes.removeFullArmorBonus();
        } else {
            System.out.printf("%s is not wielded%n", w.getName());
        }
    }

    public void pickUpItem(Item item) {
        bag.addToBag(item);
        charAttributes.checkIfOverburdened(bag.getWeight());
    }

    public void dropItem(Item item) {
        bag.removeFromBag(item);
        charAttributes.checkIfOverburdened(bag.getWeight());
    }

    // Get Methods
    public CharacterAttributes getCharAttributes() {
        return charAttributes;
    }

    public String getName() {
        return name;
    }

    public int getCurrentHp() {
        return currentHp;
    }

    public int getMaxHp() {
        charAttributes.convertVitalityToHp();
        return maxHp;
    }

    public int getLevel() {
        return level;
    }

    public int getExperience() {
        return experience;
    }

    public Bag getBag() {
        return bag;
    }

    public boolean getIsAlive() {
        return isAlive;
    }

    public double getXPos() {
        return xPos;
    }

    public double getYPos() {
        return yPos;
    }
}