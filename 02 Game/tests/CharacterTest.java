import org.junit.Test;

import static org.junit.Assert.*;

public class CharacterTest {

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
    public void testMinimumIntHp() throws Exception{
        Character mainCharacter = new Character(100, Integer.MIN_VALUE, "Gubbe");
        assertEquals(Integer.MIN_VALUE, mainCharacter.getHp()); //Makes no sense right now

    }

    @Test
    public void hpZeroTest() throws Exception {
        Character mainCharacter = new Character(100, 0, "Gubbe");
        assertEquals(1, mainCharacter.getHp());
    }

    @Test
    public void testStartHp(){
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
    public void getLevelTest(){
        Character character = new Character(100, 0, "kalle");
        int level = character.getLevel();
        assertEquals(0, level);
    }

    @Test
    public void testLevelUp(){
        Character character = new Character(100, 0, "kalle");
        character.levelUp();
        assertEquals(1, character.getLevel());
    }

    @Test
    public void testResetLevel(){
        Character character = new Character(100, 0, "kalle");
        character.levelUp();
        character.resetLevel();
        assertEquals(0, character.getLevel());
    }


    @Test
    public void testResetAfterTwoLevelUp(){
        Character character = new Character(100, 0, "kalle");
        for(int i = 0; i < 3; i++){
            character.levelUp();
        }
        character.resetLevel();
        assertEquals(0, character.getLevel());
    }
    //Character Combat Tests

    @Test
    public void makeCharacterInCombatTest() throws Exception{
        Character mainCharacter = new Character(100, 0, "kalle");
        assertEquals(true, mainCharacter.makeCharacterInCombat());

    }

    @Test
    public void testCharacterInPeacefulStance(){

        Character mainCharacter = new Character(100, 0, "kalle");
        mainCharacter.makeCharacterInPeacefulStance();
        assertEquals(false, mainCharacter.getIsInCombat());


    }

}