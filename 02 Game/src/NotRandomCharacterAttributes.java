public class NotRandomCharacterAttributes extends CharacterAttributes{
    public NotRandomCharacterAttributes(int strenght, int dexterity, int intellegence, int vitality) {
        super(strenght, dexterity, intellegence, vitality);
    }

    @Override
    public double getRandomDouble(){
        return 0.5;
    }
}
