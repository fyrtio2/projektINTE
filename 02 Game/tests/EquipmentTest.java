import org.junit.Test;

import static org.junit.Assert.*;

public class EquipmentTest {



    @Test
    public void isWearableByTest(){
        Character player = new Character(10,10, "Isaac"); // New player created level 1
        Equipment ring = new Equipment("Ring", 100, false, 2, 10); // Creates equipment with lvl 2 requirement

        player.levelUp(); // levels upp player to lvl 2

       assertEquals(ring.isWearableBy(player),true); // checks if player can wear the ring


    }



    @Test
    public void damageEquipmentTest(){
      Equipment helmet = new Equipment("Helmet", 100, false, 10, 10); // Helmet created with 10 durability
      helmet.damageEquipment(9); // Damages the equipments durability with 9 hit points
      assertEquals(helmet.getDurability(),1);


    }

    @Test
    public void testIfEquipmentBroken(){
        Equipment armor = new Equipment("Armor", 100, false, 10, 10); // Armor created with 10 durability
        armor.damageEquipment(9); // Damages the equipments durability with 10 hit points
        assertEquals(armor.isBroken(),true);



    }






    @Test
    public void getType() throws Exception {
    }

    @Test
    public void getStat() throws Exception {
    }

    @Test
    public void isEnchanted() throws Exception {
    }

    @Test
    public void getDurability() throws Exception {
        Equipment sword = new Equipment("Sword", 100, false, 10, 10);
        assertEquals(0, sword.getDurability());
    }

}