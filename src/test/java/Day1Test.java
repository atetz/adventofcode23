import day1.Day1;
import org.junit.jupiter.api.Test;
import utils.InputReader;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day1Test {

    @Test
    void validateNumberSubstitution() {
        String writtenNumbers = "onetwothreeight";
        String expectedResult = "one1onetwo2twothree3threeight8eight";
        assertEquals(Day1.substituteWrittenNumbers(writtenNumbers), expectedResult);
    }

    @Test
    void validatePartOne() throws Exception {
        List<String> sampleOne = new InputReader("01_sample1.txt").getLines();
        assertEquals(Day1.puzzleOne(sampleOne), 142);
    }

    @Test
    void validatePartTwo() throws Exception {
        List<String> sampleOne = new InputReader("01_sample2.txt").getLines();
        assertEquals(Day1.puzzleTwo(sampleOne), 281);
    }
}