package org.northcoders;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoverTest {
@Test
    public void mainTest(){
        Rover rover =  new Rover("5 5", "1 2 N","LMLMLMLMMLMM");
        rover.move();
        assertEquals("0 3 W", rover.position);
//        assertEquals("1 3 N", rover.position);
    }

}