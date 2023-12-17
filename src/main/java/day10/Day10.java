package day10;

import java.awt.*;

public class Day10 {

    public static String SAMPLE_FILE = "10_sample2.txt";
    public static String INPUT_FILE = "10.txt";


    public static void main(String[] args) {


        PipesMap pipesMap = new PipesMap(INPUT_FILE);
        Point startPos = PipesMap.findStartPos("S");
        pipesMap.explorePaths(startPos);
        int loopPoints = pipesMap.getExploredPoints().size() / 2;

        System.out.println("Part one: " + loopPoints);


    }
}
