public class CharacterAttributes {
    private int strenght, dexterity, perception, intellegence, vitality, carryWeight;
    private double movementSpeed, attackSpeed, criticalChance, criticalDamage;
    private int attributeArray[] = new int[]{strenght, dexterity, perception, intellegence, vitality, carryWeight};

    public CharacterAttributes(int strenght, int dexterity, int perception, int intellegence, int vitality) {
        this.strenght = strenght;
        this.dexterity = dexterity;
        this.perception = perception;
        this.intellegence = intellegence;
        this.vitality = vitality;
        movementSpeed = 1.0;
        calcCriticalChance();
        calcCriticalDamage();
        calcCarryWeight();
    }

    private void test(){
        for (int i: attributeArray){
            if(attributeArray[i] > 40){

            }
        }
    }

    private void calcCarryWeight(){
        carryWeight = 100 + strenght*5;
    }

    // Check for negative attribute values
    public double checkNegativeValue(double attributeValue){
        if(attributeValue < 0){
            return 0;
        }
        return attributeValue;
    }

    // Calculate Methods
    private void calcCriticalChance() {
        criticalChance = dexterity / 100;
        criticalChance = checkIfCritChanceExeedsMax(criticalChance);
    }

    private void calcCriticalDamage() {
        criticalDamage = 1 + (strenght / 50);
        criticalDamage = checkIfCritDamageExeedsMax(criticalDamage);
    }

    public double checkIfCritChanceExeedsMax(double critChance){
        if(critChance > 1)
            return 1;
        else
            return critChance;
    }

    public double checkIfCritDamageExeedsMax(double critDamage){
        if(critDamage > 2)
            return 2;
        else
            return critDamage;
    }

    // Get methods
    public double getCriticalChance(){
        calcCriticalChance();
        return criticalChance;
    }

    public double getCriticalDamage(){
        calcCriticalDamage();
        return criticalDamage;
    }

    public int getCarryWeight(){
        return carryWeight;
    }

    public double getMovementSpeed(){
        return movementSpeed;
    }

    public int getStrenght() {
        return strenght;
    }

    public int getDexterity() {
        return dexterity;
    }

    public int getPerception() {
        return perception;
    }

    public int getIntellegence() {
        return intellegence;
    }

    public int getVitality() {
        return vitality;
    }
}
