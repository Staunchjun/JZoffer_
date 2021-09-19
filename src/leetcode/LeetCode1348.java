package leetcode;

import java.util.*;

public class LeetCode1348 {

    int second = 1;
    int minuteToSecond = second * 60;
    int hourToSecond = minuteToSecond * 60;
    int dayToSecond = hourToSecond * 24;
    Map<String, List<Integer>> stringListMap;


    public LeetCode1348() {
        stringListMap = new HashMap<>();
    }

    public void recordTweet(String tweetName, int time) {
        List<Integer> integerList = stringListMap.getOrDefault(tweetName, new ArrayList<>());
        integerList.add(time);
        Collections.sort(integerList);
        stringListMap.put(tweetName, integerList);
    }

    public List<Integer> getTweetCountsPerFrequency(String freq, String tweetName, int startTime, int endTime) {
        int diffTime = second;
        switch (freq) {
            case "minute":
                diffTime = minuteToSecond;
                break;
            case "hour":
                diffTime = hourToSecond;
                break;
            case "day":
                diffTime = dayToSecond;
                break;
            default:
                break;
        }

        List<Integer> res = new ArrayList<>();
        List<Integer> integerList = stringListMap.getOrDefault(tweetName, new ArrayList<>());
        // 取出 符合要求的时间段
        for (int i =  startTime; i <= endTime; i = i + diffTime) {
            int start = i;
            int end = Math.min(i + diffTime, endTime + 1);
            int cnt = 0;
            for (int tempVaule : integerList) {
                if (start <= tempVaule && tempVaule < end ) {
                    cnt++;
                }
            }
            res.add(cnt);
        }
        System.out.println(Arrays.toString(res.toArray()));
        return res;
    }

    public static void main(String[] args) {
        LeetCode1348 tweetCounts = new LeetCode1348();
        tweetCounts.recordTweet("tweet3", 0);
        tweetCounts.recordTweet("tweet3", 60);
        tweetCounts.recordTweet("tweet3", 10);                             // "tweet3" 发布推文的时间分别是 0, 10 和 60 。
        tweetCounts.getTweetCountsPerFrequency("minute", "tweet3", 0, 59); // 返回 [2,1]。统计频率是每分钟（60 秒），因此有两个有效时间间隔 1) [0,60> - > 2 条推文，和 2) [60,61> - > 1 条推文。t3" 发布推文的时间分别是 0, 10 和 60 。
        tweetCounts.getTweetCountsPerFrequency("minute", "tweet3", 0, 60); // 返回 [2,1]。统计频率是每分钟（60 秒），因此有两个有效时间间隔 1) [0,60> - > 2 条推文，和 2) [60,61> - > 1 条推文。
        tweetCounts.recordTweet("tweet3", 120);                            // "tweet3" 发布推文的时间分别是 0, 10, 60 和 120 。
        tweetCounts.getTweetCountsPerFrequency("hour", "tweet3", 0, 210);  // 返回 [4]。统计频率是每小时（3600 秒），因此只有一个有效时间间隔 [0,211> - > 4 条推文。
    }
}
