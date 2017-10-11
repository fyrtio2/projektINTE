import java.util.HashMap;

public class CharacterAttributes {
    private int carryWeight;
    private double movementSpeed, attackSpeed, criticalChance, criticalDamage;
    private HashMap<String, Integer> primaryAttributeHashMap = new HashMap<>();

    public CharacterAttributes(int strenght, int dexterity, int perception, int intellegence, int vitality) {
        movementSpeed = 1.0;
        addIntegerToHashMap("Strength", strenght);
        addIntegerToHashMap("Dexterity", dexterity);
        addIntegerToHashMap("Perception", perception);
        addIntegerToHashMap("Intellegence", intellegence);
        addIntegerToHashMap("Vitality", vitality);
        calcCriticalChance();
        calcCriticalDamage();
        calcCarryWeight();
        checkIfAttributeExceedsMaxValue(primaryAttributeHashMap);
        checkIfAttributeIsNegative(primaryAttributeHashMap);
    }

    public void addIntegerToHashMap(String name, int value){
        primaryAttributeHashMap.put(name, value);
    }

    // Check for negative attribute values
    public void checkIfAttributeIsNegative(HashMap<String, Integer> hashMap) {
        for(HashMap.Entry<String, Integer> m : hashMap.entrySet()){
            if( m.getValue() < 0)
                m.setValue(0);
        }
    }

    private void checkIfAttributeExceedsMaxValue(HashMap<String, Integer> hashMap) {
        for(HashMap.Entry<String, Integer> map : hashMap.entrySet()){
            if( map.getValue() > 40)
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

    // Calculate Methods
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

    public int getPerception() {
        return primaryAttributeHashMap.get("Perception");
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
