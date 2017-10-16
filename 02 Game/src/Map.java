public class Map {

    private String mapName;
    private int mapHeight, mapWidth;
    private int mapMaxHeight = 1000;
    private int mapMaxWidth = 1000;

    public Map(String mapName, int mapHeight, int mapWidth) {
        this.mapName = mapName;
        if (mapName == null || mapHeight < 0 || mapWidth < 0 ||  mapName.isEmpty()) {
            throw new IllegalArgumentException("Something went wrong");
        } else if (mapWidth > mapMaxWidth || mapHeight > mapMaxHeight ) {
            throw new IllegalArgumentException("Something went wrong");
        } else {
            this.mapWidth = mapWidth;
            this.mapHeight = mapHeight;
        }

    }

    public String getMapName() {
        return mapName;
    }

    public int getMapHeight() {
        return mapHeight;
    }

    public int getMapWidth() {
        return mapWidth;
    }

    public boolean isWithinMap(GameCharacter character) {
        double xPos = character.getXPos();
        double yPos = character.getYPos();
        if (xPos < 0 || yPos < 0) {
            return false;
        } else if (xPos > mapWidth || yPos > mapHeight) {
            return false;
        }
        return true;

    }

}
