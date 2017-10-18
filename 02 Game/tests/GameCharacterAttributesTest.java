import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GameCharacterAttributesTest {

    @Test(expected = AssertionError.class)
    public void negativeMovementSpeedTest() throws Exception {
        CharacterAttributes c = new CharacterAttributes(10, 10, 10, 10);
        c.lowerMovementSpeed(2.5);
        assertEquals(-1.5, c.getMovementSpeed(), 0.001);
    }

    @Test(expected = AssertionError.class)
    public void ExeedsMaxMovementSpeed() throws Exception {
        CharacterAttributes c = new CharacterAttributes(10, 10, 10, 10);
        c.increaseMovementSpeed(1.01);
        assertEquals(2.01, c.getMovementSpeed(), 0.001);
    }
}


