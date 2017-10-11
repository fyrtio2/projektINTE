public class ArmourAttributes extends Attributes {
    private int defense;

    public ArmourAttributes(int defense, int strenght, int dexterity, int intellegence, int vitality) {
        super(strenght, dexterity, intellegence, vitality);
        this.defense = defense;
        checkIfdefenseIsLessThanMin();
    }

    private void checkIfdefenseIsLessThanMin() {
        if (defense < 1)
            defense = 1;
    }

    public int getDefense() {
        return defense;
    }
}
