public class WeaponAttributes extends Attributes {
    private int weaponDamage;


    public WeaponAttributes(int weaponDamage, int strenght, int dexterity, int intellegence, int vitality) {
        super(strenght, dexterity, intellegence, vitality);
        this.weaponDamage = weaponDamage;
        checkIfWeaponDamageIsNegative();
    }

    private void checkIfWeaponDamageIsNegative() {
        if (weaponDamage < 0)
            weaponDamage = 0;
    }

    public int getWeaponDamage() {
        return weaponDamage;
    }
}
