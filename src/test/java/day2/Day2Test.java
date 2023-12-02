package day2;

import helpers.InputReader;
import org.junit.jupiter.api.Test;

import java.util.List;

import static day2.Day2.puzzleOne;
import static day2.Day2.validateDraw;
import static org.junit.jupiter.api.Assertions.*;

class Day2Test {

    @Test
    void validateBlueDraws() {
        assertTrue(validateDraw("12blue"));
        assertFalse(validateDraw("14blue"));
        assertTrue(validateDraw("2blue"));
    }

    @Test
    void validatePartOne() {
        List<String> sampleOne = new InputReader("02_sample1.txt").getLines();
        assertEquals(puzzleOne(sampleOne), 8);
    }
}