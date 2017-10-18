import java.util.Random;

// TODO: Återställ maxCarryWeight när en karaktär dör och respawnar (lvl 1).
public class CharacterAttributes extends Attributes {
    private int maxCarryWeight;
    private double movementSpeed;
    private int characterDamage;

    public CharacterAttributes(int strenght, int dexterity, int intellegence, int vitality) {
        super(strenght, dexterity, intellegence, vitality);
        movementSpeed = 1.0;
        calculateCharacterDamage();
        calcMaxCarryWeight();

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

    public void calculateCharacterDamage() {
        characterDamage = 100 + 1 * getStrenght() + 1 * getDexterity() + 1 * getIntellegence();
    }

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

    public int getCharacterDamage() {
        calculateCharacterDamage();
        return characterDamage;
    }

/////////////////////////////////////////////////////////////

    private void calcMaxCarryWeight() {
        maxCarryWeight = 100 + getStrenght() * 5;
    }

    public void checkIfOverburdened(int bagCapacity) {
        if (bagCapacity > maxCarryWeight)
            movementSpeed = 0;
    }

    public int getMaxCarryWeight() {
        calcMaxCarryWeight();
        return maxCarryWeight;
    }

    public double getMovementSpeed() {
        return movementSpeed;
    }

}