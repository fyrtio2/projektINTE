

public class Character {

    private float speed;
    private int hp;
    private String name;
    private Position position;

    public Character(int hp, float speed, String name) {
        this.hp = hp;
        this.speed = speed;
        this.name = name;
    }

    public int getHp() {
        if (hp < 0) {
            return 0;
        }
        return hp;
    }

    public float getSpeed() {
        return speed;
    }

    public String getName() {
        return name;
    }
}
