
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

    private HashMap<String,Weapon> wieldedWeapons = new HashMap<>();//
    private HashMap<Enum,Equipment> equipedEquipment = new HashMap<>();

    public GameCharacter(String name) {
        level = 1;
        this.name = name;
        charAttributes = new CharacterAttributes(10, 10, 10, 10);
        bag = new Bag(10);
        maxHp = charAttributes.convertVitalityToHp();
        currentHp = maxHp;
    }

    public int checkForNegativeHp(int health) {
        if (health <= 0) {
            return 0;
        }
        return health;
    }

    public int checkIfHpExceedsMaxHp() {
        if (currentHp > maxHp) {
            return currentHp = maxHp;
        }
        return currentHp;
    }

    public int getCurrentHp() {
        checkForNegativeHp(currentHp);
        return currentHp;
    }


    public int getMaxHp() {
        checkForNegativeHp(maxHp);
        checkIfHpExceedsMaxHp();
        return maxHp;
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
    }

    public void resetLevel() {
        level = 1;
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
    public void makeCharacterDead(int hp) {
        if (isInCombat && hp == 0) {
            isAlive = false;
            resetExperience();
            resetPosition();
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
       if(equipedEquipment.get(type)== null){
           equipedEquipment.put(type,equipment);
       }else{
           System.out.printf("%s already equipped",type);
       }







    }

    public void weildWeapon(Weapon weapon){
        if(wieldedWeapons.get(weapon.getName())== null){
            wieldedWeapons.put(weapon.getName(),weapon);
        }else{
            System.out.println("cant wield two weapons");
        }

    }
}

