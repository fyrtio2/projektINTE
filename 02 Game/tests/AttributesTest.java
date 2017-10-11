import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import static org.junit.Assert.*;

@RunWith(Suite.class)
@Suite.SuiteClasses({CharacterAttributesTest.class, ArmourAttributesTest.class, WeaponAttributesTest.class })
public class AttributesTest {
    @Test(expected = AssertionError.class)
    public void increasePrimaryAttributeTest() throws Exception {
        Attributes c = new Attributes(10, 10, 10, 10);
        c.increasePrimaryAttribute("Strength", 50);
        assertEquals(60, c.getStrenght(), 0);
    }

    @Test(expected = AssertionError.class)
    public void lowerPrimaryAttributeTest() throws Exception {
        Attributes c = new Attributes(10, 10, 10, 10);
        c.lowerPrimaryAttribute("Vitality", 11);
        assertEquals(-1, c.getVitality(), 0);
    }

    @Test(expected = AssertionError.class)
    public void negativeAttributesTest() throws Exception {
        Attributes c = new Attributes(10, 10, 10, 10);
        assertEquals(-5, c.getDexterity(), 0);
    }

    @Test(expected = AssertionError.class)
    public void negativeCritChance() throws Exception {
        Attributes c = new Attributes(10, 10, 10, 10);
        assertEquals(-10, c.getCriticalChance(), 0);
    }

    @Test(expected = AssertionError.class)
    public void AttributeExeedsMaxValue() throws Exception {
        Attributes c = new Attributes(41, 41, 41, 41);
        assertEquals(41, c.getIntellegence(), 0);
    }

    // 101 Dexterity results in critChance exceeding the max limit which is 1.0 (100%)
    @Test(expected = AssertionError.class)
    public void ExeedsMaxCritChance() throws Exception {
        Attributes c = new Attributes(10, 101, 10, 10);
        assertEquals(1.001, c.getCriticalChance(), 0.0001);
    }

    // 51 Strenght results in critDamage exceeding the max limit which is 2.0 (200%)
    @Test(expected = AssertionError.class)
    public void ExeedsMaxCritDamage() throws Exception {
        Attributes c = new Attributes(51, 10, 10, 10);
        assertEquals(2.01, c.getCriticalDamage(), 0.001);
    }


    @Test(expected = AssertionError.class)
    public void ExeedsCarryWeight() throws Exception {
        Attributes c = new Attributes(10, 10, 10, 10);
        assertEquals(160, c.getCarryWeight());
    }

    @Test(expected = AssertionError.class)
    public void ExeedsMaxCarryWeight() throws Exception {
        Attributes c = new Attributes(40, 10, 10, 10);
        assertEquals(301, c.getCarryWeight());
    }
}