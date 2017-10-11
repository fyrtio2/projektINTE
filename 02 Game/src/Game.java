import javax.swing.*;

public class Game extends JFrame {

    public Game() {
        JFrame map = new JFrame();


        setSize(500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Game();

        Character mainCharacter = new Character("DragonSlayer");

        Map world = new Map("Emils world", 3, 4);

        System.out.println(mainCharacter.getName());
        System.out.println(world.getLocationName());
        System.out.println("Current hp: " + mainCharacter.getCurrentHp() + " Max hp: " + mainCharacter.getMaxHp());
    }
}
