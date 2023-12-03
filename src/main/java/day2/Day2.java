package day2;

import utils.InputReader;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

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

    public static Integer puzzleTwo(List<String> puzzleInput) {


        for (String gameLine : puzzleInput) {
            int gameID = parseInt(gameLine.replaceAll("(Game\\s|:.+$)", ""));
            gameLine = gameLine.replaceAll("(Game\\s\\d+:|\\s)", "");
            String[] allDraws = gameLine.split("[;,]");


            for (String allDraw : allDraws) {
                System.out.println(gameID + allDraw);

            }

        }
        return 1;
    }

    public static void main(String[] args) {
        List<String> puzzleInput = getPuzzleInput();


        System.out.println("Part one: " + puzzleOne(puzzleInput));
        System.out.println("Part two: " + puzzleTwo(puzzleInput));


    }


}

