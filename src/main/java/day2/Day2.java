package day2;

import utils.InputReader;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import static java.lang.Integer.parseInt;

public class Day2 {
    public static String INPUT_FILE = "02.txt";

    public static List<String> getPuzzleInput() {
        InputReader input = new InputReader(INPUT_FILE);
        return input.getLines();
    }

    public static Map<String, Integer> BAG_CONTENTS_P1 = Map.of("red", 12,
            "green", 13,
            "blue", 14);

    public static boolean validateDraw(String draw) {
        int cubes = parseInt(draw.replaceAll("\\D", ""));
        String color = draw.replaceAll("\\d", "");
        return cubes <= BAG_CONTENTS_P1.get(color);
    }

    public static Integer puzzleOne(List<String> puzzleInput) {

        int sumOfGameIDs = 0;
        for (String gameLine : puzzleInput) {
            int gameID = parseInt(gameLine.replaceAll("(Game\\s|:.+$)", ""));
            gameLine = gameLine.replaceAll("(Game\\s\\d+:|\\s)", "");
            String[] allDraws = gameLine.split("[;,]");
            if (Arrays.stream(allDraws).allMatch(Day2::validateDraw)) {
                sumOfGameIDs = sumOfGameIDs + gameID;
            }
        }
        return sumOfGameIDs;
    }

    public static Integer calculateCubeSetPower(String cubeSet) {
        int maxRed = 0;
        int maxGreen = 0;
        int maxBlue = 0;

        String[] cubes = cubeSet.split(",\\s|;\\s");

        for (String cube : cubes) {
            String[] splitCube = cube.split("\\s");
            int power = parseInt(splitCube[0]);
            String color = splitCube[1];
            if (Objects.equals(color, "red") && power > maxRed) {
                maxRed = power;
            } else if (Objects.equals(color, "green") && power > maxGreen) {
                maxGreen = power;
            } else if (Objects.equals(color, "blue") && power > maxBlue) {
                maxBlue = power;
            }
        }

        return maxRed * maxGreen * maxBlue;
    }

    public static Integer puzzleTwo(List<String> puzzleInput) {

        int sumOfCubePowers = 0;

        for (String gameLine : puzzleInput) {
            String[] splitGameLine = gameLine.split(":\\s");
            String cubeSet = splitGameLine[1];
            sumOfCubePowers = sumOfCubePowers + calculateCubeSetPower(cubeSet);
        }
        return sumOfCubePowers;
    }

    public static void main(String[] args) {
        List<String> puzzleInput = getPuzzleInput();

        System.out.println("Part one: " + puzzleOne(puzzleInput));
        System.out.println("Part two: " + puzzleTwo(puzzleInput));

    }

}

