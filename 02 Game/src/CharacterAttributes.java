public class CharacterAttributes extends Attributes {
    private double movementSpeed;

    public CharacterAttributes(int strenght, int dexterity, int intellegence, int vitality) {
        super(strenght, dexterity, intellegence, vitality);
        movementSpeed = 1.0;
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
        return movementSpeed;
    }

    public void lowerMovementSpeed(double amount) {
        movementSpeed = checkIfMovementSpeedIsNegative(movementSpeed - amount);
    }

    public void increaseMovementSpeed(double amount) {
        movementSpeed = checkIfMovementSpeedExeedsMax(movementSpeed + amount);
    }
}
