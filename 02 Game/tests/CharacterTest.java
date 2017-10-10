import org.junit.Test;

import static org.junit.Assert.*;

public class CharacterTest {
    @Test
    public void hpTest() throws Exception {
        Character mainCharacter = new Character(100, 100, 3.6, "Gubbe");
        assertEquals(100, mainCharacter.getHp());
    }

    @Test
    public void hpExceedsMaxHpLimitTest() throws Exception {
        Character mainCharacter = new Character(100, 200, 3.6, "Gubbe");
        assertEquals(mainCharacter.getMaxHp(), mainCharacter.getHp());
    }

    @Test
    public void maxHpNegativeTest() throws Exception {
        Character mainCharacter = new Character(-100, 50, 3.6, "Gubbe");
        assertNotEquals(-100, mainCharacter.getMaxHp());
    }

    @Test
    public void hpNegativeTest() throws Exception {
        Character mainCharacter = new Character(100, -10, 3.6, "Gubbe");
        assertEquals(-10, mainCharacter.getHp());
    }

    @Test
    public void hpZeroTest() throws Exception {
        Character mainCharacter = new Character(100, 0, 3.6, "Gubbe");
        assertEquals(0, mainCharacter.getHp());
    }

    @Test
    public void SpeedTest() throws Exception {
        Character mainCharacter = new Character(100, 0, 3.6, "kalle");
        assertEquals(3.6f, mainCharacter.getSpeed(), 0.5);
    }

    @Test
    public void NameTest() throws Exception {
        Character mainCharacter = new Character(100, 0, 3.6, "kalle");
        assertEquals("kalle", mainCharacter.getName());
    }
    //Character Combat Tests

    @Test
    public void makeCharacterInCombatTest() throws Exception{
        Character mainCharacter = new Character();
        assertEquals(true, mainCharacter.makeCharacterInCombat());

    }

    @Test
    public void characterInPeacefulStance(){
        Character mainCharacter = new Character();
        assertEquals();
    }
}