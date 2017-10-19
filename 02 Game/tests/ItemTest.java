import org.junit.Test;

import static org.junit.Assert.*;

public class ItemTest {

    // TESTS EQUIPMENT
    @Test
    public void isWearableByTest() {
        GameCharacter player = new GameCharacter("Isaac"); // New player created level 1
        EquipmentAttributes attributes = new EquipmentAttributes(5, 5, 5, 5, 5);
        Equipment ring = new Equipment(Equipment.Type.jewelry, "Ring", 2, 10, 10, attributes); // Creates equipment with level 2 requirement

        player.levelUp(); // levels upp player to lvl 2

        assertEquals(true, ring.isWearableBy(player)); // tests if player can wear the ring

    }

    @Test
    public void isNotWearableByTest() {
        GameCharacter player = new GameCharacter("Isaac"); // New player created level 1
        EquipmentAttributes attributes = new EquipmentAttributes(5, 5, 5, 5, 5);
        Equipment shoes = new Equipment(Equipment.Type.shoes, "fast shoes", 2, 10, 10, attributes); // Creates equipment with level 2 requirement

        assertEquals(false, shoes.isWearableBy(player)); // tests if player can wear the ring
    }

    @Test
    public void brokenWearableTest() {
        GameCharacter player = new GameCharacter("Isaac"); // New player created level 1
        EquipmentAttributes attributes = new EquipmentAttributes(5, 5, 5, 5, 5);
        Equipment ring = new Equipment(Equipment.Type.jewelry, "Ring", 2, 10, 10, attributes); // Creates equipment with level 2 requirement
        ring.damageEquipment(10);
        assertEquals(false, ring.isWearableBy(player)); // tests if player can wear the ring

    }


    @Test
    public void damageEquipmentTest() {
        EquipmentAttributes attributes = new EquipmentAttributes(5, 5, 5, 5, 5);
        Equipment helmet = new Equipment(Equipment.Type.helmet, "Helmet", 10, 10, 10, attributes); // Helmet created with 10 durability
        helmet.damageEquipment(9); // Damages the equipments durability with 9 hit points
        assertEquals(1, helmet.getDurability());  // tests if helmets durability has gone down to 1

    }

    @Test
    public void testIfEquipmentBroken() {
        EquipmentAttributes attributes = new EquipmentAttributes(5, 5, 5, 5, 5);
        Equipment armor = new Equipment(Equipment.Type.chestPlate, "Armor", 10, 10, 10, attributes); // Armor created with 10 durability
        armor.damageEquipment(10); // Damages the equipments durability with 10 hit points
        assertEquals(true, armor.isBroken());

    }


    @Test
    public void testDurability() {
        EquipmentAttributes attributes = new EquipmentAttributes(5, 5, 5, 5, 5);
        Equipment shield = new Equipment(Equipment.Type.shield, "shield", 10, 10, 10, attributes);
        assertEquals(10, shield.getDurability());
    }

    @Test
    public void testWeight() {
        EquipmentAttributes attributes = new EquipmentAttributes(5, 5, 5, 5, 5);
        Equipment shield = new Equipment(Equipment.Type.shield, "shield", 10, 10, 10, attributes);
        assertEquals(10, shield.getWeight());
    }

    @Test
    public void getNameTest() {
        EquipmentAttributes attributes = new EquipmentAttributes(5, 5, 5, 5, 5);
        Equipment sword = new Equipment(Equipment.Type.shield, "big shield", 10, 10, 10, attributes);
        assertEquals("big shield", sword.getName());

    }

    @Test(expected = IllegalArgumentException.class)
    public void testEmptyName() {
        EquipmentAttributes attributes = new EquipmentAttributes(5, 5, 5, 5, 5);
        Equipment gloves = new Equipment(Equipment.Type.gloves, "", 10, 10, 10, attributes);
        assertEquals("gloves", gloves.getName());

    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullName() {
        EquipmentAttributes attributes = new EquipmentAttributes(5, 5, 5, 5, 5);
        Equipment legPlate = new Equipment(Equipment.Type.legPlate, null, 10, 10, 10, attributes);
        assertEquals("legPlate", legPlate.getName());

    }

    @Test
    public void getTypeTest() {


    }

/// TEST WEAPON

    @Test
    public void testIFWeaponIsUsable() {
        GameCharacter player = new GameCharacter("Isaac"); // New player created level 1
        WeaponAttributes wb = new WeaponAttributes(100, 10, 10, 10, 10);
        Weapon sword = new Weapon("Sting", 20, 10, wb, 1);

        assertEquals(true, sword.isUsableBy(player));
    }

    @Test(expected = AssertionError.class)
    public void testIFWeaponIsNotUsable() {
        GameCharacter player = new GameCharacter("Isaac"); // New player created level 1
        WeaponAttributes wb = new WeaponAttributes(100, 10, 10, 10, 10);
        Weapon sword = new Weapon("Sting", 20, 10, wb, 3);

        assertEquals(true, sword.isUsableBy(player));
    }

    @Test(expected = AssertionError.class)
    public void testBrokenUsable() {
        GameCharacter player = new GameCharacter("Isaac"); // New player created level 1
        WeaponAttributes wb = new WeaponAttributes(100, 10, 10, 10, 10);
        Weapon sword = new Weapon("Sting", 20, 10, wb, 1);
        sword.damageWeapon(10);

        assertEquals(true, sword.isUsableBy(player));
    }

    @Test
    public void testDamageWeapon() {
        WeaponAttributes wb = new WeaponAttributes(100, 10, 10, 10, 10);
        Weapon sword = new Weapon("Sting", 20, 10, wb, 1);
        sword.damageWeapon(9);

        assertEquals(1, sword.getDurability());
    }

    @Test
    public void testIfWeaponIsBroken() {
        WeaponAttributes wb = new WeaponAttributes(100, 10, 10, 10, 10);
        Weapon sword = new Weapon("Sting", 20, 10, wb, 1);
        sword.damageWeapon(10);

        assertEquals(true, sword.isBroken());
    }


}