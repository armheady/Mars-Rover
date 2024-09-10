package org.northcoders.InputParser;

import org.northcoders.Data.CompassDirection;
import org.northcoders.Data.Instruction;
import org.northcoders.Data.PlateauSize;
import org.northcoders.Data.Position;
import java.util.InputMismatchException;
import java.util.Scanner;

public class InputParser {

    private PlateauSize plateauSize;
    private Position position;

    private Instruction[] instructions;

    public InputParser() {

    }
    public void plateauSizeParser(){
        Scanner scanner = new Scanner(System.in);
        boolean validInput = false;
        while(!validInput) {
            System.out.println("Please enter plateau size, height by width (e.g.,'5 5'):");
            String plateauInput = scanner.nextLine();
            try {
                if(
                        plateauInput.length() < 3                         ||
                        !Character.isDigit(plateauInput.toCharArray()[0]) ||
                        !Character.isDigit(plateauInput.toCharArray()[2])

                )
                {
                            throw new InputMismatchException("Invalid Input for plateau size.");
                }
                int maxY = Integer.parseInt(plateauInput.substring(2,3));
                int maxX = Integer.parseInt(plateauInput.substring(0,1));
                this.plateauSize =  new PlateauSize(maxY, maxX);
                validInput = true;
            }catch (InputMismatchException | NumberFormatException e){
                System.out.println("Error: " + e.getMessage());
                System.out.println("Please try again.");
            }
        }

    }

    public void positionParser(){
        Scanner scanner = new Scanner(System.in);
        boolean validInput = false;
        while(!validInput) {
            System.out.println("Please enter rover starting position (e.g.,'1 2 N'):");

            String positionInput = scanner.nextLine();
            try {
                if (positionInput.length() < 5 ||
                        !Character.isDigit(positionInput.charAt(0)) ||
                        !Character.isDigit(positionInput.charAt(2)) ||
                        !Character.isLetter(positionInput.charAt(4))
                ) {
                    throw new InputMismatchException("Invalid input format for rover starting position.");
                }


                int x = Integer.parseInt(positionInput.substring(0, 1));
                int y = Integer.parseInt(positionInput.substring(2, 3));
                CompassDirection facing = CompassDirection.valueOf(positionInput.substring(4, 5));
                this.position = new Position(x, y, facing, this.plateauSize);
                validInput = true;
            } catch (InputMismatchException | IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
                System.out.println("Please try again.");
            }
        }
    }

    public void instructionParser(){
        Scanner scanner = new Scanner(System.in);
        boolean validInput = false;
        while (!validInput) {
            System.out.println("Please enter instructions (e.g.,'LMMMRL'):");
            String instructionsInput = scanner.nextLine();
            try {
                this.instructions = new Instruction[instructionsInput.length()];
                for (int i = 0; i < instructionsInput.length(); i++) {
                    this.instructions[i] = Instruction.valueOf(instructionsInput.substring(i, i + 1));
                  validInput = true;
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid instruction for rover.");
                System.out.println("Please try again.");
            }
        }

    }


    public Position getPosition() {
        return position;
    }

    public Instruction[] getInstructions() {
        return instructions;
    }

    public PlateauSize getPlateauSize() {
        return plateauSize;
    }

    public void run(){

        this.plateauSizeParser();
        this.positionParser();
        this.instructionParser();
    }

}
