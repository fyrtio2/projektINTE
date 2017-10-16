import org.junit.Test;

import static org.junit.Assert.*;

public class MapTest {
    @Test
    public void testMapName() {
        Map map = new Map("The forbidden forest", 500, 500);
        assertEquals("The forbidden forest", map.getMapName());
    }

    @Test
    public void testShortName() {
        Map map = new Map("Mordor", 500, 500);
        assertEquals("Mordor", map.getMapName());
    }


    @Test(expected = IllegalArgumentException.class) //Skall ej gå igenom förrän felhantering i klassen är ordnat
    public void testNullMapName() {
        Map map = new Map(null, 500, 500);
        assertEquals(null, map.getMapName());
    }

    @Test(expected = IllegalArgumentException.class) //empty string skall inte accepteras
    public void testEmptyString() {
        Map map = new Map("", 500, 500);
        assertEquals("The forbidden forest", map.getMapName());
    }

    @Test
    public void testMapHeight() {
        Map map = new Map("The forbidden forest", 500, 500);
        assertEquals(500, map.getMapHeight());

    }

    @Test(expected = IllegalArgumentException.class)
    public void testNegativeHight() {
        Map map = new Map("The forbidden forest", -10, 500);
        assertEquals(500, map.getMapHeight());

    }

    @Test
    public void testMaxHeigth() {
        Map map = new Map("The forbidden forest", 1000, 500);
        assertEquals(1000, map.getMapHeight());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testOverMaxHeigth() {
        Map map = new Map("The forbidden forest", 1200, 500);
        assertEquals(1000, map.getMapHeight());
    }


    @Test
    public void testMapWidth() {
        Map map = new Map("The forbidden forest", 500, 500);
        assertEquals(500, map.getMapWidth());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNegativeWidth() {
        Map map = new Map("The forbidden forest", 500, -10);
        assertEquals(500, map.getMapWidth());

    }

    @Test
    public void testMaxWidth() {
        Map map = new Map("The forbidden forest", 500, 1000);
        assertEquals(1000, map.getMapWidth());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testOverMaxWidth() {
        Map map = new Map("The forbidden forest", 500, 1200);
        assertEquals(1000, map.getMapWidth());
    }
    @Test
    public void testCharacterXPosLessThenZero(){
        Map theWoods = new Map("theWoods", 1000, 1000);
        GameCharacter g = new GameCharacter("g");
        g.getCharAttributes().increaseMovementSpeed(1.0);
        for (int i = 1; i < 100; i++) {
            g.moveLeft();
        }
        assertFalse(theWoods.isWithinMap(g));
    }

    @Test
    public void testCharacterYPosLessThenZero() {
        Map theWoods = new Map("theWoods", 1000, 1000);
        GameCharacter g = new GameCharacter("g");

        g.getCharAttributes().increaseMovementSpeed(1.0);
        for (int i = 1; i < 100; i++) {
            g.moveDown();
        }
        assertFalse(theWoods.isWithinMap(g));
    }

    @Test
    public void testCharacterXPosMoreThanWidth() {
        Map theWoods = new Map("theWoods", 1000, 1000);
        GameCharacter g = new GameCharacter("g");

        g.getCharAttributes().increaseMovementSpeed(1.0);
        for (int i = 1; i < 1000; i++) {
            g.moveRight();
        }

        assertFalse(theWoods.isWithinMap(g));
    }

    @Test
    public void testCharacterYPosMoreThanWidth() {
        Map theWoods = new Map("theWoods", 1000, 1000);
        GameCharacter g = new GameCharacter("g");

        g.getCharAttributes().increaseMovementSpeed(1.0);
        for (int i = 1; i < 1000; i++) {
            g.moveUp();
        }

        assertFalse(theWoods.isWithinMap(g));
    }

    @Test
    public void testCharWithinMap() {
        Map theWoods = new Map("theWoods", 1000, 1000);
        GameCharacter g = new GameCharacter("g");
        for (int i  = 1; i < 500; i++) {
            g.moveUp();
            g.moveRight();
        }
        assertTrue(theWoods.isWithinMap(g));
    }

    @Test
    public void testNotWithinMap() {
        Map theWoods = new Map("theWoods", 1000, 1000);
        GameCharacter g = new GameCharacter("g");
        for (int i  = 1; i < 12000; i++) {
            g.moveUp();
            g.moveRight();
        }
        assertFalse(theWoods.isWithinMap(g));
    }

    @Test
    public void testResetWithinMap() {
        Map theWoods = new Map("theWoods", 1000, 1000);
        GameCharacter g = new GameCharacter("g");
        for (int i  = 1; i < 12000; i++) {
            g.moveUp();
            g.moveRight();
        }
        g.makeCharacterInCombat();
        g.hpCounter(g.getCurrentHp());
        g.makeCharacterDead();
        System.out.println(g.getIsAlive());
        assertTrue(theWoods.isWithinMap(g));
    }

}