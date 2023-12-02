package helpers;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class InputReader {
    public static String INPUT_PATH = "src/main/java/input/";
    public String filePath;
    public List<String> fileLines;

    public InputReader(String fileName) throws Exception {
        this.filePath = String.format("%s%s", INPUT_PATH, fileName);
        this.fileLines = Files.readAllLines(Path.of(filePath));
    }

    public List<String> getLines() {
        return fileLines;
    }
}
