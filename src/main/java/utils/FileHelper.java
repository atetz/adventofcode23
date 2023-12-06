package utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileHelper {

    private static final String INPUT_PATH = "src/main/resources/input/";

    public static List<String> readLines(String fileName) {
        try {
            String filePath = String.format("%s%s", INPUT_PATH, fileName);
            return Files.readAllLines(Path.of(filePath));
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return List.of();
        }
    }
}
