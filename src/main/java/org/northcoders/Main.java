package org.northcoders;

import org.w3c.dom.ls.LSOutput;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");


        Scanner scanner = new Scanner(System.in);
        boolean isValid = false;
        String plateau = "";
        String position = "";
        String instructions = "";

        while (!isValid){
            try {
                System.out.println("Please enter plateau size");
                plateau = scanner.nextLine();
                if(
                    !Character.isDigit(plateau.toCharArray()[0]) &&
                    !Character.isDigit(plateau.toCharArray()[2])) {
                    throw new IllegalArgumentException();
                } else if (plateau.length() != 3) {
                    throw new InputMismatchException();
                }
                System.out.println("Please enter rover starting position");
                position = scanner.nextLine();

                System.out.println("Please enter instructions");
                instructions = scanner.nextLine();
                isValid = true;
            }
            catch (InputMismatchException e) {
                System.out.println("Invalid Input");
            }
            catch (IllegalArgumentException e ){
                System.out.print("Bad");
            }
        }

        Rover marsRover = new Rover(plateau, position, instructions);
        marsRover.move();
        System.out.println("Mars Rover Position:" + marsRover.position);




    }
}