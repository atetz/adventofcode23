package day7;

import utils.FileHelper;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Day7 {

    public static String SAMPLE_FILE = "07_sample.txt";
    public static String INPUT_FILE = "07.txt";

    public static void partOne(String[][] hands) {

        List<Hand> allHands = new ArrayList<>();

        for (String[] hand : hands) {
            String cards = hand[0];
            int bid = Integer.parseInt(hand[1]);

            allHands.add(new Hand(cards, bid));

        }

        allHands.sort(Comparator
                .comparingInt(Hand::getStrength).thenComparing(Hand::compareTo));

        int totalWinnings = 0;
        for (int i = 0; i < allHands.size(); i++) {
            int bid = allHands.get(i).getBid();
            totalWinnings += bid * (i + 1);
        }
        System.out.println("Part one: " + totalWinnings);

    }

    public static void partTwo(String[][] hands) {

        List<JokerHand> allHands = new ArrayList<>();

        for (String[] hand : hands) {
            String cards = hand[0];
            int bid = Integer.parseInt(hand[1]);

            allHands.add(new JokerHand(cards, bid));

        }

        allHands.sort(Comparator
                .comparingInt(JokerHand::getStrength).thenComparing(JokerHand::compareTo));

        int totalWinnings = 0;
        for (int i = 0; i < allHands.size(); i++) {
            int bid = allHands.get(i).getBid();
            totalWinnings += bid * (i + 1);
        }
        System.out.println("Part two: " + totalWinnings);

    }

    public static void main(String[] args) {

        List<String> puzzleInput = FileHelper.readLines(INPUT_FILE);

        String[][] hands = puzzleInput.stream()
                .map(line -> line.split("\\s+"))
                .toArray(String[][]::new);

        partOne(hands);
        partTwo(hands);

        //253053751 too low
        //253453932 too high
        //253527546 too high
        
    }
}
