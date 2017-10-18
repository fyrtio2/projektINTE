import java.util.HashMap;

public class Attributes {
    private int carryWeight, maxCarryWeight;
    private double criticalChance, criticalDamage;
    private HashMap<String, Integer> primaryAttributeHashMap = new HashMap<>();

    public Attributes(int strenght, int dexterity, int intellegence, int vitality) {
        addIntegerToHashMap("Strength", strenght);
        addIntegerToHashMap("Dexterity", dexterity);
        addIntegerToHashMap("Intellegence", intellegence);
        addIntegerToHashMap("Vitality", vitality);
        calcCriticalChance();
        calcCriticalDamage();
        calcMaxCarryWeight();
        checkIfAttributeExceedsMaxValue(primaryAttributeHashMap);
        checkForNegativeAttributesInMap(primaryAttributeHashMap);
    }

    private void addIntegerToHashMap(String name, int value) {
        primaryAttributeHashMap.put(name, value);
    }

    public void increasePrimaryAttribute(String valueName, int valueIncrease) {
        if (valueName == null || valueName.isEmpty() || valueName.trim().equals("")) {
            throw new IllegalArgumentException("Invalid valueName");
        } else {
            try {
                boolean key = primaryAttributeHashMap.containsKey(valueName);
                int value = primaryAttributeHashMap.get(valueName);
                if (key && value + valueIncrease < 40)
                    primaryAttributeHashMap.put(valueName, value + valueIncrease);
                else if (key && value + valueIncrease > 40)
                    primaryAttributeHashMap.put(valueName, 40);
            } catch (NullPointerException e) {
                throw new IllegalArgumentException();
            }
        }
    }

    public void decreasePrimaryAttribute(String valueName, int valueIncrease) {
        if (valueName == null || valueName.isEmpty() || valueName.trim().equals("")) {
            throw new IllegalArgumentException("Invalid valueName");
        } else {
            try {
                boolean key = primaryAttributeHashMap.containsKey(valueName);
                int value = primaryAttributeHashMap.get(valueName);
                if (key && value > valueIncrease)
                    primaryAttributeHashMap.put(valueName, primaryAttributeHashMap.get(valueName) - valueIncrease);
                else if (key && value < valueIncrease)
                    primaryAttributeHashMap.put(valueName, 0);
            } catch (NullPointerException e) {
                throw new IllegalArgumentException();
            }
        }
    }

    public void resetPrimaryAttributeValues() {
        primaryAttributeHashMap.put("Strength", 10);
        primaryAttributeHashMap.put("Dexterity", 10);
        primaryAttributeHashMap.put("Intellegence", 10);
        primaryAttributeHashMap.put("Vitality", 10);
        calcCriticalChance();
        calcCriticalDamage();
        calcMaxCarryWeight();
    }

    public int convertVitalityToHp() {
        return primaryAttributeHashMap.get("Vitality") * 10;
    }

    // Methods that check if attributes are negative
    public void checkForNegativeAttributesInMap(HashMap<String, Integer> hashMap) {
        for (HashMap.Entry<String, Integer> m : hashMap.entrySet()) {
            if (m.getValue() < 0)
                m.setValue(0);
        }
    }

    // Methods that check if attributes exeed max values.
    public void checkIfAttributeExceedsMaxValue(HashMap<String, Integer> hashMap) {
        for (HashMap.Entry<String, Integer> map : hashMap.entrySet()) {
            if (map.getValue() > 40)
                map.setValue(40);
        }
    }

    public double checkIfCritChanceExeedsMax(double critChance) {
        if (critChance > 1) {
            critChance = 1;
            return critChance;
        } else
            return critChance;
    }

    public double checkIfCritDamageExeedsMax(double critDamage) {
        if (critDamage > 2.75) {
            critDamage = 2.75;
            return critDamage;
        } else
            return critDamage;
    }

    public boolean checkIfCarryWeightExeedsMax() {
        if (carryWeight > maxCarryWeight) {
            return true;
        } else
            return false;
    }

    // Methods that calculate attribute values
    private void calcCriticalChance() {
        criticalChance = (double) getDexterity() / 100 + 0.1;
        criticalChance = checkIfCritChanceExeedsMax(criticalChance);
    }

    private void calcCriticalDamage() {
        criticalDamage = (double) getStrenght() / 50 + 2;
        criticalDamage = checkIfCritDamageExeedsMax(criticalDamage);
    }

    private void calcMaxCarryWeight() {
        maxCarryWeight = 100 + getStrenght() * 5;
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

    public int getMaxCarryWeight() {
        calcMaxCarryWeight();
        return maxCarryWeight;
    }
}