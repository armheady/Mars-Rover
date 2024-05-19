package org.northcoders;

public class Rover {
    //position
    int x;
    int y;
    String face;
    String plateau;
    String instructions;
    String position;
    int maxY;
    int maxX;

    public Rover() {
    }

    public Rover(String plateau, String position, String instructions) {
        this.plateau = plateau;
        this.instructions = instructions;
        this.x = Integer.parseInt(position.substring(0,1));
        this.y = Integer.parseInt(position.substring(2,3));
        this.face = position.substring(4,5);
        this.maxX = Integer.parseInt(plateau.substring(0,1));
        this.maxY = Integer.parseInt(plateau.substring(2,3));
    }

    public void move(){
        for (int i = 0; i < this.instructions.length(); i++) {
            String letter = this.instructions.substring(i,i+1);
            if(letter.equalsIgnoreCase("L")) {
                switch (this.face) {
                    case "N":
                        this.face = "W";
                        break;
                    case "W":
                        this.face = "S";
                        break;
                    case "S":
                        this.face = "E";
                        break;
                    case "E":
                        this.face = "N";
                        break;
                }
            }else if(letter.equalsIgnoreCase("R")) {
                switch (this.face) {
                    case "N":
                        this.face = "E";
                        break;
                    case "W":
                        this.face = "N";
                        break;
                    case "S":
                        this.face = "W";
                        break;
                    case "E":
                        this.face = "S";
                        break;
                }
            }else if(letter.equalsIgnoreCase("M")){
                switch (this.face) {

                    case "N":
                        if (checkInboundY(this.y+1)){
                            this.y += 1;
                        }
                        break;
                    case "W":
                        if (checkInboundX(this.x-1)) {
                            this.x -= 1;
                        }
                        break;
                    case "S":
                        if (checkInboundY(this.y-1)){
                            this.y -= 1;
                        }
                        break;
                    case "E":
                        if (checkInbound(this.x+1)) {
                            this.x += 1;
                        }
                        break;
                }
            }
        }
        this.position = this.x + " " + this.y + " " + this.face;

    }

    public boolean checkInbound(int newPosition){
        boolean check = false;
        switch (this.face) {
            case "N", "S":
                if (newPosition <= maxY && newPosition >= 0) {
                    check = true;
                }
                break;
            case "W", "E":
                if (newPosition <= maxX && newPosition >= 0) {
                    check = true;
                }
                break;
        }
        return check;
    }

    public boolean checkInboundX(int newX){
        return newX <= this.maxX && newX >= 0;
    }

    public boolean checkInboundY(int newY){
        return newY <= this.maxY && newY >= 0;
    }


}
