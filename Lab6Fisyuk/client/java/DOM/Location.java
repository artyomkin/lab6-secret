package DOM;

import utils.Logger;
/**
 * Location of the Address
 * @see Address
 * **/
public class Location {
    private int x;
    private float y;
    private Double z;

    public Location(int x, float y, Double z) {
        if (z == null){
            Logger.error("z is null in Location constructor");
        }
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public Double getZ() {
        return z;
    }

    public void setZ(Double z) {
        if (z == null){
            Logger.error("z is null in Location setter");
            System.exit(0);
        }
        this.z = z;
    }

    @Override
    public String toString() {
        return "Location{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                '}';
    }
}

