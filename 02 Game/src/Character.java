public class Character {

    private int hp, maxHp;
    private String name;
    private Position position;
    private int level;

    private int experience;
    private boolean isInCombat;


    public Character(int maxHp, int hp, String name) {
        level = 0;
        this.hp = hp;
        this.name = name;
    }



    public int checkForNegativeHp(int health) {
        if (health <= 0) {
            return 0;
        }
        return health;
    }

    public int checkIfHpExceedsMaxHp() {
        if (hp > maxHp) {
            return hp = maxHp;
        }
        return hp;
    }

    public int getHp() {
        checkForNegativeHp(hp);
        return hp;
    }

    public int getMaxHp() {
        checkForNegativeHp(maxHp);
        checkIfHpExceedsMaxHp();
        return maxHp;
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public void newPosition(int x, int y) {
        Position p = new Position(x, y);

    }

    public Position getPosition() {
        return position;
    }

    public void levelUp() {
        level++;
        hp += 50;
    }

    public void resetLevel() {
        level = 0;
    }


    public void fight(boolean isInCombat){
        experience += 10;
        if (experience>30){
            levelUp();
        }
        isInCombat = false;

    }


    /**Character Combat**/

    public boolean makeCharacterInCombat() {
        isInCombat = true;
        return isInCombat;
    }

}

