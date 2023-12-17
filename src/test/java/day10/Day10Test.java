package day10;

import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class Day10Test {

    public static String SAMPLE_FILE = "10_sample1.txt";
    public static String INPUT_FILE = "10.txt";
    private PipesMap pipesMap = new PipesMap(SAMPLE_FILE);

    @Test
    void outOfBoundsRange() {

        Point invalidPoint = new Point(-1, Integer.MAX_VALUE);
        assertFalse(pipesMap.validateCoordinateRange(invalidPoint));

    }

    @Test
    void inBoundsRange() {
        int x = 1;
        int y = 4;

        Point inboundPoint = new Point(1, 4);
        assertTrue(pipesMap.validateCoordinateRange(inboundPoint));

    }

    @Test
    void validNextPipe() {

        Point parentPipe = new Point(1, 1);
        Point nextPipe = new Point(2, 1);


        assertTrue(pipesMap.validateNextPipe(parentPipe, nextPipe));
    }

    @Test
    void inValidNextPipe() {

        Point parentPipe = new Point(1, 1);
        Point nextPipe = new Point(0, 1);

        assertFalse(pipesMap.validateNextPipe(parentPipe, nextPipe));

    }

    @Test
    void isExplored() {
        Point a = new Point(0, 1);
        Point b = new Point(0, 1);
        pipesMap.exploredPoints.add(a);
        pipesMap.exploredPoints.add(b);
        assertTrue(pipesMap.isExplored(new Point(0, 1)));
        assertTrue(pipesMap.isExplored(a));
        assertTrue(pipesMap.isExplored(a));

    }
}