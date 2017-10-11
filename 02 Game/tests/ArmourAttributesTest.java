import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ArmourAttributesTest {
    @Test(expected = AssertionError.class)
    public void negativeArmourTest() throws Exception {
        ArmourAttributes breastplate = new ArmourAttributes(-10, 5, 5, 5, 5);
        assertEquals(-10, breastplate.getDefense());
    }
}
