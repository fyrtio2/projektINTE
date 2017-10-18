import java.util.HashMap;

public class GameCharacter {

    private int currentHp;
    private int maxHp, level, experience;
    private String name;
    private double xPos = 20.0;
    private double yPos = 10.0;
    private boolean isInCombat;
    private boolean isAlive = true;
    private CharacterAttributes charAttributes;
    private Bag bag;

    private Weapon weapon;
    private HashMap<Enum,Equipment> equippedEquipment = new HashMap<>();

    public GameCharacter(String name) {
        level = 1;
        this.name = nameCheck(name);
        charAttributes = new CharacterAttributes(10, 10, 10, 10);
        bag = new Bag(10);
        maxHp = charAttributes.convertVitalityToHp();
        currentHp = maxHp;
    }

    public int meleeAttack(){
        int attack = getCharAttributes().checkIfCrit();
        return attack;
    }

    public String nameCheck(String name){
        if(name == null || name.isEmpty() || name.trim().equals("")){
            return "A.Nonym";
        }else if (name.length() > 20)
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

    public int checkIfCurrentHpExceedsMaxHp() {
        if (currentHp > maxHp) {
            currentHp = maxHp;
            return currentHp;
        }
        return currentHp;
    }

    public int getCurrentHp() {
        return currentHp;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public int takeDamage(int damageTaken){
        currentHp -= damageTaken;
        return checkForNegativeHp(currentHp);
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public int getExperience() {
        return experience;
    }

    public void levelUp() {
        level++;
        charAttributes.increasePrimaryAttribute("Strength", 2);
        charAttributes.increasePrimaryAttribute("Dexterity", 2);
        charAttributes.increasePrimaryAttribute("Intellegence", 2);
        charAttributes.increasePrimaryAttribute("Vitality", 1);
        maxHp = charAttributes.convertVitalityToHp();
        currentHp = maxHp;
    }

    public void resetLevel() {
        level = 1;
        charAttributes.resetPrimaryAttributeValues();
        maxHp = charAttributes.convertVitalityToHp();
        currentHp = maxHp;
    }

    public void afterCombat(boolean isInCombat) {
        if (isInCombat) {
            makeCharacterInPeacefulStance();
            experience += 10;
            if (experience > 30) {
                levelUp();
                resetExperience();
            }
        } else {
            return;
        }
    }

    public void resetExperience() {
        experience = 0;
    }

    //GameCharacter Combat
    public boolean makeCharacterInCombat() {
        isInCombat = true;
        return isInCombat;
    }

    public boolean makeCharacterInPeacefulStance() {
        isInCombat = false;
        return isInCombat;
    }

    public boolean getIsInCombat() {
        return isInCombat;
    }

    //GameCharacter Alive or Dead
    public void makeCharacterDead() {
        if (isInCombat && currentHp == 0) {
            isAlive = false;
            resetExperience();
            resetPosition();
        }
    }

    public void hpCounter(int hp){
        for (int i = 0; i < hp; i++){
            currentHp = currentHp - 1;
        }
    }

    public boolean getIsAlive() {
        return isAlive;
    }

    //GameCharacter Position
    public double getXPos() {
        return xPos;
    }

    public double getYPos() {
        return yPos;
    }

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

    public CharacterAttributes getCharAttributes() {
        return charAttributes;
    }

    public void pickUp(Item item) {
        bag.addToBag(item);
    }

    public Bag getBag() {
        return bag;
    }

    public void equipEquipment(Equipment equipment){
        Enum type = equipment.getType();
       if(equippedEquipment.get(type)== null)
       {
           equippedEquipment.put(type,equipment);
           bag.removeFromBag(equipment);
           System.out.println("hello");
       }
       else
       {
           System.out.printf("%s already equipped",type);
       }
    }

    public void weildWeapon(Weapon weapon){
        if(weapon == null){

        }else{
            System.out.println("cant wield two weapons");
        }
    }



    public HashMap<Enum,Equipment> getEquippedEquipment(){
        return equippedEquipment;
    }




    public void clearEquippedEquipments(){
        equippedEquipment.clear();
    }
}

