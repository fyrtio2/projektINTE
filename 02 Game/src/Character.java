public class Character {

    // This is a comment from peter yakob
    // Using Intellij Git plugin
    private int speed;
    private double hp;
    private String name;

    public Character(double hp, int speed, String name){
        this.hp = hp;
        this.speed = speed;
        this.name = name;
    }

    public double getHp() {
        return hp;
    }

    public int getSpeed() {
        return speed;
    }

    public String getName(){
        return name;
    }


}
