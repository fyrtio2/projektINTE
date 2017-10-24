import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class WeaponAttributesTest {

    @Test(expected = AssertionError.class)
    public void negativeWeaponDamageTest() throws Exception {
        WeaponAttributes sword = new WeaponAttributes(-10, 5, 5, 5, 5);
        assertEquals(-10, sword.getWeaponDamage());
    }

}
