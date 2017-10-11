public class CharacterTest {
/*
    //HP Tests
    @Test
    public void hpTest() throws Exception {
        Character mainCharacter = new Character(100, 100, "Gubbe");
        assertEquals(100, mainCharacter.getHp());
    }

    @Test
    public void hpExceedsMaxHpLimitTest() throws Exception {
        Character mainCharacter = new Character(100, 200, "Gubbe");
        assertEquals(mainCharacter.getMaxHp(), mainCharacter.getHp());
    }

    @Test
    public void maxHpNegativeTest() throws Exception {
        Character mainCharacter = new Character(-100, 50, "Gubbe");
        assertNotEquals(-100, mainCharacter.getMaxHp());
    }

    @Test
    public void hpNegativeTest() throws Exception {
        Character mainCharacter = new Character(100, -10, "Gubbe");
        assertEquals(-10, mainCharacter.getHp());
    }

    @Test
    public void testMinimumIntHp() throws Exception {
        Character mainCharacter = new Character(100, Integer.MIN_VALUE, "Gubbe");
        assertEquals(Integer.MIN_VALUE, mainCharacter.getHp()); //Makes no sense right now

    }

    @Test
    public void hpZeroTest() throws Exception {
        Character mainCharacter = new Character(100, 0, "Gubbe");
        assertEquals(0, mainCharacter.getHp());
    }

    @Test
    public void testStartHp() {
        Character mainCharacter = new Character(100, 0, "Gubbe");
        assertEquals(0, mainCharacter.getHp());
    }

    //Name Test

    @Test
    public void NameTest() throws Exception {
        Character mainCharacter = new Character(100, 0, "kalle");
        assertEquals("kalle", mainCharacter.getName());
    }

    //Character Level Tests
    @Test
    public void getLevelTest() {
        Character character = new Character(100, 0, "kalle");
        int level = character.getLevel();
        assertEquals(1, level);
    }

    @Test
    public void testLevelUp() {
        Character character = new Character(100, 0, "kalle");
        character.levelUp();
        assertEquals(2, character.getLevel());
    }

    @Test
    public void testResetLevel() {
        Character character = new Character(100, 0, "kalle");
        character.levelUp();
        character.resetLevel();
        assertEquals(1, character.getLevel());
    }

    @Test
    public void testGetExperience() {
        Character mainCharacter = new Character(100, 0, "Gubbe");
        assertEquals(0, mainCharacter.getExperience());
    }

    @Test
    public void testExperienceReset() {
        Character mainCharacter = new Character(100, 0, "Gubbe");
        mainCharacter.resetExperience();
        assertEquals(0, mainCharacter.getExperience());
    }


    @Test
    public void testResetAfterTwoLevelUp() {
        Character character = new Character(100, 0, "kalle");
        for (int i = 0; i < 3; i++) {
            character.levelUp();
        }
        character.resetLevel();
        assertEquals(1, character.getLevel());
    }
    //Character Combat Tests

    @Test
    public void testMakeCharacterInCombat() throws Exception {
        Character mainCharacter = new Character(100, 0, "kalle");
        assertEquals(true, mainCharacter.makeCharacterInCombat());

    }

    @Test
    public void testCharacterInPeacefulStance() throws Exception {

        Character mainCharacter = new Character(100, 0, "kalle");
        mainCharacter.makeCharacterInPeacefulStance();
        assertEquals(false, mainCharacter.getIsInCombat());
    }

    @Test
    public void testAfterFight() throws Exception {
        Character character = new Character(100, 0, "Gubbe");
        character.afterCombat(true);
        assertEquals(false, character.getIsInCombat());
        assertEquals(10, character.getExperience());
        assertEquals(1, character.getLevel());
    }

    @Test
    public void testAfterSeveralFights() {
        Character character = new Character(100, 0, "Gubbe");
        for (int i = 0; i < 4; i++) {
            character.afterCombat(true);
        }
        assertEquals(false, character.getIsInCombat());
        assertEquals(0, character.getExperience());
        assertEquals(2, character.getLevel());
    }

    @Test
    public void testAfterEightFights() {
        Character character = new Character(100, 0, "Gubbe");
        for (int i = 0; i < 8; i++) {
            character.afterCombat(true);
        }
        assertEquals(false, character.getIsInCombat());
        assertEquals(0, character.getExperience());
        assertEquals(3, character.getLevel());
    }

    @Test
    public void testAfterFightIfBooleanTrue() {
        Character character = new Character(100, 0, "Gubbe");
        character.afterCombat(false);
        assertEquals(false, character.getIsInCombat());
    }

    //Character Alive Tests

    @Test
    public void testVariableIsAlive(){
        Character mainCharacter = new Character(100, 0, "kalle");
        assertEquals(true, mainCharacter.getIsAlive());
    }

    @Test
    public void testMakeAliveFalse(){
        Character mainCharacter = new Character(100, 0, "kalle");
        mainCharacter.makeCharacterInCombat();
        int currentHp = mainCharacter.getHp();
        int latterHp = 0;
        while (currentHp != 0){
             latterHp = currentHp - 1;
        }
        mainCharacter.makeCharacterDead(latterHp);
        assertEquals(false, mainCharacter.getIsAlive());
        assertEquals(0, mainCharacter.getExperience());
    }

    //Character Position Tests

    @Test
    public void testStartingPosition(){
        Character mainCharacter = new Character(100, 0, "kalle");
        int x = mainCharacter.getXPos();
        int y = mainCharacter.getYPos();
        assertEquals(20, x);
        assertEquals(10, y);
    }

    @Test
    public void testResetPosition(){
        Character mainCharacter = new Character(100, 0, "kalle");
        mainCharacter.resetPosition();
        int x = mainCharacter.getXPos();
        int y = mainCharacter.getYPos();

    }
*/
}