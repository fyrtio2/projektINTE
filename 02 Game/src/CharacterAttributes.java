import java.util.Random;

public class CharacterAttributes extends Attributes {
    private double movementSpeed;
    private int characterDamage;

    public CharacterAttributes(int strenght, int dexterity, int intellegence, int vitality) {
        super(strenght, dexterity, intellegence, vitality);
        movementSpeed = 1.0;
        calculateCharacterDamage();

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

    public double getMovementSpeed() {
        checkIfOverburden();
        return movementSpeed;
    }

    private void checkIfOverburden() {
        if (checkIfCarryWeightExeedsMax())
            movementSpeed = 0;
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
}
