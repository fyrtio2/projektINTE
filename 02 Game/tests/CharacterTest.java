import org.junit.Test;

import static org.junit.Assert.*;

public class CharacterTest {
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
        assertEquals(0, mainCharacter.getHp());
    }


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
    public void testLevelUp(){}
    //Character Combat Tests

    @Test
    public void makeCharacterInCombatTest() throws Exception{
        Character mainCharacter = new Character(100, 0, "kalle");
        assertEquals(true, mainCharacter.makeCharacterInCombat());

    }

    @Test
    public void characterInPeacefulStance(){

        Character mainCharacter = new Character(100, 0, "kalle");
        //assertEquals();


    }
}