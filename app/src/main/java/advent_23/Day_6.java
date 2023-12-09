package advent_23;

import java.util.HashMap;
import java.util.Map;

public class Day_6 {

    public long boatRace(int[] raceTimes, int[] records){
        long pow =1;
        for (int i=0;i<raceTimes.length;i++){
            pow*=numberOfWaysForRace(raceTimes[i], records[i]);
        }
        return pow;
    }

    public long numberOfWaysForRace(long time, long record){
        int count = 0;
        for (int i = 1; i<time;i++){
            if (distance(i, time-i) > record){
                count++;
            }
        }
        return count;
    }

    private long distance(long speed, long time){
        return speed*time;
    }
}
