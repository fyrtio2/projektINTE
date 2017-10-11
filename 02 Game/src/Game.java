import javax.swing.*;

public class Game extends JFrame {

    public static void main(String[] args) {
        new Game();

        Character mainCharacter = new Character("DragonSlayer");

        Map world = new Map("Emils world", 3, 4);

        System.out.println(mainCharacter.getName());
        System.out.println(world.getLocationName());
        System.out.println("Current hp: " + mainCharacter.getHp() + " Max hp: " + mainCharacter.getMaxHp());
    }
}
