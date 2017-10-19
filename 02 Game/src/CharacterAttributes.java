import java.util.Random;

public class CharacterAttributes extends Attributes {
    private int maxCarryWeight;
    private double movementSpeed;
    private int characterDamage;
    private int defense;

    public CharacterAttributes(int strenght, int dexterity, int intellegence, int vitality) {
        super(strenght, dexterity, intellegence, vitality);
        movementSpeed = 1.0;
        calculateCharacterDamage();
        calcMaxCarryWeight();
        defense = 5;
    }

    // Carry Weight Methods
    public void calcMaxCarryWeight() {
        maxCarryWeight = 100 + getStrenght() * 5;
    }

    public void checkIfOverburdened(int bagCapacity) {
        if (bagCapacity > maxCarryWeight)
            movementSpeed = 0;
    }

    public void resetCarryWeight() {
        calcMaxCarryWeight();
    }

    // Damage & Crit Methods
    public void calculateCharacterDamage() {
        characterDamage = 100 + 1 * getStrenght() + 1 * getDexterity() + 1 * getIntellegence();
    }

    public int checkIfCrit() {
        Random rand = new Random();
        Double randomDouble = rand.nextDouble();
        if (getCriticalChance() >= randomDouble) {
            return critSuccessful();
        } else
            return getCharacterDamage();
    }

    private int critSuccessful() {
        int crit = (int) (getCharacterDamage() * getCriticalDamage());
        return crit;
    }

    // Movement Speed Methods
    private double checkIfMovementSpeedExeedsMax(double movementSpeed) {
        if (movementSpeed > 2)
            return 2;
        else
            return movementSpeed;
    }

    private double checkIfMovementSpeedIsNegative(double movementSpeed) {
        if (movementSpeed < 0)
            return 0;
        else
            return movementSpeed;
    }

    public void lowerMovementSpeed(double amount) {
        movementSpeed = checkIfMovementSpeedIsNegative(movementSpeed - amount);
    }

    public void increaseMovementSpeed(double amount) {
        movementSpeed = checkIfMovementSpeedExeedsMax(movementSpeed + amount);
    }

    // Get methods
    public int getCharacterDamage() {
        calculateCharacterDamage();
        return characterDamage;
    }

    public int getMaxCarryWeight() {
        calcMaxCarryWeight();
        return maxCarryWeight;
    }

    public double getMovementSpeed() {
        return movementSpeed;
    }

    public void giveHalfArmorBonus(){
        defense += 10;
    }

    public void giveFullArmorBonus(){
        defense += 25;
    }


    public void removeHalfArmorBonus(){
        defense -= 10;
    }

    public void removeFullArmorBonus(){
        defense -= 25;
    }

    public int getDefense() {
        return defense;
    }

    public void increaseDefense(int amount){
        defense += amount;
    }
}