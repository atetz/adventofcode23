package day5;

import utils.InputReader;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.stream;

public class Day5 {

    public static String INPUT_FILE = "05.txt";
    public static String SAMPLE_FILE = "05_sample1.txt";

    public static List<String> getPuzzleInput(String file) {
        InputReader input = new InputReader(file);
        return input.getLines();
    }


    private static long[] extractSeeds(String line) {
        return stream(line.replaceAll("\\w+:\\s", "").split("\\s+"))
                .mapToLong(Long::parseLong)
                .toArray();
    }

    private static List<CategoryMap> parseCategoryMaps(List<String> lines) {
        List<CategoryMap> categoryMaps = new ArrayList<>();
        CategoryMap categoryMap = null;

        for (String line : lines) {
            if (line.isBlank()) {
                continue;
            } else if (line.matches("^\\w+.*:")) {
                String category = line.split("\\s")[0];
                if (categoryMap == null || !category.equals(categoryMap.getName())) {
                    categoryMap = new CategoryMap(category);
                    categoryMaps.add(categoryMap);
                }
            } else {
                long[] routes = stream(line.split("\\s+"))
                        .mapToLong(Long::parseLong)
                        .toArray();
                assert categoryMap != null;
                categoryMap.addRoutes(routes);
            }
        }

        return categoryMaps;
    }

    public static long getSeedLocation(long seed, List<CategoryMap> categoryMaps) {
        long destination = seed;
        for (CategoryMap testMap : categoryMaps) {
            long oldDestination = destination;
            destination = testMap.getDestination(destination);
//            System.out.println("Seed: " + seed + ", Old Destination: " + oldDestination + ", New Destination: " + destination);
        }
        return destination;
    }

    public static long findLowestLocation(List<CategoryMap> categoryMaps, long[] seeds) {
        long lowestLocation = Long.MAX_VALUE;

        for (int i = 0; i < seeds.length; i += 2) {
            long start = seeds[i];
            long length = seeds[i + 1];

            for (long j = start; j < start + length; j++) {
                long seedLocation = getSeedLocation(j, categoryMaps);
                lowestLocation = Math.min(lowestLocation, seedLocation);
            }
        }

        return lowestLocation;
    }

    public static void main(String[] args) {

        long startTime = System.nanoTime();

//        List<String> lines = getPuzzleInput(INPUT_FILE);
        List<String> lines = getPuzzleInput(SAMPLE_FILE);

        long[] seeds = extractSeeds(lines.get(0));
        List<CategoryMap> categoryMaps = parseCategoryMaps(lines.subList(1, lines.size()));

        long lowestLocation = stream(seeds).map(s -> getSeedLocation(s, categoryMaps)).min().getAsLong();
        long lowestRangeLocation = findLowestLocation(categoryMaps, seeds) - 1;

        System.out.println("result1: " + lowestLocation);
        System.out.println("result2: " + lowestRangeLocation);

        long endTime = System.nanoTime() - startTime;
        double seconds = (double) endTime / 1_000_000_000.0;

        System.out.println(seconds + " seconds");
    }
}
