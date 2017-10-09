import org.junit.Test;

import static org.junit.Assert.*;

public class EquipmentTest {
    private Equipment newEquip = new Equipment("Platearmor",100,false, 10);
    private Character player = new Character(10,10,10,"Isaac");



    @Test
    public void canNotWear() throws Exception {

        assertNotEquals(player.getLvl(),newEquip.getLvlReq());
        //Platearmor kan inte bäras av player eftersom karaktären är lvl 0 när den skapas


    }
    @Test
    public void canWear(){
        player.lvlUp(10); // karaktären lvlar upp till lvl 10
        assertEquals(player.getLvl(),newEquip.getLvlReq());
        player.resetLvl();



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