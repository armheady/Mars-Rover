package org.northcoders;


import org.northcoders.InputParser.InputParser;
import org.northcoders.Logic.Rover;

public class Main {
    public static void main(String[] args) {


      InputParser parser = new InputParser();
        parser.run();

      Rover marsRover = new Rover(parser.getPosition(), parser.getInstructions());
        marsRover.run();



    }
}