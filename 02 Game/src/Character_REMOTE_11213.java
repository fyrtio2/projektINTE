public class Character {

    private double speed;
    private int hp, maxHp;
    private String name;
    private Position position;
    private int lvl;

    private int experience;
    private boolean isInCombat;


    public Character(int maxHp, int hp, String name) {
        lvl = 0;
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

    public double getSpeed() {
        return speed;
    }

    public String getName() {
        return name;
    }

    public int getLvl() {
        return lvl;
    }

    public void newPosition(int x, int y) {
        Position p = new Position(x, y);

    }

    public Position getPosition() {
        return position;
    }

    public void lvlUp() {
        lvl++;
        hp += 50;
    }

    public void resetLvl() {
        lvl = 0;
    }


    public void fight(boolean isInCombat){
        experience += 10;
        if (experience>30){
            lvlUp();
        }

    }


    /**Character Combat**/

    public boolean makeCharacterInCombat() {
        isInCombat = true;
        return isInCombat;
    }

}

