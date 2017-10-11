import org.junit.Test;

import static org.junit.Assert.*;

public class EquipmentTest {


    @Test
    public void isWearableByTest() {
        Character player = new Character(10, 10, "Isaac"); // New player created level 1
        Equipment ring = new Equipment("Ring", 100, 2, 10,10,10); // Creates equipment with level 2 requirement

        player.levelUp(); // levels upp player to lvl 2

        assertEquals(ring.isWearableBy(player), true); // tests if player can wear the ring

    }


    @Test
    public void isNotWearableByTest() {
        Character player = new Character(10, 10, "Isaac"); // New player created level 1
        Equipment ring = new Equipment("Ring", 100, 2, 10,10,10); // Creates equipment with level 2 requirement

        assertEquals(ring.isWearableBy(player), false); // tests if player can wear the ring

    }

    @Test
    public void brokenWearableTest() {
        Character player = new Character(10, 10, "Isaac"); // New player created level 1
        Equipment ring = new Equipment("Ring", 100, 2, 10,10,10); // Creates equipment with level 2 requirement
        ring.damageEquipment(10);
        assertEquals(ring.isWearableBy(player), false); // tests if player can wear the ring

    }


    @Test
    public void damageEquipmentTest() {
        Equipment helmet = new Equipment("Helmet", 100,  10, 10,10,10); // Helmet created with 10 durability
        helmet.damageEquipment(9); // Damages the equipments durability with 9 hit points
        assertEquals(helmet.getDurability(), 1);  // tests if helmets durability has gone down to 1

    }

    @Test
    public void testIfEquipmentBroken() {
        Equipment armor = new Equipment("Armor", 100, 10, 10,10,10); // Armor created with 10 durability
        armor.damageEquipment(10); // Damages the equipments durability with 10 hit points
        assertEquals(armor.isBroken(), true);

    }


    @Test
    public void isEnchantedTest() throws Exception {
        Equipment axe = new Equipment("Axe", 100, 10, 10,10,10);
        axe.enchantItem();
        assertEquals(axe.isEnchanted(),true);
    }


    @Test
    public void getDurability() throws Exception {
        Equipment sword = new Equipment("Sword", 100, 10, 10,10,10);
        assertEquals(10, sword.getDurability());
    }


    @Test
    public void getNameTest(){
        Equipment sword = new Equipment("Sword", 100, 10, 10,10,10);
        assertEquals(sword.getName(),"Sword");

    }



}