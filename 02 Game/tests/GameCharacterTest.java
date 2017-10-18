import org.junit.Test;

import java.util.HashMap;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
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

    //
    //Name Test
    @Test
    public void NameTest() throws Exception {
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
        assertEquals(true, mainCharacter.makeCharacterInCombat());

    }

    @Test
    public void testCharacterInPeacefulStance() throws Exception {

        GameCharacter mainCharacter = new GameCharacter("kalle");
        mainCharacter.makeCharacterInPeacefulStance();
        assertEquals(false, mainCharacter.getIsInCombat());
    }

    @Test
    public void testIsInCombatAfterFight() throws Exception {
        GameCharacter character = new GameCharacter("Gubbe");
        character.afterCombat(true);
        assertEquals(false, character.getIsInCombat());
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
        assertEquals(false, character.getIsInCombat());
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
        assertEquals(false, character.getIsInCombat());
    }

    @Test
    public void testAfterFightIfBooleanTrue() {
        GameCharacter character = new GameCharacter("Gubbe");
        character.afterCombat(false);
        assertEquals(false, character.getIsInCombat());
    }

    //GameCharacter Alive Tests

    @Test
    public void testVariableIsAlive() {
        GameCharacter mainCharacter = new GameCharacter("kalle");
        assertEquals(true, mainCharacter.getIsAlive());
    }

    //
    @Test
    public void testMakeAliveFalse() {
        GameCharacter mainCharacter = new GameCharacter("kalle");
        mainCharacter.makeCharacterInCombat();
        int currentHp = mainCharacter.getCurrentHp();
        mainCharacter.hpCounter(currentHp);
        mainCharacter.makeCharacterDead();
        assertEquals(false, mainCharacter.getIsAlive());
    }

    @Test
    public void testHpCounter() {
        GameCharacter mainCharacter = new GameCharacter("kalle");
        int currentHp = mainCharacter.getCurrentHp();
        mainCharacter.hpCounter(currentHp);
        assertEquals(0, mainCharacter.getCurrentHp());
    }

    //
    @Test
    public void testCheckExperienceAfterCharacterIsDead() {
        GameCharacter mainCharacter = new GameCharacter("kalle");
        mainCharacter.makeCharacterInCombat();
        int currentHp = mainCharacter.getCurrentHp();
        mainCharacter.hpCounter(currentHp);
        mainCharacter.makeCharacterDead();
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
        mainCharacter.makeCharacterInCombat();
        mainCharacter.hpCounter(mainCharacter.getCurrentHp());
        mainCharacter.makeCharacterDead();
        mainCharacter.resetPosition();
        assertEquals(20.0, mainCharacter.getXPos(), 0.1);

    }

    @Test
    public void testResetPositionY() {
        GameCharacter mainCharacter = new GameCharacter("kalle");
        mainCharacter.moveRight();
        mainCharacter.moveDown();
        mainCharacter.makeCharacterInCombat();
        mainCharacter.hpCounter(mainCharacter.getCurrentHp());
        mainCharacter.makeCharacterDead();
        mainCharacter.resetPosition();
        assertEquals(10.0, mainCharacter.getYPos(), 0.1);
    }

    //

    @Test
    public void pickUpItemTest() {
        GameCharacter mainGameCharacter = new GameCharacter("kalle");
        Equipment helmet = new Equipment(Equipment.Type.helmet, "HELMET OF FURY!", 10, 10, 10);
        mainGameCharacter.pickUp(helmet);
        Bag bag = mainGameCharacter.getBag();
        assertEquals(helmet, bag.getHashMap().get(helmet.getName()));
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

    @Test
    public void addTooManyEquipmentsTest() {



        GameCharacter player = new GameCharacter("Oscar");
        HashMap equippedEquipment = player.getEquippedEquipment();
        equippedEquipment.clear();


        Equipment helmet = new Equipment(Equipment.Type.helmet, "helmet", 10, 10, 10);
        Equipment chestPlate = new Equipment(Equipment.Type.chestPlate, "chestplate", 10, 10, 10);
        Equipment legPlate = new Equipment(Equipment.Type.legPlate, "legplate", 10, 10, 10);
        Equipment shoes = new Equipment(Equipment.Type.shoes, "shoes", 10, 10, 10);
        Equipment gloves = new Equipment(Equipment.Type.gloves, "gloves", 10, 10, 10);
        Equipment jewelry = new Equipment(Equipment.Type.jewelry, "jewelry", 10, 10, 10);
        //****************************************************************************// All equipment slots filled
        Equipment helmet2 = new Equipment(Equipment.Type.helmet, "helmet2", 10, 10, 10);

        player.equipEquipment(helmet);
        player.equipEquipment(chestPlate);
        player.equipEquipment(legPlate);
        player.equipEquipment(shoes);
        player.equipEquipment(gloves);
        player.equipEquipment(jewelry);


        player.equipEquipment(helmet2); //Should not be added




        assertTrue(!(equippedEquipment.containsKey(helmet2.getType())));


    }

    @Test
    public void addEquipmentOfSameTypeTest() {

        GameCharacter player = new GameCharacter("Oscar");


        Equipment chestPlate = new Equipment(Equipment.Type.chestPlate, "chestplate", 10, 10, 10);
        Equipment chestPlate2 = new Equipment(Equipment.Type.chestPlate, "chestplate2", 10, 10, 10);
        player.equipEquipment(chestPlate); // Should still exist in hashMap after we try to add chestplate2
        player.equipEquipment(chestPlate2);

        Bag bag = player.getBag();

        assertTrue((bag.getHashMap().containsKey(chestPlate.getName())) && bag.getHashMap().get(chestPlate.getName()) != null);


    }
}