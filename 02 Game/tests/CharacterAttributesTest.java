import org.junit.Test;

import static org.junit.Assert.*;
public class CharacterAttributesTest {
    @Test(expected = AssertionError.class)
    public void negativeAttributesTest() throws Exception{
        CharacterAttributes c = new CharacterAttributes(10,10,10,10,10);
        assertEquals(-5, c.getDexterity(), 0);
    }

    @Test(expected = AssertionError.class)
    public void negativeCritChance() throws Exception{
        CharacterAttributes c = new CharacterAttributes(10,10,10,10,10);
        assertEquals(-10, c.getCriticalChance(), 0);
    }

    // 101 Dexterity results in critChance exceeding the max limit which is 1.0 (100%)
    @Test(expected = AssertionError.class)
    public void ExeedsMaxCritChance() throws Exception{
        CharacterAttributes c = new CharacterAttributes(10,101,10,10,10);
        assertEquals(1.001, c.getCriticalChance(), 0.0001);
    }

    // 51 Strenght results in critDamage exceeding the max limit which is 2.0 (200%)
    @Test(expected = AssertionError.class)
    public void ExeedsMaxCritDamage() throws Exception{
        CharacterAttributes c = new CharacterAttributes(51,10,10,10,10);
        assertEquals(2.01, c.getCriticalDamage(), 0.001);
    }
}