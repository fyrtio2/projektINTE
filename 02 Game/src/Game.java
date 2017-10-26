import java.util.Random;
import java.util.UUID;
import java.util.HashMap;


public class Game {
    private GameCharacter dragonSlayer;
    public static void main(String[] args) {

        Game run = new Game();


        run.pickUpItemsPerformanceTest(1000000);


    }


    private void pickUpItemsPerformanceTest(int pickUpIterations){




        for(int i=0; i<pickUpIterations; i++){
            String uniqueID = UUID.randomUUID().toString();
            dragonSlayer = new GameCharacter("DragonSlayer");
            EquipmentAttributes equipmentAttributes = new EquipmentAttributes(10, 10, 10, 10, 10);
            Equipment equipment = new Equipment(Equipment.Type.shoes,uniqueID, 10, 10, 10,equipmentAttributes);




            dragonSlayer.pickUpItem(equipment);

        }

    }
}