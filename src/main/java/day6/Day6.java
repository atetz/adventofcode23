package day6;

import utils.FileHelper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day6 {

    public static String SAMPLE_FILE = "06_sample1.txt";
    public static String INPUT_FILE = "06.txt";

    private static long[] getData(List<String> lines, int i) {
        return Arrays.stream(lines.get(i)
                        .split(":")[1]
                        .trim()
                        .split("\\s+"))
                .mapToLong(Long::parseLong)
                .toArray();
    }

    private static List<Race> extractRaceData(List<String> puzzleInput) {
        long[] times = getData(puzzleInput, 0);
        long[] distances = getData(puzzleInput, 1);

        List<Race> races = new ArrayList<>();

        for (int i = 0; i < times.length; i++) {
            races.add(
                    new Race(i + 1, times[i], distances[i])
            );
        }
        return races;
    }


    public static void main(String[] args) {

        List<String> puzzleInput = FileHelper.readLines(INPUT_FILE);

        List<Race> races = extractRaceData(puzzleInput);

        Long partOne = races.stream()
                .map(Race::calcStrategies)
                .reduce(1L, (accumulator, currentValue) -> accumulator * currentValue);

        System.out.println("part one :" + partOne);

        Race bigRace = new Race(4, 47707566L, 282107911471062L);

        System.out.println("part two :" + bigRace.calcStrategies());
        
    }
}
