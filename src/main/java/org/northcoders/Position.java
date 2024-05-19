package org.northcoders;

public class Position {
    public int x;
    public int y;

    public Position(int x, int y, CompassDirection facing) {
        this.x = x;
        this.y = y;
        this.facing = facing;
    }

    public CompassDirection facing;



}
