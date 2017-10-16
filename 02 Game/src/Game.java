import javax.swing.*;

public class Game extends JFrame {

    public Game() {
        /*JFrame map = new JFrame();

        setSize(500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);*/
    }

    public static void main(String[] args) {
        new Game();

        GameCharacter mainGameCharacter = new GameCharacter("DragonSlayer");
        GameCharacter dragon = new GameCharacter("Dragon");

        Map world = new Map("Emils world", 3, 4);

        System.out.println(mainGameCharacter.getName());
        System.out.println(world.getMapName());
        System.out.println("Current hp: " + mainGameCharacter.getCurrentHp() + " Max hp: " + mainGameCharacter.getMaxHp());
        int damage = mainGameCharacter.meleeAttack();
        System.out.println(mainGameCharacter.getName() + " does " + damage + " Damage");
        dragon.takeDamage(damage);
        System.out.println(dragon.getName() + " takes: " + damage + " Damage, dragon has " + dragon.takeDamage(mainGameCharacter.meleeAttack()) + " hp left");
    }
}
