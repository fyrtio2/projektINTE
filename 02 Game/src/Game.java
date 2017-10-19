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

        GameCharacter dragonSlayer = new GameCharacter("DragonSlayer");
        GameCharacter dragon = new GameCharacter("Dragon");

        Map world = new Map("Emils world", 3, 4);

        System.out.println(dragonSlayer.getName());
        System.out.println(world.getMapName());

        System.out.println("\n******************************Attack Test******************************");
        System.out.println("Dragons current hp: " + dragon.getCurrentHp() + " Max hp: " + dragon.getMaxHp());
        int damage = dragonSlayer.meleeAttack();
        System.out.println(dragonSlayer.getName() + " does " + damage + " Damage");
        dragon.takeDamage(damage);
        System.out.println(dragon.getName() + " takes: " + damage + " Damage, dragon has " + dragon.takeDamage(dragonSlayer.meleeAttack()) + " hp left");

        System.out.println("\n******************************Overburdened Test******************************");
        System.out.println("Movement Speed: " + dragon.getCharAttributes().getMovementSpeed());
        System.out.println("Max Carry Weight: " + dragon.getCharAttributes().getMaxCarryWeight());
        System.out.println("Current Carry Weight: " + dragon.getBag().getWeight());
        EquipmentAttributes attributes = new EquipmentAttributes(5, 5, 5, 5, 5);
        Equipment helm = new Equipment(Equipment.Type.helmet, "Helm of Domination", 1, 100, 151, attributes);
        dragon.pickUp(helm);
        System.out.println("You have picked up: " + helm.getName());
        System.out.println("Your Current Carry Weight is: " + dragon.getBag().getWeight());
        System.out.println("You have been Overburdened!");
        System.out.println("Movement Speed: " + dragon.getCharAttributes().getMovementSpeed());

        System.out.println("\n******************************Equipment affecting Stats******************************");
        dragon.unEquip(helm);
        System.out.println("Dragon Strength: " + dragon.getCharAttributes().getStrenght());
        System.out.println("Max Carry Weight: " + dragon.getCharAttributes().getMaxCarryWeight());
        dragon.equipEquipment(helm);
        System.out.println("Dragon Strength: " + dragon.getCharAttributes().getStrenght());
        System.out.println("Max Carry Weight: " + dragon.getCharAttributes().getMaxCarryWeight());
        EquipmentAttributes attributes2 = new EquipmentAttributes(5, 10, 5, 5, 5);
        Equipment helm2 = new Equipment(Equipment.Type.helmet, "Helm of Domination2", 1, 100, 151, attributes2);
        dragon.unEquip(helm2);
        System.out.println("Dragon Strength: " + dragon.getCharAttributes().getStrenght());
    }
}
