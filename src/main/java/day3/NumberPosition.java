package day3;

import java.util.HashSet;
import java.util.Set;

public class NumberPosition {

    private int xMin = -1;
    private int xMax = -1;
    private int y = -1;
    private String numberString = "";
    private int number = 0;
    public Set<Gear> gears;

    public Set<Gear> getGears() {
        return gears;
    }

    public void addNumber(int x, int y, String numberString) {
        if (xMin == -1) {
            this.xMin = x;
        }
        this.xMax = x;
        this.y = y;

        this.numberString += numberString;
        this.number = Integer.parseInt(this.numberString);
    }

    public int getNumber() {
        return number;
    }

    private boolean isValidSymbol(String col) {
        return col.matches("[^\\w.]");
    }

    private boolean isValidGear(String col) {
        return col.matches("[*]");
    }

    public boolean isValidPartNumber(String[][] value) {
        int numRows = value.length;
        int numCols = value[0].length;

        for (int x = xMin; x <= xMax; x++) {
            if (isValidPosition(y + 1, x + 1, numRows, numCols) && isValidSymbol(value[y + 1][x + 1])) return true;
            if (isValidPosition(y + 1, x, numRows, numCols) && isValidSymbol(value[y + 1][x])) return true;
            if (isValidPosition(y - 1, x - 1, numRows, numCols) && isValidSymbol(value[y - 1][x - 1])) return true;
            if (isValidPosition(y - 1, x, numRows, numCols) && isValidSymbol(value[y - 1][x])) return true;
            if (isValidPosition(y, x + 1, numRows, numCols) && isValidSymbol(value[y][x + 1])) return true;
            if (isValidPosition(y - 1, x + 1, numRows, numCols) && isValidSymbol(value[y - 1][x + 1])) return true;
            if (isValidPosition(y + 1, x - 1, numRows, numCols) && isValidSymbol(value[y + 1][x - 1])) return true;
            if (isValidPosition(y, x - 1, numRows, numCols) && isValidSymbol(value[y][x - 1])) return true;
        }
        return false;
    }

    public void findGears(String[][] value) {
        int numRows = value.length;
        int numCols = value[0].length;

        Set<Gear> gearSet = new HashSet<>() {
        };

        for (int x = xMin; x <= xMax; x++) {
            if (isValidPosition(y + 1, x + 1, numRows, numCols) && isValidGear(value[y + 1][x + 1])) {
                gearSet.add(new Gear(y + 1, x + 1));
            }
            ;
            if (isValidPosition(y + 1, x, numRows, numCols) && isValidGear(value[y + 1][x])) {
                gearSet.add(new Gear(y + 1, x));
            }
            ;
            if (isValidPosition(y - 1, x - 1, numRows, numCols) && isValidGear(value[y - 1][x - 1])) {
                gearSet.add(new Gear(y - 1, x - 1));
            }
            ;

            if (isValidPosition(y - 1, x, numRows, numCols) && isValidGear(value[y - 1][x])) {
                gearSet.add(new Gear(y - 1, x));
            }
            ;

            if (isValidPosition(y, x + 1, numRows, numCols) && isValidGear(value[y][x + 1])) {
                gearSet.add(new Gear(y, x + 1));
            }
            if (isValidPosition(y - 1, x + 1, numRows, numCols) && isValidGear(value[y - 1][x + 1])) {
                gearSet.add(new Gear(y - 1, x + 1));
            }
            ;
            if (isValidPosition(y + 1, x - 1, numRows, numCols) && isValidGear(value[y + 1][x - 1])) {
                gearSet.add(new Gear(y + 1, x - 1));
            }
            ;
            if (isValidPosition(y, x - 1, numRows, numCols) && isValidGear(value[y][x - 1])) {
                gearSet.add(new Gear(y, x - 1));
            }
        }
        this.gears = gearSet;
    }

    private boolean isValidPosition(int y, int x, int numRows, int numCols) {
        return y >= 0 && y < numRows && x >= 0 && x < numCols;
    }

}
