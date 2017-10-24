import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

public class GameCharacterTest {

    //HP Tests
    @Test
    public void testStartHpTest() throws Exception {
        GameCharacter mainCharacter = new GameCharacter("Gubbe");
        assertEquals(100, mainCharacter.getCurrentHp());
    }

    @Test(expected = AssertionError.class)
    public void hpExceedsMaxHpLimitTest() throws Exception {
        GameCharacter mainCharacter = new GameCharacter("Gubbe");
        int max = mainCharacter.getMaxHp();
        int current = mainCharacter.getCurrentHp();
        assertEquals(max, current + max);
    }

    @Test
    public void takeDamageBelowZeroHpTest() throws Exception {
        GameCharacter mainCharacter = new GameCharacter("Gubbe");
        assertEquals(0, mainCharacter.takeDamage(1000));
    }

    @Test(expected = AssertionError.class)
    public void hpNegativeTest() throws Exception {
        GameCharacter mainCharacter = new GameCharacter("Gubbe");
        assertEquals(-1, mainCharacter.takeDamage(1000));
    }

    @Test
    public void testDamageTaken() {
        GameCharacter g = new GameCharacter("gubbe");
        g.takeDamage(50);
        assertEquals(50, g.getCurrentHp());
    }

    @Test
    public void damageEqualToMaxHpTest() throws Exception {
        GameCharacter mainCharacter = new GameCharacter("Gubbe");
        assertEquals(0, mainCharacter.takeDamage(100));
    }

    //Name Test
    @Test
    public void nameTest() throws Exception {
        GameCharacter mainCharacter = new GameCharacter("kalle");
        assertEquals("kalle", mainCharacter.getName());
    }

    @Test(expected = AssertionError.class)
    public void checkEmptyStringTest() throws Exception {
        GameCharacter mainCharacter = new GameCharacter("");
        assertEquals("", mainCharacter.getName());
    }

    @Test
    public void checkNullStringTest() throws Exception {
        GameCharacter mainCharacter = new GameCharacter(null);
        assertNotNull(mainCharacter.getName());
    }

    @Test(expected = IllegalArgumentException.class)
    public void nameLengthTest() throws Exception {
        GameCharacter mainCharacter = new GameCharacter("Peter Yakob Test Namn");
        int size = mainCharacter.getName().length();
        assertEquals(21, size);
    }

    //GameCharacter Level Tests
    @Test
    public void getLevelTest() {
        GameCharacter character = new GameCharacter("kalle");
        int level = character.getLevel();
        assertEquals(1, level);
    }

    @Test
    public void levelUpTest() {
        GameCharacter character = new GameCharacter("kalle");
        character.levelUp();
        assertEquals(2, character.getLevel());
    }

    @Test
    public void levelUpMaxHpTest() {
        GameCharacter character = new GameCharacter("kalle");
        character.levelUp();
        assertEquals(110, character.getMaxHp());
    }

    @Test
    public void resetLevelTest() {
        GameCharacter character = new GameCharacter("kalle");
        character.levelUp();
        character.resetLevel();
        assertEquals(1, character.getLevel());
    }

    @Test
    public void resetMaxHpTest() {
        GameCharacter character = new GameCharacter("kalle");
        character.levelUp();
        character.resetLevel();
        assertEquals(100, character.getMaxHp());
    }

    @Test
    public void testGetExperience() {
        GameCharacter mainCharacter = new GameCharacter("Gubbe");
        assertEquals(0, mainCharacter.getExperience());
    }

    @Test
    public void testExperienceReset() {
        GameCharacter mainCharacter = new GameCharacter("Gubbe");
        mainCharacter.resetExperience();
        assertEquals(0, mainCharacter.getExperience());
    }

    @Test
    public void testResetAfterTwoLevelUp() {
        GameCharacter character = new GameCharacter("kalle");
        for (int i = 0; i < 3; i++) {
            character.levelUp();
        }
        character.resetLevel();
        assertEquals(1, character.getLevel());
    }

    //GameCharacter Combat Tests

    @Test
    public void testMakeCharacterInCombat() throws Exception {
        GameCharacter mainCharacter = new GameCharacter("kalle");
        assertEquals(true, mainCharacter.enterCombat());

    }

    @Test
    public void testCharacterInPeacefulStance() throws Exception {

        GameCharacter mainCharacter = new GameCharacter("kalle");
        mainCharacter.outOfCombat();
        assertEquals(false, mainCharacter.isCharacterInCombat());
    }

    @Test
    public void testIsInCombatAfterFight() throws Exception {
        GameCharacter character = new GameCharacter("Gubbe");
        character.afterCombat(true);
        assertEquals(false, character.isCharacterInCombat());
    }

    @Test
    public void testExperienceAfterFight() throws Exception {
        GameCharacter character = new GameCharacter("Gubbe");
        character.afterCombat(true);
        assertEquals(10, character.getExperience());
    }

    @Test
    public void testLevelAfterFight() throws Exception {
        GameCharacter character = new GameCharacter("Gubbe");
        character.afterCombat(true);
        assertEquals(1, character.getLevel());
    }

    @Test
    public void testIsInCombatAfterSeveralFights() {
        GameCharacter character = new GameCharacter("Gubbe");
        for (int i = 0; i < 4; i++) {
            character.afterCombat(true);
        }
        assertEquals(false, character.isCharacterInCombat());
    }

    @Test
    public void testExperienceAfterSeveralFights() {
        GameCharacter character = new GameCharacter("Gubbe");
        for (int i = 0; i < 4; i++) {
            character.afterCombat(true);
        }
        assertEquals(0, character.getExperience());
    }

    @Test
    public void testLevelAfterSeveralFights() {
        GameCharacter character = new GameCharacter("Gubbe");
        for (int i = 0; i < 4; i++) {
            character.afterCombat(true);
        }
        assertEquals(2, character.getLevel());
    }

    @Test
    public void testExperienceAfterEightFights() {
        GameCharacter character = new GameCharacter("Gubbe");
        for (int i = 0; i < 8; i++) {
            character.afterCombat(true);
        }
        assertEquals(0, character.getExperience());
    }

    @Test
    public void testLevelAfterEightFights() {
        GameCharacter character = new GameCharacter("Gubbe");
        for (int i = 0; i < 8; i++) {
            character.afterCombat(true);
        }
        assertEquals(3, character.getLevel());
    }

    @Test
    public void testInCombatAfterEightFights() {
        GameCharacter character = new GameCharacter("Gubbe");
        for (int i = 0; i < 8; i++) {
            character.afterCombat(true);
        }
        assertEquals(false, character.isCharacterInCombat());
    }

    @Test
    public void testAfterFightIfBooleanTrue() {
        GameCharacter character = new GameCharacter("Gubbe");
        character.afterCombat(false);
        assertEquals(false, character.isCharacterInCombat());
    }


    //GameCharacter Alive Tests

    @Test
    public void testVariableIsAlive() {
        GameCharacter mainCharacter = new GameCharacter("kalle");
        assertEquals(true, mainCharacter.getIsAlive());
    }

    @Test
    public void testMakeAliveFalse() {
        GameCharacter mainCharacter = new GameCharacter("kalle");
        mainCharacter.enterCombat();
        int currentHp = mainCharacter.getCurrentHp();
        mainCharacter.hpCounter(currentHp);
        mainCharacter.killCharacter();
        assertEquals(false, mainCharacter.getIsAlive());
    }

    @Test
    public void testHpCounter() {
        GameCharacter mainCharacter = new GameCharacter("kalle");
        int currentHp = mainCharacter.getCurrentHp();
        mainCharacter.hpCounter(currentHp);
        assertEquals(0, mainCharacter.getCurrentHp());
    }

    @Test
    public void testCheckExperienceAfterCharacterIsDead() {
        GameCharacter mainCharacter = new GameCharacter("kalle");
        mainCharacter.enterCombat();
        int currentHp = mainCharacter.getCurrentHp();
        mainCharacter.hpCounter(currentHp);
        mainCharacter.killCharacter();
        assertEquals(0, mainCharacter.getExperience());
    }

    //GameCharacter Position Tests

    @Test
    public void testStartingPositionX() {
        GameCharacter mainCharacter = new GameCharacter("kalle");
        assertEquals(20.0, mainCharacter.getXPos(), 0.1);
    }

    @Test
    public void testStartingPositionY() {
        GameCharacter mainCharacter = new GameCharacter("kalle");
        double y = mainCharacter.getYPos();
        assertEquals(10.0, y, 0.1);
    }

    @Test
    public void testResetPositionX() {
        GameCharacter mainCharacter = new GameCharacter("kalle");
        mainCharacter.moveRight();
        mainCharacter.enterCombat();
        mainCharacter.hpCounter(mainCharacter.getCurrentHp());
        mainCharacter.killCharacter();
        assertEquals(20.0, mainCharacter.getXPos(), 0.1);

    }

    @Test
    public void testResetPositionY() {
        GameCharacter mainCharacter = new GameCharacter("kalle");
        mainCharacter.moveRight();
        mainCharacter.moveDown();
        mainCharacter.enterCombat();
        mainCharacter.hpCounter(mainCharacter.getCurrentHp());
        mainCharacter.killCharacter();
        assertEquals(10.0, mainCharacter.getYPos(), 0.1);
    }

    @Test
    public void moveRightTest() { // Testar flytta 1.0 till höger
        GameCharacter g = new GameCharacter("Oscar");
        g.moveRight();
        assertEquals(21.0, g.getXPos(), 0.1);
    }

    @Test
    public void moveRightWithHigherSpeed() {
        GameCharacter g = new GameCharacter("Oscar");
        g.getCharAttributes().increaseMovementSpeed(0.5);
        g.moveRight();
        g.moveRight();
        assertEquals(23, g.getXPos(), 0.1);
    }

    @Test
    public void moveRightAndChangeSpeedInTheMiddle() {
        GameCharacter g = new GameCharacter("Oscar");
        g.moveRight();
        g.getCharAttributes().increaseMovementSpeed(0.5);
        g.moveRight();
        g.getCharAttributes().increaseMovementSpeed(0.5);
        g.moveRight();
        assertEquals(24.5, g.getXPos(), 0.1);
    }

    //Equipment Tests

    @Test
    public void pickUpItemTest() {
        GameCharacter mainGameCharacter = new GameCharacter("kalle");
        EquipmentAttributes attributes = new EquipmentAttributes(5, 5, 5, 5, 5);
        Equipment helmet = new Equipment(Equipment.Type.helmet, "HELMET OF FURY!", 10, 10, 10, attributes);
        mainGameCharacter.pickUpItem(helmet);
        Bag bag = mainGameCharacter.getBag();
        assertEquals(helmet, bag.getHashMap().get(helmet.getName()));
    }

    @Test
    public void equipEquipmentTest() {
        GameCharacter mainGameCharacter = new GameCharacter("kalle");
        EquipmentAttributes attributes = new EquipmentAttributes(5, 5, 5, 5, 5);

        Equipment helmet = new Equipment(Equipment.Type.helmet, "HELMET OF FURY!", 10, 10, 10, attributes);
        mainGameCharacter.useEquipment(helmet);
    }

    @Test
   public void addTooManyEquipmentsTest() {



        GameCharacter player = new GameCharacter("Oscar");

        EquipmentAttributes attributes = new EquipmentAttributes(5, 5, 5, 5, 5);

        Equipment helmet = new Equipment(Equipment.Type.helmet, "helmet", 10, 10, 10, attributes);
        Equipment chestPlate = new Equipment(Equipment.Type.chestPlate, "chestplate", 10, 10, 10, attributes);
        Equipment legPlate = new Equipment(Equipment.Type.legPlate, "legplate", 10, 10, 10, attributes);
        Equipment shoes = new Equipment(Equipment.Type.shoes, "shoes", 10, 10, 10, attributes);
        Equipment gloves = new Equipment(Equipment.Type.gloves, "gloves", 10, 10, 10, attributes);
        Equipment jewelry = new Equipment(Equipment.Type.jewelry, "jewelry", 10, 10, 10, attributes);
        Equipment shield = new Equipment(Equipment.Type.shield, "shield", 10, 10, 10, attributes);
        //****************************************************************************// All equipment slots filled
        Equipment helmet2 = new Equipment(Equipment.Type.helmet, "helmet2", 10, 10, 10, attributes);

        player.useEquipment(helmet);
        player.useEquipment(chestPlate);
        player.useEquipment(legPlate);
        player.useEquipment(shoes);
        player.useEquipment(gloves);
        player.useEquipment(jewelry);
        player.useEquipment(shield);

        player.useEquipment(helmet2); //Should not be added


        assertFalse(player.isEquipmentInUse(helmet2));




    }

    @Test
    public void addEquipmentOfSameTypeTest() {
        GameCharacter player = new GameCharacter("Oscar");
        EquipmentAttributes attributes = new EquipmentAttributes(5, 5, 5, 5, 5);

        Equipment chestPlate = new Equipment(Equipment.Type.chestPlate, "chestplate", 10, 10, 10, attributes);
        Equipment chestPlate2 = new Equipment(Equipment.Type.chestPlate, "chestplate2", 10, 10, 10, attributes);
        player.useEquipment(chestPlate); // Should still exist in hashMap after we try to add chestplate2
        player.useEquipment(chestPlate2); // Should not exits

        assertTrue((player.isEquipmentInUse(chestPlate)));
    }

    @Test
    public void unequipTest(){
        GameCharacter player = new GameCharacter("Oscar");
        EquipmentAttributes attributes = new EquipmentAttributes(5, 5, 5, 5, 5);

        Equipment shield = new Equipment(Equipment.Type.shield, "shield", 10, 10, 10, attributes);
        player.useEquipment(shield);
        player.unEquip(shield);

        assertFalse(player.isEquipmentInUse(shield));


    }

    @Test
    public void unequipWrongItemTest(){
        GameCharacter player = new GameCharacter("Oscar");
        EquipmentAttributes attributes = new EquipmentAttributes(5, 5, 5, 5, 5);

        Equipment shield = new Equipment(Equipment.Type.shield, "shield", 10, 10, 10, attributes);
        Equipment otherShield = new Equipment(Equipment.Type.shield, "shield", 10, 10, 10, attributes);
        player.useEquipment(shield);
        player.unEquip(otherShield); // unequips the shield that has not been equipped

        assertTrue(player.isEquipmentInUse(shield));


    }

    @Test
    public void wieldTwoWeaponTest(){

        GameCharacter player = new GameCharacter("Oscar");
        WeaponAttributes weaponAttributes = new WeaponAttributes(10,10,10,10,10);


        Weapon sword = new Weapon("Sword of doom",10,10,weaponAttributes,0);
        Weapon sword2 = new Weapon("Sword of light",10,10,weaponAttributes,0);
        player.wieldWeapon(sword);
        player.wieldWeapon(sword2);

        assertFalse(player.isCharacterWieldingWeapon(sword2));


    }

    @Test
    public void unWieldWeaponTest(){

        GameCharacter player = new GameCharacter("Oscar");
        WeaponAttributes weaponAttributes = new WeaponAttributes(10,10,10,10,10);

        Weapon sword = new Weapon("Sword of doom",10,10,weaponAttributes,0);

        player.wieldWeapon(sword);
        player.unEquip(sword);

        assertFalse(player.isCharacterWieldingWeapon(sword));


    }

    @Test
    public void weaponAlreadyWieldedTest(){

        GameCharacter player = new GameCharacter("Oscar");
        WeaponAttributes weaponAttributes = new WeaponAttributes(10,10,10,10,10);
        WeaponAttributes weaponAttributes2 = new WeaponAttributes(10,10,10,10,10);

        Weapon swordOfDoom = new Weapon("Sword of doom",10,10,weaponAttributes,0);
        Weapon swordOfFury = new Weapon("Sword of fury",10,10,weaponAttributes2,0);


        player.wieldWeapon(swordOfDoom);
        player.unEquip(swordOfFury);// sword 2 should not be wielded

        assertTrue(player.isCharacterWieldingWeapon(swordOfDoom));


    }

}