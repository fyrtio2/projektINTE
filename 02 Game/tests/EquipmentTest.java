import org.junit.Test;

import static org.junit.Assert.*;

public class EquipmentTest {
    @Test
    public void canWear() throws Exception {
        Equipment newEquip = new Equipment("Platearmor",100,false, 10);
        Character player = new Character(10,10,10,"Isaac");

        assertNotEquals(player.getLvl(),newEquip.getLvlreq());


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
        Equipment sword = new Equipment(3);
        assertEquals(0,sword.getDurability());
    }

}