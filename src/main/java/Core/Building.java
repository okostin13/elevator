package Core;

public class Building implements Drawable {
    private int floorCount;
    private int elevatorCount;
    private int shaftCount;
    private int width;
    private int height;

    public int getFloorCount() {
        return floorCount;
    }

    public void setFloorCount(int floorCount) {
        this.floorCount = floorCount;
    }

    public int getElevatorCount() {
        return elevatorCount;
    }

    public void setElevatorCount(int elevatorCount) {
        this.elevatorCount = elevatorCount;
    }

    public int getShaftCount() {
        return shaftCount;
    }

    public void setShaftCount(int shaftCount) {
        this.shaftCount = shaftCount;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }


}
