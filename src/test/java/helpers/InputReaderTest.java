package helpers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InputReaderTest {
    @Test
    void getLines_reads_all_lines() throws Exception{
        List<String> testFile = InputReader.getLines("testHelper.txt");
        assertEquals(testFile.size(),8);
    }
}