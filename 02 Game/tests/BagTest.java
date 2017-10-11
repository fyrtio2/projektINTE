import org.junit.Test;

import static org.junit.Assert.*;

public class BagTest {


    @Test
    public void addToBagTest() {
        Character player = new Character(10, 10, "Isaac"); // New player created level 1
        Item ring = new Equipment("Ring", 100, 2, 10,10,10); // Creates equipment with level 2 requirement

        player.pickUp(ring);

        Bag bag = player.getBag();

        assertEquals( ring ,bag.getBagMap().get(ring.getName()));






    }

}