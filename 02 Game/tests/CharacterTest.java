import org.junit.Test;

import static org.junit.Assert.*;

public class CharacterTest {
    @Test
    public void getHp() throws Exception {
        Character mainCharacter = new Character(100, 3.6f, "Gubbe");
        assertEquals(100, mainCharacter.getHp());
    }

    @Test
    public void getHpNegative() throws Exception {
        Character mainCharacter = new Character(-10, 3.6f, "Gubbe");
        assertNotEquals(-10, mainCharacter.getHp());
    }

    @Test
    public void getHpZero() throws Exception {
        Character mainCharacter = new Character(0, 3.6f, "Gubbe");
        assertEquals(0, mainCharacter.getHp());
    }

    @Test
    public void getSpeed() throws Exception {
    }

    @Test
    public void getName() throws Exception {
        Character mainCharacter = new Character(0, 3.6f, "Gubbe");
        assertEquals("kalle", mainCharacter.getName());

    }
}