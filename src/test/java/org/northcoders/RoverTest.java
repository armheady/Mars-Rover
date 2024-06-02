package org.northcoders;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class RoverTest {
@Test
public void testRoverPosition() {
    // Create a mock InputParser
    InputParser mockParser = Mockito.mock(InputParser.class);

    // Define the behavior of the mock
    PlateauSize plateauSize = new PlateauSize(5, 5);
    Position mockPosition = new Position(1, 2, CompassDirection.N, plateauSize);
    Instruction[] mockInstructions = {Instruction.M, Instruction.R, Instruction.R,};

    when(mockParser.getPosition()).thenReturn(mockPosition);
    when(mockParser.getInstructions()).thenReturn(mockInstructions);

    Rover marsRover = new Rover(mockParser.getPosition(), mockParser.getInstructions());
    marsRover.run();

    assertEquals("1 3 S", marsRover.position.toString());
}

}