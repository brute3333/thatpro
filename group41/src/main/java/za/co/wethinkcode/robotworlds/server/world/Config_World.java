package za.co.wethinkcode.robotworlds.server.world;

public class Config_World {
    private int widthOfTheWorld;
    private int lengthOfTheWorld;
    private int visibility;


    public Config_World() {
        widthOfTheWorld = 200;
        lengthOfTheWorld = 400;
        visibility = 5;
    }

    public int getWidthOfTheWorld() {
        return widthOfTheWorld;
    }

    public int getLengthOfTheWorld() {
        return lengthOfTheWorld;
    }

    public int getVisibility() {
        return visibility;
    }

}
