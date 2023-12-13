package day9;

import utils.FileHelper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day9 {

    public static String SAMPLE_FILE = "09_sample1.txt";
    public static String INPUT_FILE = "09.txt";

    private static int[] reverseArray(int[] array) {
        int length = array.length;
        int[] reversedArray = new int[length];

        for (int i = 0; i < length; i++) {
            reversedArray[i] = array[length - 1 - i];
        }

        return reversedArray;
    }

    public static long calcExtrapolatedSum(List<int[]> puzzleInput) {
        long extrapolatedSum = 0;
        for (int[] line : puzzleInput) {

            List<int[]> historySeq = new ArrayList<>();
            historySeq.add(line);

            int iterationLimit = line.length - 1;
            int zeroArrayCount = 0;
            while (iterationLimit > 0 || zeroArrayCount == 1) {
                int[] extrapolatedArray = new int[iterationLimit];

                for (int i = 0; i < iterationLimit; i++) {
                    extrapolatedArray[i] = historySeq.get(historySeq.size() - 1)[i + 1] - historySeq.get(historySeq.size() - 1)[i];
                }

                historySeq.add(extrapolatedArray);

                iterationLimit--;
                if (Arrays.stream(extrapolatedArray).allMatch((i) -> i == 0)) {
                    zeroArrayCount++;
                }
            }

            for (int[] history : historySeq) {
                extrapolatedSum += history[history.length - 1];
            }
        }
        return extrapolatedSum;
    }


    public static void main(String[] args) {
        List<int[]> puzzleInput = FileHelper.readLinesAsListOfIntArray(INPUT_FILE, "\\s");

        List<int[]> reversedPuzzleInput = puzzleInput.stream().map(Day9::reverseArray).toList();

        System.out.println("part one : " + calcExtrapolatedSum(puzzleInput));

        System.out.println("part two : " + calcExtrapolatedSum(reversedPuzzleInput));

    }
}
