public class Character {

    private int hp = 1;
    private int maxHp;
    private String name;
    private int xPos = 20;
    private int yPos = 10;
    private int level;
    private Bag bag;
    private int experience;
    private boolean isInCombat;
    private boolean isAlive = true;


    public Character(int maxHp, int hp, String name) {
        bag = new Bag(10);
        level = 1;
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

    public int getExperience(){
        return experience;
    }

    public void levelUp() {
        level++;
        hp += 50;
    }

    public void resetLevel() {
        level = 1;
    }

    public void afterCombat(boolean isInCombat){
        if (isInCombat) {

            makeCharacterInPeacefulStance();
            experience += 10;
            if (experience > 30) {
                levelUp();
                resetExperience();
            }
        }else {
            return;
        }
    }

    public void resetExperience(){
        experience = 0;
    }


    //Character Combat

    public boolean makeCharacterInCombat() {
        isInCombat = true;
        return isInCombat;
    }

    public boolean makeCharacterInPeacefulStance(){
        isInCombat = false;
        return isInCombat;
    }

    public boolean getIsInCombat(){
        return isInCombat;
    }

    //Character Alive or Dead

    public void makeCharacterDead(int hp){
        if(isInCombat && hp == 0){
            isAlive = false;
            resetExperience();
            resetPosition();
        }
    }

    public boolean getIsAlive() {
        return isAlive;
    }


    //Character Position

    public int getXPos() {
        return xPos;
    }

    public int getYPos() {
        return yPos;
    }

    public void resetPosition(){
        if (!isAlive){
            xPos = 20;
            yPos = 10;
        }
    }

    public void pickUp(Item item){
        bag.addToBag(item);

    }

    public Bag getBag(){
        return bag;
    }



}

