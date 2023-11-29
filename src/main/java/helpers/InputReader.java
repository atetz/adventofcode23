package helpers;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class InputReader {

    public static String INPUT_PATH = "src/main/java/input/";

    public static List<String> getLines(String fileName) throws Exception{
        String filePath = String.format("%s%s",INPUT_PATH,fileName);
        return Files.readAllLines(Path.of(filePath));
    }

    public static void main(String[] args) throws Exception {

    }
}
