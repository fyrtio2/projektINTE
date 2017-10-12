import org.junit.Test;

import static org.junit.Assert.*;

public class EquipmentTest {


    @Test
    public void isWearableByTest() {
        GameCharacter player = new GameCharacter("Isaac"); // New player created level 1
        Equipment ring = new Equipment("Ring",  2, 10,10,10); // Creates equipment with level 2 requirement

        player.levelUp(); // levels upp player to lvl 2

        assertEquals( true,ring.isWearableBy(player)); // tests if player can wear the ring

    }


    @Test
    public void isNotWearableByTest() {
        GameCharacter player = new GameCharacter("Isaac"); // New player created level 1
        Equipment ring = new Equipment("Ring",  2, 10,10,10); // Creates equipment with level 2 requirement

        assertEquals(false,ring.isWearableBy(player)); // tests if player can wear the ring
    }

    @Test
    public void brokenWearableTest() {
        GameCharacter player = new GameCharacter("Isaac"); // New player created level 1
        Equipment ring = new Equipment("Ring",  2, 10,10,10); // Creates equipment with level 2 requirement
        ring.damageEquipment(10);
        assertEquals(false,ring.isWearableBy(player)); // tests if player can wear the ring

    }


    @Test
    public void damageEquipmentTest() {
        Equipment helmet = new Equipment("Helmet",  10, 10,10,10); // Helmet created with 10 durability
        helmet.damageEquipment(9); // Damages the equipments durability with 9 hit points
        assertEquals(1,helmet.getDurability());  // tests if helmets durability has gone down to 1

    }

    @Test
    public void testIfEquipmentBroken() {
        Equipment armor = new Equipment("Armor",  10, 10,10,10); // Armor created with 10 durability
        armor.damageEquipment(10); // Damages the equipments durability with 10 hit points
        assertEquals(true,armor.isBroken());

    }




    @Test
    public void getDurability() throws Exception {
        Equipment sword = new Equipment("Sword",  10, 10,10,10);
        assertEquals(10, sword.getDurability());
    }


    @Test
    public void getNameTest(){
        Equipment sword = new Equipment("Sword", 10, 10,10,10);
        assertEquals("Sword",sword.getName());

    }


}