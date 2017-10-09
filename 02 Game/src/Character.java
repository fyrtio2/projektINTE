public class Character {

    private double speed;
    private int hp, maxHp;
    private String name;
    private Position position;

    public Character(int maxHp, int hp, double speed, String name) {
        this.hp = hp;
        this.speed = speed;
        this.name = name;
    }

    public int checkForNegativeHp(int health) {
        if (health < 0) {
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

}

