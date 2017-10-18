import org.junit.Test;

import static org.junit.Assert.*;

public class BagTest {

    @Test
    public void addToBagTest() {
        Bag bag = new Bag(10);

        Equipment ring = new Equipment(Equipment.Type.jewelry, "Ring", 2, 10, 10); // Creates equipment with level 2 requirement
        bag.addToBag(ring);

        assertEquals(ring, bag.getHashMap().get(ring.getName()));
    }

    @Test
    public void testWeight() {
        Bag bag = new Bag(10);
        Equipment ring = new Equipment(Equipment.Type.jewelry, "Ring", 2, 10, 10); // Creates equipment with level 2 requirement
        bag.addToBag(ring);
        bag.addWeight(ring);

        assertEquals(20, bag.getWeight());

    }

    @Test
    public void testRemoveFromBag() {
        Bag bag = new Bag(10);
        Equipment ring = new Equipment(Equipment.Type.jewelry, "Ring", 2, 10, 10); // Creates equipment with level 2 requirement
        bag.addToBag(ring);
        bag.removeFromBag(ring);

        assertEquals(0,bag.getHashMap().size());


    }


}