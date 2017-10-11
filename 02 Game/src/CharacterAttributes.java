import java.util.HashMap;

public class CharacterAttributes {
    private int carryWeight;
    private double movementSpeed, criticalChance, criticalDamage;
    private HashMap<String, Integer> primaryAttributeHashMap = new HashMap<>();

    public CharacterAttributes(int strenght, int dexterity, int intellegence, int vitality) {
        movementSpeed = 1.0;
        addIntegerToHashMap("Strength", strenght);
        addIntegerToHashMap("Dexterity", dexterity);
        addIntegerToHashMap("Intellegence", intellegence);
        addIntegerToHashMap("Vitality", vitality);
        calcCriticalChance();
        calcCriticalDamage();
        calcCarryWeight();
        checkIfAttributeExceedsMaxValue(primaryAttributeHashMap);
        checkIfAttributeIsNegative(primaryAttributeHashMap);
        checkIfMovementSpeedExeedsMax(movementSpeed);
    }

    public void addIntegerToHashMap(String name, int value) {
        primaryAttributeHashMap.put(name, value);
    }

    public void increasePrimaryAttribute(String s, int value) {
        if (primaryAttributeHashMap.containsKey(s)) {
            primaryAttributeHashMap.put(s, primaryAttributeHashMap.get(s) + value);
        }
    }

    public int convertVitalityToHp() {
        int vitality = primaryAttributeHashMap.get("Vitality");
        return vitality * 10;
    }

    // Methods that check if attributes are negative
    public void checkIfAttributeIsNegative(HashMap<String, Integer> hashMap) {
        for (HashMap.Entry<String, Integer> m : hashMap.entrySet()) {
            if (m.getValue() < 0)
                m.setValue(0);
        }
    }

    // Methods that check if attributes exeed max values.
    private void checkIfAttributeExceedsMaxValue(HashMap<String, Integer> hashMap) {
        for (HashMap.Entry<String, Integer> map : hashMap.entrySet()) {
            if (map.getValue() > 40)
                map.setValue(40);
        }
    }

    public double checkIfCritChanceExeedsMax(double critChance) {
        if (critChance > 1)
            return 1;
        else
            return critChance;
    }

    public double checkIfCritDamageExeedsMax(double critDamage) {
        if (critDamage > 2)
            return 2;
        else
            return critDamage;
    }

    public double checkIfMovementSpeedExeedsMax(double movementSpeed) {
        if (movementSpeed > 2)
            return 2;
        else
            return movementSpeed;
    }

    // Methods that calculate attribute values
    private void calcCriticalChance() {
        criticalChance = getDexterity() / 100;
        criticalChance = checkIfCritChanceExeedsMax(criticalChance);
    }

    private void calcCriticalDamage() {
        criticalDamage = 1 + (getStrenght() / 50);
        criticalDamage = checkIfCritDamageExeedsMax(criticalDamage);
    }

    private void calcCarryWeight() {
        carryWeight = 100 + getStrenght() * 5;
    }

    // Get methods Primary Attributes
    public int getStrenght() {
        return primaryAttributeHashMap.get("Strength");
    }

    public int getDexterity() {
        return primaryAttributeHashMap.get("Dexterity");
    }

    public int getIntellegence() {
        return primaryAttributeHashMap.get("Intellegence");
    }

    public int getVitality() {
        return primaryAttributeHashMap.get("Vitality");
    }

    // Get methods Secondary Attributes
    public double getCriticalChance() {
        calcCriticalChance();
        return criticalChance;
    }

    public double getCriticalDamage() {
        calcCriticalDamage();
        return criticalDamage;
    }

    public int getCarryWeight() {
        return carryWeight;
    }

    public double getMovementSpeed() {
        return movementSpeed;
    }
}
