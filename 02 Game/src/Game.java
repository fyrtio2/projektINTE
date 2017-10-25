import java.util.Random;

public class Game {
    public static void main(String[] args) {
        GameCharacter dragonSlayer = new GameCharacter("DragonSlayer");

        char[] chars = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        StringBuilder sb = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < 2000; i++) {
            char c = chars[random.nextInt(chars.length)];
            sb.append(c);
        }
        String output = sb.toString();

        for(int i=0; i<10000000; i++){
            EquipmentAttributes equipmentAttributes = new EquipmentAttributes(10, 10, 10, 10, 10);
            Equipment equipment = new Equipment(Equipment.Type.shoes,output, 10, 10, 10,equipmentAttributes);
            dragonSlayer.pickUpItem(equipment);

        }

    }
}