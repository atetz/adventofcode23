package day6;

public class Race {

    int id;
    long time;
    long distanceRecord;

    public Race(int id, long time, long distanceRecord) {
        this.id = id;
        this.time = time;
        this.distanceRecord = distanceRecord;
    }

    public long calcStrategies() {
        long wins = 0L;
        for (int powerDelay = 0; powerDelay < time - 1; powerDelay++) {
            if (powerDelay == 0) {
                continue;
            }
            long speed = time - powerDelay;
            long distance = speed * powerDelay;
            if (distance > distanceRecord) {
                wins++;
            }
        }
        return wins;
    }
}
