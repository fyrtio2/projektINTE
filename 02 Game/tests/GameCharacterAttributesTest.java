import org.junit.Test;

import static org.junit.Assert.assertEquals;

//TODO: Skapa testfall för critchans/dmg när man tar på sig och tar av sig equpment ca 4 testfall.
public class GameCharacterAttributesTest {

    @Test(expected = AssertionError.class)
    public void negativeMovementSpeedTest() throws Exception {
        CharacterAttributes c = new CharacterAttributes(10, 10, 10, 10);
        c.lowerMovementSpeed(2.5);
        assertEquals(-1.5, c.getMovementSpeed(), 0.001);
    }

    @Test(expected = AssertionError.class)
    public void exeedsMaxMovementSpeedTest() throws Exception {
        CharacterAttributes c = new CharacterAttributes(10, 10, 10, 10);
        c.increaseMovementSpeed(1.01);
        assertEquals(2.01, c.getMovementSpeed(), 0.001);
    }

    @Test
    public void testMovementSpeedWhenOverburdend() throws Exception {
        GameCharacter g = new GameCharacter("Kalle");
        EquipmentAttributes e = new EquipmentAttributes(10, 5, 10, 10, 10);
        Equipment helmet = new Equipment(Equipment.Type.helmet, "helmet", 10, 10, 151, e);
        g.pickUp(helmet);

        assertEquals(0.0, g.getCharAttributes().getMovementSpeed(), 0.1);
    }

    @Test
    public void testMovementSpeedAfterOverburdend() throws Exception {
        GameCharacter g = new GameCharacter("Kalle");
        EquipmentAttributes e = new EquipmentAttributes(10, 5, 10, 10, 10);
        Equipment helmet = new Equipment(Equipment.Type.helmet, "helmet", 10, 10, 151, e);
        g.pickUp(helmet);
        g.dropItem(helmet);
        assertEquals(1.0, g.getCharAttributes().getMovementSpeed(), 0.1);
    }

    @Test
    public void testIncreasedCarryWeightByItem(){
        GameCharacter g = new GameCharacter("Kalle");
        EquipmentAttributes e = new EquipmentAttributes(10, 5, 10, 10, 10);
        Equipment helmet = new Equipment(Equipment.Type.helmet, "helmet", 10, 10, 151, e);
        Equipment helmetTwo = new Equipment(Equipment.Type.helmet, "helmet", 10, 10, 151, e);
        g.pickUp(helmet);
        g.equipEquipment(helmet);
        g.pickUp(helmetTwo);
        assertEquals(175, g.getCharAttributes().getMaxCarryWeight());
    }

    @Test
    public void testIncreasedMaxHpByItem(){
        GameCharacter g = new GameCharacter("Kalle");
        EquipmentAttributes e = new EquipmentAttributes(10, 5, 10, 10, 10);
        Equipment helmet = new Equipment(Equipment.Type.helmet, "helmet", 10, 10, 151, e);
        g.pickUp(helmet);
        g.equipEquipment(helmet);
        assertEquals(200, g.getMaxHp());

    }

    @Test
    public void testDecreasedMaxHpByItem(){
        GameCharacter g = new GameCharacter("Kalle");
        EquipmentAttributes e = new EquipmentAttributes(10, 5, 10, 10, 10);
        Equipment helmet = new Equipment(Equipment.Type.helmet, "helmet", 10, 10, 151, e);
        g.pickUp(helmet);
        g.equipEquipment(helmet);
        g.unEquip(helmet);
        assertEquals(100, g.getMaxHp());
    }


    @Test(expected = AssertionError.class)
    public void ExeedsMaxCarryWeight() throws Exception {
        CharacterAttributes c = new CharacterAttributes(40, 10, 10, 10);
        assertEquals(301, c.getMaxCarryWeight());
    }

}


