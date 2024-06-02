package org.northcoders;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputParser {


    PlateauSize plateauSize;
    Position position;
    Instruction[] instructions;
    public InputParser() {

    }
    public void parsePlateauSize(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter plateau size:");
        String plateau = scanner.nextLine();
        try {
            if(
                    !Character.isDigit(plateau.toCharArray()[0]) &&
                    !Character.isDigit(plateau.toCharArray()[2])
            ){
                        throw new InputMismatchException();
            }
        }catch (InputMismatchException e){
            System.out.println("Invalid Input");
        }
        this.plateauSize =  new PlateauSize(Integer.parseInt(plateau.substring(0,1)),
                                            Integer.parseInt(plateau.substring(2,3)));
    }

    public void positionParser(){
        System.out.println("Please enter rover starting position");
        Scanner scanner = new Scanner(System.in);
        String position = scanner.nextLine();
        int x = Integer.parseInt(position.substring(0,1));
        int y = Integer.parseInt(position.substring(2,3));
        CompassDirection facing = CompassDirection.valueOf(position.substring(4,5));
        this.position = new Position(x, y, facing, this.plateauSize);
    }

    public void instructionParser(){
        System.out.println("Please enter instructions");
        Scanner scanner = new Scanner(System.in);
        String instructions = scanner.nextLine();
        this.instructions = new Instruction[instructions.length()];

        for (int i = 0; i < instructions.length(); i++) {
            this.instructions[i] = Instruction.valueOf(instructions.substring(i,i+1));
        }
    }
    public Position getPosition() {
        return position;
    }

    public Instruction[] getInstructions() {
        return instructions;
    }

    public void run(){

        this.parsePlateauSize();
        this.positionParser();
        this.instructionParser();
    }

}
