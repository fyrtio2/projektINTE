public class Map {

    private String locationName;
    private int mapHeight, mapWidth;
    private int mapMaxHeight = 1000;
    private int mapMaxWidth = 1000;

    public Map(String locationName, int mapHeight, int mapWidth) {
        this.locationName = locationName;
        if (mapHeight < 0 || mapWidth < 0 || locationName == null || locationName.isEmpty()) {
            throw new IllegalArgumentException("Something went wrong");
        }
        this.mapHeight = mapHeight > mapMaxHeight ? this.mapHeight = mapMaxHeight : mapHeight;
        this.mapWidth = mapWidth > mapMaxWidth ? this.mapWidth = mapMaxWidth : mapWidth;
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

   /* public boolean isWithinMap(GameCharacter character) {
        Position p = character.getPosition();
        return !(p.getPosX() > mapWidth || p.getPosY() > mapHeight);
    }*/

}
