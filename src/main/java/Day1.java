import helpers.InputReader;

import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

public class Day1 {
    public static String INPUT_FILE = "01.txt";

    public static List<String> getPuzzleInput() throws Exception {
        InputReader input = new InputReader(INPUT_FILE);
        return input.getLines();
    }

    public static String substituteWrittenNumbers(String line) {
        Map<String, String> substituteMap = Map.of("one", "one1one",
                "two", "two2two",
                "three", "three3three",
                "four", "four4four",
                "five", "five5five",
                "six", "six6six",
                "seven", "seven7seven",
                "eight", "eight8eight",
                "nine", "nine9nine"
        );

        for (Map.Entry<String, String> entry : substituteMap.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            line = line.replaceAll(Pattern.quote(key), value);
        }
        return line;
    }

    public static Integer puzzleOne(List<String> calibrationValues) throws Exception {

        return calibrationValues.stream()
                .map(s -> s.replaceAll("\\D", ""))
                .map(s -> String.valueOf(s.charAt(0)) + String.valueOf(s.charAt(s.length() - 1)))
                .map(Integer::parseInt)
                .reduce(0, Integer::sum);
    }

    public static Integer puzzleTwo(List<String> calibrationValues) throws Exception {

        return calibrationValues.stream()
                .map(Day1::substituteWrittenNumbers)
                .map(s -> s.replaceAll("\\D", ""))
                .map(s -> String.valueOf(s.charAt(0)) + String.valueOf(s.charAt(s.length() - 1)))
                .map(Integer::parseInt)
                .reduce(0, Integer::sum);
    }

    public static void main(String[] args) throws Exception {

        List<String> calibrationValues = getPuzzleInput();

        System.out.println("Part one: " + puzzleOne(calibrationValues));
        System.out.println("Part two: " + puzzleTwo(calibrationValues));

    }
}
