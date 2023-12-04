package day3;

import utils.InputReader;

import java.util.ArrayList;
import java.util.List;

public class Day3 {

    public static String INPUT_FILE = "03.txt";

    public static List<String> getPuzzleInput() {
        InputReader input = new InputReader(INPUT_FILE);
        return input.getLines();
    }

    public static String[][] createTwoDimensionalArray(List<String> puzzleInput) {
        int numRows = puzzleInput.size();
        int numCols = puzzleInput.get(0).length();

        String[][] twoDimensionalArray = new String[numRows][numCols];

        for (int i = 0; i < numRows; i++) {
            twoDimensionalArray[i] = puzzleInput.get(i).split("");
        }
        return twoDimensionalArray;

    }

    public static List<NumberPosition> getUnidentifiedParts(String[][] puzzle2DArray) {

        int numRows = puzzle2DArray.length;
        int numCols = puzzle2DArray[0].length;

        List<NumberPosition> numbersList = new ArrayList<>();
        NumberPosition np = null;

        for (int y = 0; y < numRows; y++) {
            for (int x = 0; x < numCols; x++) {
                String value = puzzle2DArray[y][x];
                if (Character.isDigit(value.charAt(0))) {
                    if (np == null) {
                        np = new NumberPosition();
                    }
                    np.addNumber(x, y, value);
                    np.findGears(puzzle2DArray);

                } else if (np != null) {
                    numbersList.add(np);
                    np = null;
                }
            }
        }
        return numbersList;
    }

    public static int calcSumOfParts(List<NumberPosition> unidentifiedParts, String[][] puzzle2DArray) {
        return unidentifiedParts.stream()
                .filter(part -> part.isValidPartNumber(puzzle2DArray))
                .mapToInt(NumberPosition::getNumber).sum();
    }

    public static int calcSumOfGearRatios(List<NumberPosition> unidentifiedParts) {
        int sumOfGearRatios = 0;
        for (int i = 0; i < unidentifiedParts.size(); i++) {
            for (int j = i + 1; j < unidentifiedParts.size(); j++) {
                if (unidentifiedParts.get(i).getGears().equals(unidentifiedParts.get(j).getGears()) && !unidentifiedParts.get(i).getGears().isEmpty()) {
                    int gearRatio = unidentifiedParts.get(i).getNumber() * unidentifiedParts.get(j).getNumber();
                    sumOfGearRatios += gearRatio;
                }
            }
        }
        return sumOfGearRatios;
    }

    public static void main(String[] args) {

        List<String> puzzleInput = getPuzzleInput();
        String[][] puzzle2DArray = createTwoDimensionalArray(puzzleInput);

        List<NumberPosition> unidentifiedParts = getUnidentifiedParts(puzzle2DArray);

        System.out.println("Part one: " + calcSumOfParts(unidentifiedParts, puzzle2DArray));
        System.out.println("Part two: " + calcSumOfGearRatios(unidentifiedParts));
    }
}
