package org.northcoders.InputParser;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.northcoders.Data.CompassDirection;
import org.northcoders.Data.PlateauSize;
import org.northcoders.Data.Position;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

class InputParserTest {
    private InputParser parser;
    @BeforeEach
    public void setUp(){
        parser = new InputParser();
    }

    @Test
    void testPlateauSizeParser() {
        String input = "5 5\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        //update value of plateauSize;
        parser.plateauSizeParser();
        PlateauSize plateauSize = parser.getPlateauSize();
        assertEquals(5, plateauSize.height);
        assertEquals(5, plateauSize.width);
    }

    @Test
    void testPositionParser() {
        String input = "5 5\n1 2 N\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        parser.plateauSizeParser();;

        parser.positionParser();
        Position position = parser.getPosition();
        assertEquals(1, position.x);
        assertEquals(2, position.y);
        assertEquals(CompassDirection.N, position.facing);
    }

    @Test
    void testInstructionParser() {
    }
}