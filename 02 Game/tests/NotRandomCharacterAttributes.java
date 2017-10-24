public class NotRandomCharacterAttributes extends CharacterAttributes {
    private double rnd;

    public NotRandomCharacterAttributes(double rnd, int strenght, int dexterity, int intellegence, int vitality) {
        super(strenght, dexterity, intellegence, vitality);
        this.rnd = rnd;
    }

    @Override
    public double getRandomDouble() {
        return rnd;
    }

}
