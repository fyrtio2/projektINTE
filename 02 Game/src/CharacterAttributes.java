import java.util.Random;

public class CharacterAttributes extends Attributes {
    private int maxCarryWeight, characterDamage, defense;
    private double movementSpeed;

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
        else
            movementSpeed = 1.0;
    }

    public void resetCarryWeight() {
        calcMaxCarryWeight();
    }

    // Damage & Crit Methods
    public void calculateCharacterDamage() {
        characterDamage = 100 + 1 * getStrenght() + 1 * getDexterity() + 1 * getIntellegence();
    }

    public int determineIfCrit() {
        if (getCriticalChance() >= getRandomDouble()) {
            return returnDamage(true);
        } else
            return returnDamage(false);
    }

    protected double getRandomDouble() {
        Random rand = new Random();
        return rand.nextDouble();
    }

    protected int returnDamage(boolean critSuccessful) {
        if (critSuccessful)
            return (int) (getCharacterDamage() * getCriticalDamage());
        else
            return getCharacterDamage();
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

    public int getDefense() {
        return defense;
    }

    public void increaseDefense(int amount) {
        defense += amount;
    }
}