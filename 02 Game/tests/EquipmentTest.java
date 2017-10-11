import org.junit.Test;

import static org.junit.Assert.*;

public class EquipmentTest {

    @Test
    public void isWearableByTest() {
        ItemAttributes itemAttributes = new ItemAttributes(10);
        Character player = new Character("Isaac"); // New player created level 1
        Equipment ring = new Equipment("Ring", 2, itemAttributes, 10,10); // Creates equipment with level 2 requirement

        player.levelUp(); // levels upp player to lvl 2

        assertEquals(ring.isWearableBy(player), true); // tests if player can wear the ring
    }

    @Test
    public void isNotWearableByTest() {
        ItemAttributes itemAttributes = new ItemAttributes(10);
        Character player = new Character("Isaac"); // New player created level 1
        Equipment ring = new Equipment("Ring", 2, itemAttributes, 10,10); // Creates equipment with level 2 requirement

        assertEquals(ring.isWearableBy(player), false); // tests if player can wear the ring
    }

    @Test
    public void brokenWearableTest() {
        ItemAttributes itemAttributes = new ItemAttributes(10);
        Character player = new Character("Isaac"); // New player created level 1
        Equipment ring = new Equipment("Ring",  2, itemAttributes, 10,10); // Creates equipment with level 2 requirement
        ring.damageEquipment(10);
        assertEquals(ring.isWearableBy(player), false); // tests if player can wear the ring

    }


    @Test
    public void damageEquipmentTest() {
        ItemAttributes itemAttributes = new ItemAttributes(10);

        Equipment helmet = new Equipment("Helmet",  10, itemAttributes, 10,10); // Helmet created with 10 durability
        helmet.damageEquipment(9); // Damages the equipments durability with 9 hit points
        ItemAttributes attributes = helmet.getItemAttributes();

        assertEquals(attributes.getDurability(), 1);  // tests if helmets durability has gone down to 1

    }

    @Test
    public void testIfEquipmentBroken() {
        ItemAttributes itemAttributes = new ItemAttributes(10);
        Equipment armor = new Equipment("Armor", 10, itemAttributes, 10,10); // Armor created with 10 durability
        armor.damageEquipment(10); // Damages the equipments durability with 10 hit points
        assertEquals(armor.isBroken(), true);

    }


    @Test
    public void isEnchantedTest() throws Exception {
        ItemAttributes itemAttributes = new ItemAttributes(10);
        Equipment axe = new Equipment("Axe",  10, itemAttributes, 10,10);
        axe.enchantItem();
        assertEquals(axe.isEnchanted(), true);
    }




    @Test
    public void getNameTest() {
        ItemAttributes itemAttributes = new ItemAttributes(10);
        Equipment sword = new Equipment("Sword", 10, itemAttributes, 10,10);
        assertEquals(sword.getName(), "Sword");

    }


}