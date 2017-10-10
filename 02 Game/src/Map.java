public class Map {

    private String locationName;
    private int mapHeight, mapWidth;

    public Map(String locationName, int mapHeight, int mapWidth) {
        this.locationName = locationName;
        this.mapHeight = mapHeight;
        this.mapWidth = mapWidth;
    }

    public String getLocationName() {
        return locationName;
    }

    public int getMapHeight() {
        return mapHeight;
    }

    public int getMapWidth() {
        return mapWidth;
    }

    public boolean isWithinMap(Character character) {
        Position p = character.getPosition();
        return !(p.getPosX() > mapWidth || p.getPosY() > mapHeight);
    }

    public void testBranch() {

    }
}
