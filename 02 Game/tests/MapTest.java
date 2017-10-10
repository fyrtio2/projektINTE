import org.junit.Test;

import static org.junit.Assert.*;

public class MapTest {
    @Test
    public void getLocationName() throws Exception {
        Map theWoods = new Map("The forbidden forest",500, 500 );
        assertEquals("The forbidden forest", theWoods.getLocationName());
    }

    @Test(expected = AssertionError.class) //Skall ej gå igenom förrän felhantering i klassen är ordnat
    public void testNullLocationName(){
        Map nullMap = new Map(null, 500, 500);
        assertEquals(null, nullMap.getLocationName());
    }

    @Test
    public void getMapHeight() throws Exception {
    }

    @Test
    public void getMapWidth() throws Exception {
    }

}