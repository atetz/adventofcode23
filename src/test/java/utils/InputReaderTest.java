package utils;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InputReaderTest {

    public static String INPUT_FILE = "testHelper.txt";

    public static List<String> getInput() throws Exception {
        InputReader input = new InputReader(INPUT_FILE);
        return input.getLines();
    }

    @Test
    void getLines_reads_all_lines() throws Exception {
        List<String> testFile = getInput();
        assertEquals(testFile.size(), 8);
    }
}