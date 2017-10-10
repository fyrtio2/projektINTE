public class Map {

    private String locationName;
    private int mapHeight, mapWidth;
    private int mapMaxHeight = 1000;
    private int mapMaxWidth = 1000;

    public Map(String locationName, int mapHeight, int mapWidth) {
        this.locationName = locationName;
        if (mapHeight < 0 || mapWidth < 0 ){
            throw new IllegalArgumentException("Something went wrong");
        }
        if (mapHeight > mapMaxHeight && mapWidth > mapMaxWidth) {
            this.mapHeight = mapMaxHeight;
            this.mapWidth = mapMaxWidth;
        } else if (mapHeight > mapMaxHeight && mapWidth < mapMaxWidth) {
            this.mapHeight = mapMaxHeight;
            this.mapMaxWidth = mapWidth;
        } else if (mapWidth > mapMaxWidth && mapHeight < mapMaxHeight) {
            this.mapWidth = mapMaxWidth;
            this.mapHeight = mapHeight;
        } else {
            this.mapWidth = mapWidth;
            this.mapHeight = mapHeight;
        }
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

}
