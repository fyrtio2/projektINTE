import java.util.HashMap;

public class Attributes {
    private int carryWeight;
    private double criticalChance, criticalDamage;
    private HashMap<String, Integer> primaryAttributeHashMap = new HashMap<>();

    public Attributes(int strenght, int dexterity, int intellegence, int vitality) {
        addIntegerToHashMap("Strength", strenght);
        addIntegerToHashMap("Dexterity", dexterity);
        addIntegerToHashMap("Intellegence", intellegence);
        addIntegerToHashMap("Vitality", vitality);
        calcCriticalChance();
        calcCriticalDamage();
        calcCarryWeight();
        checkIfAttributeExceedsMaxValue(primaryAttributeHashMap);
        checkForNegativeAttributesInMap(primaryAttributeHashMap);
    }

    private void addIntegerToHashMap(String name, int value) {
        primaryAttributeHashMap.put(name, value);
    }

    // Denna metoder behöver nog skrivas om då de är svåra att läsa och förstå
    // Ökar ett primär attribut med ett utvalt värde
    // om ökningen är < 40 så säts värdet normal
    // om ökningen är > 40 så säts värdet till 40 som då är max värdet
    public void increasePrimaryAttribute(String valueName, int value) {
        if (primaryAttributeHashMap.containsKey(valueName) && primaryAttributeHashMap.get(valueName) + value < 40)
            primaryAttributeHashMap.put(valueName, primaryAttributeHashMap.get(valueName) + value);
        else if (primaryAttributeHashMap.containsKey(valueName) && primaryAttributeHashMap.get(valueName) + value > 40)
            primaryAttributeHashMap.put(valueName, 40);
    }

    // Denna metoder behöver nog skrivas om då de är svåra att läsa och förstå
    // minskar ett primär attribut med ett utvalt värde
    // om minskningen är > 0 så säts värdet normal
    // om minskningen är < 0 så säts värdet till 0 som då är min värdet
    public void lowerPrimaryAttribute(String valueName, int value) {
        if (primaryAttributeHashMap.containsKey(valueName) && primaryAttributeHashMap.get(valueName) > value)
            primaryAttributeHashMap.put(valueName, primaryAttributeHashMap.get(valueName) - value);
        else if (primaryAttributeHashMap.containsKey(valueName) && primaryAttributeHashMap.get(valueName) < value)
            primaryAttributeHashMap.put(valueName, 0);
    }

    public int convertVitalityToHp() {
        int vitality = primaryAttributeHashMap.get("Vitality");
        return vitality * 10;
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

    // Methods that calculate attribute values
    private void calcCriticalChance() {
        criticalChance = (double) getDexterity() / 100;
        criticalChance = checkIfCritChanceExeedsMax(criticalChance);
    }

    private void calcCriticalDamage() {
        criticalDamage = (double) getStrenght() / 50 + 1;
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
}
