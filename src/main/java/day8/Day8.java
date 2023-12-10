package day8;

import utils.FileHelper;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Day8 {

    public static String SAMPLE_FILE = "08_sample2.txt";
    public static String INPUT_FILE = "08.txt";

    public static int partOne(Map<String, String[]> routeNetwork, List<Integer> instructions) {
        int steps = 0;
        String startLocation = "AAA";
        String destinationLocation = "ZZZ";
        String currentLocation = null;

        while (!Objects.equals(currentLocation, destinationLocation)) {
            if (currentLocation == null) {
                currentLocation = startLocation;
            }
            for (int j : instructions) {
                String nextLocation = routeNetwork.get(currentLocation)[j];
                steps++;
                currentLocation = nextLocation;
            }
        }
        return steps;
    }

    public static void main(String[] args) {

        List<String> puzzleInput = FileHelper.readLines(INPUT_FILE);
        List<Integer> instructionsLookup = new ArrayList<>();
        Map<String, String[]> routeNetwork = new HashMap<>();

        Pattern routePattern = Pattern.compile("(\\w+) = \\((\\w+), (\\w+)\\)");

        int i = 0;
        boolean firstLine = true;
        for (String line : puzzleInput) {
            if (firstLine) {
                instructionsLookup = line.chars()
                        .mapToObj(c -> c == 'L' ? 0 : 1)
                        .collect(Collectors.toList());
                firstLine = false;
                continue;
            } else if (line.isEmpty()) {
                continue;
            }
            Matcher routeMatcher = routePattern.matcher(line);
            if (routeMatcher.find()) {
                String location = routeMatcher.group(1);
                String[] elements = new String[]{routeMatcher.group(2), routeMatcher.group(3)};
                routeNetwork.put(location, elements);
            }
        }
        System.out.println("Part one: " + partOne(routeNetwork, instructionsLookup));


    }
}
