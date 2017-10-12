import javax.swing.*;

public class Game extends JFrame {

    public Game(){
        JFrame map = new JFrame();


        setSize(500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Game();

        GameCharacter mainGameCharacter = new GameCharacter("DragonSlayer");

        Map world = new Map("Emils world", 3, 4);

        System.out.println(mainGameCharacter.getName());
        System.out.println(world.getMapName());
        System.out.println("Current hp: " + mainGameCharacter.getCurrentHp() + " Max hp: " + mainGameCharacter.getMaxHp());
    }
}
