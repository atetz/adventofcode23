package day2;

import org.junit.jupiter.api.Test;
import utils.InputReader;

import java.util.List;

import static day2.Day2.*;
import static org.junit.jupiter.api.Assertions.*;

class Day2Test {

    @Test
    void validateBlueDraws() {
        assertTrue(validateDraw("12blue"));
        assertFalse(validateDraw("15blue"));
        assertTrue(validateDraw("2blue"));
    }

    @Test
    void validatePuzzleOne() {
        List<String> sampleOne = new InputReader("02_sample1.txt").getLines();
        assertEquals(puzzleOne(sampleOne), 8);
    }

    @Test
    void validateCalculateCubeSetPower() {
        String cubeSet = "9 green, 3 blue; 12 green, 2 blue; 18 green, 1 blue; 14 green; 2 blue, 9 green, 2 red";
        assertEquals(calculateCubeSetPower(cubeSet), 108);
    }

    @Test
    void validatePuzzleTwo() {
        List<String> sampleOne = new InputReader("02_sample1.txt").getLines();
        assertEquals(puzzleTwo(sampleOne), 2286);
    }
}