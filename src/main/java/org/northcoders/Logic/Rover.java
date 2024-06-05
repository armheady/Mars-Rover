package org.northcoders.Logic;

import org.northcoders.Data.CompassDirection;
import org.northcoders.Data.Instruction;
import org.northcoders.Data.Position;

public class Rover {

    Instruction[] instructions;
    Position position;


    public Rover(Position position, Instruction[] instructions) {
        this.position = position;
        this.instructions = instructions;
    }


    public void rotate(Instruction instruction) {
        if (instruction.equals(Instruction.L)) {
            switch (this.position.facing) {
                case CompassDirection.N:
                    this.position.facing = CompassDirection.W;
                    break;
                case CompassDirection.W:
                    this.position.facing = CompassDirection.S;
                    break;
                case CompassDirection.S:
                    this.position.facing = CompassDirection.E;
                    break;
                case CompassDirection.E:
                    this.position.facing = CompassDirection.N;
                    break;
            }
        }
        if (instruction.equals(Instruction.R)) {
            switch (this.position.facing) {
                case CompassDirection.N -> this.position.facing = CompassDirection.E;
                case CompassDirection.W -> this.position.facing = CompassDirection.N;
                case CompassDirection.S -> this.position.facing = CompassDirection.W;
                case CompassDirection.E -> this.position.facing = CompassDirection.S;
            }
        }

    }

    public void move() {
        switch (this.position.facing) {
            case CompassDirection.N -> {
                if (this.position.checkInboundY(position.y + 1)) {
                    position.y += 1;
                } else {
                    System.out.println("This is off the edge of the plateau");
                }
            }
            case CompassDirection.W -> {
                if (position.checkInboundX(position.x - 1)) {
                    position.x -= 1;
                } else {
                    System.out.println("This is off the edge of the plateau");
                }
            }
            case CompassDirection.S -> {
                if (position.checkInboundY(position.y - 1)) {
                    position.y -= 1;
                } else {
                    System.out.println("This is off the edge of the plateau");
                }
            }
            case CompassDirection.E -> {
                if (position.checkInboundY(position.x + 1)) {
                    position.x += 1;
                } else {
                    System.out.println("This is off the edge of the plateau");
                }
            }
        }
    }

    public void run() {
        if (instructions != null) {
            for (Instruction instruction : this.instructions) {
                if (instruction.equals(Instruction.M)) {
                    this.move();
                } else if (instruction.equals(Instruction.L) || instruction.equals(Instruction.R)) {
                    this.rotate(instruction);
                }
            }
        }



    }
}
