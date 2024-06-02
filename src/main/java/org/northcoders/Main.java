package org.northcoders;


import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


      InputParser parser = new InputParser();
        parser.run();

      Rover marsRover = new Rover(parser.position, parser.instructions);
        marsRover.run();



    }
}