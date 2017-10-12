import org.junit.Test;

import static org.junit.Assert.*;

public class ItemTest {

// TESTS EQUIPMENT
    @Test
    public void isWearableByTest() {
        GameCharacter player = new GameCharacter("Isaac"); // New player created level 1
        Equipment ring = new Equipment(Equipment.Type.jewelry,"Ring",  2, 10,10,10); // Creates equipment with level 2 requirement

        player.levelUp(); // levels upp player to lvl 2

        assertEquals( true,ring.isWearableBy(player)); // tests if player can wear the ring

    }


    @Test
    public void isNotWearableByTest() {
        GameCharacter player = new GameCharacter("Isaac"); // New player created level 1
        Equipment shoes = new Equipment(Equipment.Type.shoes,"fast shoes",  2, 10,10,10); // Creates equipment with level 2 requirement

        assertEquals(false,shoes.isWearableBy(player)); // tests if player can wear the ring
    }

    @Test
    public void brokenWearableTest() {
        GameCharacter player = new GameCharacter("Isaac"); // New player created level 1
        Equipment ring = new Equipment(Equipment.Type.jewelry,"Ring",  2, 10,10,10); // Creates equipment with level 2 requirement
        ring.damageEquipment(10);
        assertEquals(false,ring.isWearableBy(player)); // tests if player can wear the ring

    }


    @Test
    public void damageEquipmentTest() {
        Equipment helmet = new Equipment(Equipment.Type.helmet,"Helmet",  10, 10,10,10); // Helmet created with 10 durability
        helmet.damageEquipment(9); // Damages the equipments durability with 9 hit points
        assertEquals(1,helmet.getDurability());  // tests if helmets durability has gone down to 1

    }

    @Test
    public void testIfEquipmentBroken() {
        Equipment armor = new Equipment(Equipment.Type.chestPlate,"Armor",  10, 10,10,10); // Armor created with 10 durability
        armor.damageEquipment(10); // Damages the equipments durability with 10 hit points
        assertEquals(true,armor.isBroken());

    }



    @Test
    public void getDurability() throws Exception {
        Equipment shield = new Equipment(Equipment.Type.shield,"shield",  10, 10,10,10);
        assertEquals(10, shield.getDurability());
    }


    @Test
    public void getNameTest(){
        Equipment sword = new Equipment(Equipment.Type.shield,"big shield", 10, 10,10,10);
        assertEquals("big shield",sword.getName());

    }

    @Test(expected = IllegalArgumentException.class)
    public void testEmptyName(){
        Equipment gloves = new Equipment(Equipment.Type.gloves,"", 10, 10,10,10);
        assertEquals("gloves",gloves.getName());

    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullName(){
        Equipment legPlate = new Equipment(Equipment.Type.legPlate,null, 10, 10,10,10);
        assertEquals("legPlate",legPlate.getName());

    }

    @Test
    public void getTypeTest(){


    }

/// TEST WEAPON

}