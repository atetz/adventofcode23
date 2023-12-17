package day10;

import utils.FileHelper;

import java.awt.*;
import java.util.List;
import java.util.*;


public class PipesMap {

    public static String[][] map;
    public static int xWidth;
    public static int yLength;

    public List<Point> exploredPoints = new ArrayList<>();

    Set<Character> southDestPipes = new HashSet<>(Arrays.asList('|', 'L', 'J'));
    Set<Character> eastDestPipes = new HashSet<>(Arrays.asList('-', 'J', '7'));
    Set<Character> northDestPipes = new HashSet<>(Arrays.asList('F', '7', '|'));
    Set<Character> westDestPipes = new HashSet<>(Arrays.asList('-', 'F', 'L'));

    Set<Character> southMovingPipes = new HashSet<>(Arrays.asList('S', '|', '7', 'F'));
    Set<Character> eastMovingPipes = new HashSet<>(Arrays.asList('S', '-', 'F', 'L'));
    Set<Character> northMovingPipes = new HashSet<>(Arrays.asList('S', '|', 'L', 'J'));
    Set<Character> westMovingPipes = new HashSet<>(Arrays.asList('S', '-', 'J', '7'));

    private static int[][] DIRECTIONS
            = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};


    public static Point findStartPos(String identifier) {
        int yStart = 0;
        int xStart = 0;

        for (int i = 0; i < yLength; i++) {
            for (int j = 0; j < xWidth; j++) {
                if (map[i][j].equals(identifier)) {
                    yStart = i;
                    xStart = j;
                    break;
                }
            }
        }
        return new Point(xStart, yStart);
    }

    public boolean validateCoordinateRange(Point point) {
        return point.x >= 0 && point.x < xWidth && point.y >= 0 && point.y < yLength;
    }

    public Character getPipe(int x, int y) {
        return map[y][x].charAt(0);
    }

    public boolean validateNextPipe(Point parent, Point current) {

        int[] north = DIRECTIONS[2];
        int[] south = DIRECTIONS[0];
        int[] west = DIRECTIONS[3];
        int[] east = DIRECTIONS[1];

        int xDirection = current.x - parent.x;
        int yDirection = current.y - parent.y;
        int[] move = new int[]{xDirection, yDirection};

        char parentPipe = getPipe(parent.x, parent.y);
        char currentPipe = getPipe(current.x, current.y);


        if (Arrays.equals(move, north) && northDestPipes.contains(currentPipe)
                && northMovingPipes.contains(parentPipe)) {
            return true;

        } else if (Arrays.equals(move, south) && southDestPipes.contains(currentPipe)
                && southMovingPipes.contains(parentPipe)) {
            return true;


        } else if (Arrays.equals(move, west) && westDestPipes.contains(currentPipe)
                && westMovingPipes.contains(parentPipe)) {
            return true;

        } else return Arrays.equals(move, east) && eastDestPipes.contains(currentPipe)
                && eastMovingPipes.contains(parentPipe);

    }

    public void setExplored(Point exploredPoint) {
        exploredPoints.add(exploredPoint);
    }

    public boolean isExplored(Point point) {
        return exploredPoints.contains(point);
    }

    public void explorePaths(Point start) {
        Stack<Point> stack = new Stack<>();
        stack.push(start);

        exploredPoints.add(start);

        while (!stack.isEmpty()) {
            Point current = stack.pop();

            int xStart = current.x;
            int yStart = current.y;

            System.out.println("current: " + xStart + ", " + yStart);

            for (int[] direction : DIRECTIONS) {
                int x = direction[0];
                int y = direction[1];

                int xNext = xStart + x;
                int yNext = yStart + y;

                Point nextPoint = new Point(xNext, yNext);

                System.out.println("looking at: " + xNext + ", " + yNext);

                if (validateCoordinateRange(nextPoint) && validateNextPipe(current, nextPoint) && !isExplored(nextPoint)) {

                    System.out.println("successfully added: " + xNext + ", " + yNext);
                    exploredPoints.add(nextPoint);
                    stack.push(nextPoint);
                }
            }
        }
    }

    public List<Point> getExploredPoints() {
        return exploredPoints;
    }

    public PipesMap(String fileName) {

        map = FileHelper.readLinesAs2DArray(fileName);
        xWidth = map[0].length;
        yLength = map.length;
    }
}
