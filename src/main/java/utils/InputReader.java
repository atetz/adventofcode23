package utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class InputReader {
    public static String INPUT_PATH = "src/main/resources/input/";
    public String filePath;
    public List<String> fileLines;

    public InputReader(String fileName) {
        try {
            this.filePath = String.format("%s%s", INPUT_PATH, fileName);
            this.fileLines = Files.readAllLines(Path.of(filePath));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public List<String> getLines() {
        return fileLines;
    }
}
