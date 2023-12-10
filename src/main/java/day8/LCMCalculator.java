package day8;

public class LCMCalculator {

    public static long calculateLCM(long[] numbers) {
        long lcm = 1;
        for (long number : numbers) {
            lcm = calculateLCM(lcm, number);
        }
        return lcm;
    }

    public static long calculateLCM(long a, long b) {
        return Math.abs(a * b) / calculateGCD(a, b);
    }

    public static long calculateGCD(long a, long b) {
        while (b > 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
