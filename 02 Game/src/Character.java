public class Character {

    private int speed;
    private double hp;
    private String name;


    public Character(double hp, int speed){
        this.hp = hp;
        this.speed = speed;
    }

    public double getHp() {
        return hp;
    }

    public int getSpeed() {
        return speed;
    }


}
