import org.junit.Test;

import static org.junit.Assert.*;

public class MapTest {
    @Test
    public void getMapName() throws Exception {
        Map theWoods = new Map("The forbidden forest", 500, 500);
        assertEquals("The forbidden forest", theWoods.getMapName());
    }

    @Test
    public void testShortName() {
        Map map = new Map("Mordor", 500, 500);
        assertEquals("Mordor", map.getMapName());
    }


    @Test(expected = IllegalArgumentException.class) //Skall ej gå igenom förrän felhantering i klassen är ordnat
    public void testNullLocationName() {
        Map nullMap = new Map(null, 500, 500);
        assertEquals(null, nullMap.getMapName());
    }

    @Test(expected = IllegalArgumentException.class) //empty string skall inte accepteras
    public void testEmptyString() {
        Map emptyStringMap = new Map("", 500, 500);
        assertEquals("The forbidden forest", emptyStringMap.getMapName());
    }

    @Test
    public void getMapHeight() throws Exception {
        Map theWoods = new Map("The forbidden forest", 500, 500);
        assertEquals(500, theWoods.getMapHeight());

    }

    @Test(expected = IllegalArgumentException.class)
    public void testNegativeHight() {
        Map theWoods = new Map("The forbidden forest", -10, 500);
        assertEquals(500, theWoods.getMapHeight());

    }

    @Test
    public void testMaxHeigth() {
        Map maxMap = new Map("addIntegerToHashMap", 1000, 500);
        assertEquals(1000, maxMap.getMapHeight());
    }

    @Test
    public void testOverMaxHeigth() {
        Map overMax = new Map("overMax", 1200, 500);
        assertEquals(1000, overMax.getMapHeight());
    }

    @Test
    public void testValidHeigth() {
        Map validHeight = new Map("validHeight", 500, 500);
        assertEquals(500, validHeight.getMapHeight());
    }

    @Test
    public void getMapWidth() throws Exception {
        Map theWoods = new Map("The forbidden forest", 500, 500);
        assertEquals(500, theWoods.getMapWidth());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNegativeWidth() throws Exception {
        Map theWoods = new Map("The forbidden forest", 500, -10);
        assertEquals(500, theWoods.getMapWidth());

    }

    @Test
    public void testOverMaxWidth() {
        Map overMaxWidth = new Map("overMaxWidth", 500, 1200);
        assertEquals(1000, overMaxWidth.getMapWidth());
    }
    /*@Test
    public void testCharacterWithinMap(){
        Map theWoods = new Map("The forbidden forest",500, 500 );
        GameCharacter mainCharacter = new GameCharacter(100, 100, "Gubbe");
        assertEquals(true, theWoods.isWithinMap(mainCharacter));
    }*/
}