import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EquipmentAttributesTest {
    @Test(expected = AssertionError.class)
    public void negativeArmourTest() throws Exception {
        EquipmentAttributes breastplate = new EquipmentAttributes(-10, 5, 5, 5, 5);
        assertEquals(-10, breastplate.getDefense());
    }

}
