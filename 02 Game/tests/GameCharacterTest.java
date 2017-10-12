import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class GameCharacterTest {
    //
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
/*
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
    public void testAfterFight() throws Exception {
        GameCharacter character = new GameCharacter("Gubbe");
        character.afterCombat(true);
        assertEquals(false, character.getIsInCombat());
        assertEquals(10, character.getExperience());
        assertEquals(1, character.getLevel());
    }

    @Test
    public void testAfterSeveralFights() {
        GameCharacter character = new GameCharacter("Gubbe");
        for (int i = 0; i < 4; i++) {
            character.afterCombat(true);
        }
        assertEquals(false, character.getIsInCombat());
        assertEquals(0, character.getExperience());
        assertEquals(2, character.getLevel());
    }

    @Test
    public void testAfterEightFights() {
        GameCharacter character = new GameCharacter("Gubbe");
        for (int i = 0; i < 8; i++) {
            character.afterCombat(true);
        }
        assertEquals(false, character.getIsInCombat());
        assertEquals(0, character.getExperience());
        assertEquals(3, character.getLevel());
    }

    @Test
    public void testAfterFightIfBooleanTrue() {
        GameCharacter character = new GameCharacter("Gubbe");
        character.afterCombat(false);
        assertEquals(false, character.getIsInCombat());
    }

    //GameCharacter Alive Tests

    @Test
    public void testVariableIsAlive(){
        GameCharacter mainCharacter = new GameCharacter("kalle");
        assertEquals(true, mainCharacter.getIsAlive());
    }

    @Test
    public void testMakeAliveFalse(){
        GameCharacter mainCharacter = new GameCharacter("kalle");
        mainCharacter.makeCharacterInCombat();
        int currentHp = mainCharacter.getCurrentHp();
        int latterHp = 0;
        while (currentHp != 0){
             latterHp = currentHp - 1;
        }
        mainCharacter.makeCharacterDead(latterHp);
        assertEquals(false, mainCharacter.getIsAlive());
        assertEquals(0, mainCharacter.getExperience());
    }

    //GameCharacter Position Tests

    @Test
    public void testStartingPosition(){
        GameCharacter mainCharacter = new GameCharacter("kalle");
        int x = mainCharacter.getXPos();
        int y = mainCharacter.getYPos();
        assertEquals(20, x);
        assertEquals(10, y);
    }

    @Test
    public void testResetPosition(){
        GameCharacter mainCharacter = new GameCharacter("kalle");
        mainCharacter.resetPosition();
        int x = mainCharacter.getXPos();
        int y = mainCharacter.getYPos();

    }
*/
/*

    @Test
    public void pickUpItemTest(){
        GameCharacter mainGameCharacter = new GameCharacter("kalle");

        Equipment helmet = new Equipment("Helmet",  10, 10,10,10);

        mainGameCharacter.pickUp(helmet);
        Bag bag = mainGameCharacter.getBag();

        assertEquals(helmet,bag.getHashMap().get(helmet.getName()));


    }

    @Test
    public void moveRightTest() { // Testar flytta 1.0 till höger
        GameCharacter g = new GameCharacter("Oscar");
        g.moveRight();
        assertEquals(21.0, g.getXPos(), 0.1 );
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

*/
}