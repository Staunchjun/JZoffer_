package leetcode;

import java.util.HashMap;
import java.util.Map;

public class LeetCode1396 {

    class Time {
        String station;
        int time;

        public Time(String station, int time) {
            this.station = station;
            this.time = time;
        }
    }

    // start+end avg
    Map<String, double[]> avgMap = new HashMap<>();
    Map<Integer, Time> inMap = new HashMap<>();

    public LeetCode1396() {

    }

    public void checkIn(int id, String stationName, int t) {
        inMap.put(id, new Time(stationName, t));
    }

    public void checkOut(int id, String stationName, int t) {
        Time time = inMap.get(id);
        inMap.remove(time);
        String name = time.station + "+" + stationName;
        double diff = t - time.time;
        double[] data = avgMap.getOrDefault(name, new double[]{0.0,0.0});
        double num = data[0];
        num += 1;
        data[0] = num;
        double sum = data[1];
        sum += diff;
        data[1] = sum;
        avgMap.put(name, data);
    }

    public double getAverageTime(String startStation, String endStation) {
        String name = startStation + "+" + endStation;
        double[] data = avgMap.getOrDefault(name, new double[]{0.0,0.0});
        return data[1]/data[0];
    }
}
