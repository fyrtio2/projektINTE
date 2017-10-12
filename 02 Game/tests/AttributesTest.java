import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import static org.junit.Assert.*;

public class AttributesTest {
    // Increase primary attribute tests
    @Test
    public void increasePrimaryAttributeTest() throws Exception {
        Attributes c = new Attributes(10, 10, 10, 10);
        c.increasePrimaryAttribute("Strength", 10);
        assertEquals(20, c.getStrenght());
    }

    @Test(expected = AssertionError.class)
    public void increasePrimaryAttributeMaxTest() throws Exception {
        Attributes c = new Attributes(10, 10, 10, 10);
        c.increasePrimaryAttribute("Strength", 50);
        assertEquals(60, c.getStrenght());
    }

    @Test(expected = IllegalArgumentException.class)
    public void increasePrimaryAttributeNullTest() throws Exception {
        Attributes c = new Attributes(10, 10, 10, 10);
        c.increasePrimaryAttribute(null, 5);
    }

    @Test(expected = IllegalArgumentException.class)
    public void increasePrimaryAttributeEmptyStringTest() throws Exception {
        Attributes c = new Attributes(10, 10, 10, 10);
        c.increasePrimaryAttribute("", 5);
    }

    @Test(expected = IllegalArgumentException.class)
    public void increasePrimaryAttributeInvalidStringTest() throws Exception {
        Attributes c = new Attributes(10, 10, 10, 10);
        c.increasePrimaryAttribute("Test", 5);
    }

    // Decrease primary attribute tests
    @Test
    public void decreasePrimaryAttributeTest() throws Exception {
        Attributes c = new Attributes(10, 10, 10, 10);
        c.decreasePrimaryAttribute("Strength", 5);
        assertEquals(5, c.getStrenght());
    }

    @Test(expected = AssertionError.class)
    public void decreasePrimaryAttributeMinTest() throws Exception {
        Attributes c = new Attributes(10, 10, 10, 10);
        c.decreasePrimaryAttribute("Vitality", 11);
        assertEquals(-1, c.getVitality());
    }

    @Test(expected = IllegalArgumentException.class)
    public void decreasePrimaryAttributeNullTest() throws Exception {
        Attributes c = new Attributes(10, 10, 10, 10);
        c.decreasePrimaryAttribute(null, 5);
    }

    @Test(expected = IllegalArgumentException.class)
    public void decreasePrimaryAttributeEmptyStringTest() throws Exception {
        Attributes c = new Attributes(10, 10, 10, 10);
        c.decreasePrimaryAttribute("", 5);
    }

    @Test(expected = IllegalArgumentException.class)
    public void decreasePrimaryAttributeInvalidStringTest() throws Exception {
        Attributes c = new Attributes(10, 10, 10, 10);
        c.decreasePrimaryAttribute("Test", 5);
    }


    // Negative Attributes
    @Test(expected = AssertionError.class)
    public void negativeAttributesTest() throws Exception {
        Attributes c = new Attributes(10, 10, 10, 10);
        assertEquals(-5, c.getDexterity());
    }

    @Test(expected = AssertionError.class)
    public void negativeCritChance() throws Exception {
        Attributes c = new Attributes(10, 10, 10, 10);
        assertEquals(-10, c.getCriticalChance(), 0.0001);
    }

    // Values exceed max limit
    @Test(expected = AssertionError.class)
    public void AttributeExeedsMaxValue() throws Exception {
        Attributes c = new Attributes(41, 41, 41, 41);
        assertEquals(41, c.getIntellegence());
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