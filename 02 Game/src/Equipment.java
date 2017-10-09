public class Equipment {

    private String type;
    private int stats;
    private boolean enchanted;



    public Equipment(String type,int stat, boolean enchanted){
        this.type = type;
        this.stats = stats;
        this.enchanted = enchanted;

    }

    public String getType(){
     return type;
    }

    public int getStats(){
        return stats;
    }

    public boolean isEnchanted(){
        return enchanted;
    }
}
