import javax.swing.*;

public class Game extends JFrame{

    public Game(){

        JFrame frame = new JFrame();

        setSize(600, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

    }


    public static void main(String[] args) {
        new Game();

        Character mainCharacter = new Character(10, 5, 5,"DragonSlayer");
        Map world = new Map("Emils world", 3,4);

        System.out.println(mainCharacter.getName());
        System.out.println(world.getLocationName());



    }
}
