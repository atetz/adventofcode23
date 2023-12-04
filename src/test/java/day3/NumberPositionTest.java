package day3;

import org.junit.jupiter.api.Test;
import utils.InputReader;

import java.util.List;

import static day3.Day3.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class NumberPositionTest {
    @Test
    void validateCalcSumOfParts() {
        List<String> sampleOne = new InputReader("03_sample1.txt").getLines();

        String[][] puzzle2DArray = createTwoDimensionalArray(sampleOne);
        List<NumberPosition> unidentifiedParts = getUnidentifiedParts(puzzle2DArray);

        assertEquals(calcSumOfParts(unidentifiedParts, puzzle2DArray), 4361);
    }

    @Test
    void ValidateCalcSumOfGearRatios() {
        List<String> sampleOne = new InputReader("03_sample1.txt").getLines();
        String[][] puzzle2DArray = createTwoDimensionalArray(sampleOne);
        List<NumberPosition> unidentifiedParts = getUnidentifiedParts(puzzle2DArray);
        assertEquals(calcSumOfGearRatios(unidentifiedParts), 467835);
    }

    @Test
    void numberPositionAddsNumber() {
        NumberPosition np = new NumberPosition();
        np.addNumber(1, 0, "5");
        np.addNumber(2, 0, "8");
        np.addNumber(3, 0, "5");
        assertEquals(np.getNumber(), 585);
    }

}