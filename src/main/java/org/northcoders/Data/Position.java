package org.northcoders.Data;

public class Position {
    public int x;
    public int y;
    public int maxY;
    public int maxX;
    public CompassDirection facing;


    public Position(int x, int y, CompassDirection facing, PlateauSize plateauSize) {
        this.x = x;
        this.y = y;
        this.facing = facing;
        this.maxX = plateauSize.width;
        this.maxY = plateauSize.height;
    }

    public boolean checkInboundX(int newX) {
        return newX <= this.maxX && newX >= 0;
    }

    public boolean checkInboundY(int newY) {
        return newY <= this.maxY && newY >= 0;
    }

    @Override
    public String toString() {
        return String.format("%d %d %s", x ,y,facing);
    }
}
