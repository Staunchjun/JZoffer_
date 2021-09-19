package leetcode;

import java.util.*;

public class LeetCode355 {
    class News {
        int time;
        int id;

        public News(int time, int id) {
            this.time = time;
            this.id = id;
        }

        public int getTime() {
            return time;
        }

        public void setTime(int time) {
            this.time = time;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }
    }

    Map<Integer, HashSet<Integer>> data;
    Map<Integer, LinkedList<News>> news;
    int time = 0;

    /**
     * Initialize your data structure here.
     */
    public LeetCode355() {
        data = new HashMap<>();
        news = new HashMap<>();
    }

    /**
     * Compose a new tweet.
     */
    public void postTweet(int userId, int tweetId) {
        LinkedList<News> linkedList = news.getOrDefault(userId, new LinkedList<>());
        linkedList.addFirst(new News(time, tweetId));
        news.put(userId, linkedList);
        time++;
    }

    /**
     * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
     */
    public List<Integer> getNewsFeed(int userId) {
        // combine all followed news
        List<Integer> ret = new ArrayList<>();
        PriorityQueue<News> priorityQueue = new PriorityQueue((o, t1) -> {
            News data1 = (News) o;
            News data2 = (News) t1;
            return data2.time - data1.time;
        });
        // add own news
        LinkedList<News> ownNews = news.getOrDefault(userId, new LinkedList<>());
        priorityQueue.addAll(ownNews);

        // add follower news
        HashSet<Integer> followers = data.getOrDefault(userId, new HashSet<>());
        for (Integer follower : followers) {
            LinkedList<News> followerNews = news.getOrDefault(follower, new LinkedList<>());
            priorityQueue.addAll(followerNews);
        }

        while (!priorityQueue.isEmpty()) {
            if (ret.size() < 10) {
                ret.add(priorityQueue.poll().id);
            } else {
                return ret;
            }
        }
        return ret;
    }

    /**
     * Follower follows a followee. If the operation is invalid, it should be a no-op.
     */
    public void follow(int followerId, int followeeId) {
        HashSet<Integer> followers = data.getOrDefault(followerId, new HashSet<>());
        followers.add(followeeId);
        data.put(followerId, followers);
    }

    /**
     * Follower unfollows a followee. If the operation is invalid, it should be a no-op.
     */
    public void unfollow(int followerId, int followeeId) {
        HashSet<Integer> followers = data.getOrDefault(followerId, new HashSet<>());
        followers.remove(followeeId);
        data.put(followerId, followers);
    }
}
