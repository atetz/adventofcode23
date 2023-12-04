package day4;

import utils.InputReader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Day4 {
    public static String INPUT_FILE = "04.txt";

    public static List<String> getPuzzleInput() {
        InputReader input = new InputReader(INPUT_FILE);
        return input.getLines();
    }

    public static List<Integer> extractWinningNumbers(String splitLine) {
        return Arrays.stream(splitLine
                        .replaceAll("Card\\s+\\d+:", "")
                        .trim()
                        .replaceAll("\\s+", " ")
                        .split("\\s"))
                .map(Integer::parseInt)
                .toList();
    }

    public static List<Integer> extractCardNumbers(String splitLine) {
        return Arrays.stream(splitLine
                        .trim()
                        .replaceAll("\\s\\s", " ")
                        .split("\\s"))
                .map(Integer::parseInt)
                .toList();
    }

    public static int puzzleOne(List<String> puzzleInput) {
        int sumOfScore = 0;
        for (String line : puzzleInput) {
            String[] splitLines = line.split("\\|");

            List<Integer> winningNumbers = extractWinningNumbers(splitLines[0]);
            List<Integer> cardNumbers = extractCardNumbers(splitLines[1]);

            long matchingNumbers = cardNumbers.stream()
                    .filter(winningNumbers::contains)
                    .count();

            int score = (int) Math.pow(2, matchingNumbers - 1);
            sumOfScore += score;
        }
        return sumOfScore;
    }


    public static Integer puzzleTwo(List<String> puzzleInput) {

        List<Integer> cardCount = new ArrayList<>();
        IntStream.range(0, puzzleInput.size()).forEach(i -> cardCount.add(1));

        for (int i = 0; i < puzzleInput.size(); i++) {
            //for every card
            String[] splitLines = puzzleInput.get(i).split("\\|");

            List<Integer> winningNumbers = extractWinningNumbers(splitLines[0]);
            List<Integer> cardNumbers = extractCardNumbers(splitLines[1]);

            long matchingNumbers = cardNumbers.stream()
                    .filter(winningNumbers::contains)
                    .count();

            for (int card = 0; card < cardCount.get(i); card++) {
                // for each copy of every card
                for (int j = 1; j < matchingNumbers + 1; j++) {
                    // for each matching number add  a new copy
                    Integer currentCardCount = cardCount.get(i + j);
                    cardCount.set(i + j, currentCardCount + 1);
                }
            }
        }
        return cardCount.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }

    public static void main(String[] args) {

        List<String> puzzleInput = getPuzzleInput();

        puzzleTwo(puzzleInput);

        System.out.println("Part one: " + puzzleOne(puzzleInput));
        System.out.println("Part two: " + puzzleTwo(puzzleInput));

    }
}