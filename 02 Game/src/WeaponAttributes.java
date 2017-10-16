public class WeaponAttributes extends Attributes {
    private int weaponDamageMin, weaponDamageMax;
    private double attackSpeed;
    private int durability;

    public WeaponAttributes(int weaponDamageMin, int weaponDamageMax, double attackSpeed, int strenght, int dexterity, int intellegence, int vitality) {
        super(strenght, dexterity, intellegence, vitality);
        this.weaponDamageMin = weaponDamageMin;
        this.weaponDamageMax = weaponDamageMax;
        this.attackSpeed = attackSpeed;
        checkIfAttackSpeedIsNegative();
        checkIfWeaponDamageMinIsNegative();
        checkIfDamageMaxIsLowerThanDamageMin();
    }

    private void checkIfAttackSpeedIsNegative() {
        if (attackSpeed < 0)
            attackSpeed = 0;
    }

    private void checkIfWeaponDamageMinIsNegative() {
        if (weaponDamageMin < 0)
            weaponDamageMin = 0;
    }

    private void checkIfDamageMaxIsLowerThanDamageMin() {
        if (weaponDamageMax <= weaponDamageMin)
            weaponDamageMax = weaponDamageMin + 1;
    }

    public int getWeaponDamageMin() {
        return weaponDamageMin;
    }

    public int getWeaponDamageMax() {
        return weaponDamageMax;
    }

    public double getAttackSpeed() {
        return attackSpeed;
    }

}
