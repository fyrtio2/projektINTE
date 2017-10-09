public class Position {

    private int x, y;

    public Position(int x, int y){
        this.x = x;
        this.y = y;

    }

    public boolean isWithinMap(Map map) {
        if (x == null || y == null ) {

        }
        return (x >= 0 && y >= 0 && (x <= map.getMapWidth() && y <= map.getMapHeight()));

    }
}
