import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class WeaponAttributesTest {
    @Test(expected = AssertionError.class)
    public void negativeAttackSpeedTest() throws Exception {
        WeaponAttributes sword = new WeaponAttributes(10, 15, -0.5, 5, 5, 5, 5);
        assertEquals(-0.5, sword.getAttackSpeed(), 0.01);
    }

    @Test(expected = AssertionError.class)
    public void negativeWeaponDamageMinTest() throws Exception {
        WeaponAttributes sword = new WeaponAttributes(-10, 15, 1, 5, 5, 5, 5);
        assertEquals(-10, sword.getWeaponDamageMin());
    }

    @Test(expected = AssertionError.class)
    public void damageMaxLowerThanDamageMinTest() throws Exception {
        WeaponAttributes sword = new WeaponAttributes(5, 4, 1, 5, 5, 5, 5);
        assertEquals(4, sword.getWeaponDamageMax());
    }

}
