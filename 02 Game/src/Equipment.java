public class Equipment {

    private String type;
    private int stat;
    private boolean enchanted;



    public Equipment(String type,int stat, boolean enchanted){
        this.type = type;
        this.stat = stat;
        this.enchanted = enchanted;

    }

    public String getType(){
     return type;
    }

    public int getStat(){
        return stat;
    }

    public boolean isEnchanted(){
        return enchanted;
    }
}
