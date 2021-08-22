package leetcode;

public class LeetCode1723 {
    /**
     * 给你一个整数数组 jobs ，其中 jobs[i] 是完成第 i 项工作要花费的时间。
     * <p>
     * 请你将这些工作分配给 k 位工人。所有工作都应该分配给工人，
     * 且每项工作只能分配给一位工人。工人的 工作时间 是完成分配给他们的所有工作花费时间的总和。
     * 请你设计一套最佳的工作分配方案，使工人的 最大工作时间 得以 最小化 。
     * <p>
     * 返回分配方案中尽可能 最小 的 最大工作时间 。
     *
     * @param jobs
     * @param k
     * @return
     */
    int[] jobs;
    int workerNum;
    public int minimumTimeRequired(int[] jobs, int k) {
        this.jobs = jobs;
        this.workerNum = k;

        int max = 0;
        int min = Integer.MAX_VALUE;
        for (int job : jobs) {
            max += job;
            if (min >= job){
                min = job;
            }
        }

        while (min < max){
            int mid = (min + max) / 2;
            if (checkAns(mid)){
                // 如果存在，则一直往下分，尝试一直减少
                max = mid;
            }else {
                //如果不存在，则尝试加大
                min = mid + 1;
            }
        }
        return min;
    }

    private boolean checkAns(int ans){
        int[] sum = new int[this.workerNum];
        return backtrack(0, sum, ans);
    }

    private boolean backtrack(int index, int[] sum, int ans) {
        if (index >= jobs.length) {
            return true;
        }
        int cur = jobs[index];
        for (int j = 0; j < sum.length; ++j) {
            if (sum[j] + cur <= ans) {
                sum[j] += cur;
                if (backtrack(index + 1, sum,  ans)) {
                    return true;
                }
                sum[j] -= cur;
            }
            // 如果当前工人未被分配工作，那么下一个工人也必然未被分配工作
            // 或者当前工作恰能使该工人的工作量达到了上限
            // 这两种情况下我们无需尝试继续分配工作
            if (sum[j] == 0 || sum[j] + cur == ans) {
                break;
            }
        }
        return false;

//        // 增加早停，当发现超出了就不继续深搜了。不用等到全部分完，分到一半的时候发现比分完的还多就提前走啦。
//        int maxTime = Integer.MIN_VALUE;
//        for (int value : sum) {
//            if (maxTime <= value) {
//                maxTime = value;
//            }
//        }
//
//        // 如果目标时间比它小，则不用再继续深搜了，越深搜越大，直接return false
//        if (maxTime > ans){
//            return false;
//        }
//
//        // 按照顺序分完所有的都找不到适合的，则返回为false。分完后有匹配的则返回true
//        if (index == jobs.length) {
//            return ans == maxTime;
//        }
//
//        for (int i = 1; i <= workerNum; i++) {
//            // 随便选一个worker
//            sum[i - 1] += jobs[index];
//            //继续给其他任务分配worker
//            if (backtrack(index + 1, sum, ans)){
//                return true;
//            }
//            //撤销分配啦
//            sum[i - 1] -= jobs[index];
//        }
//
//        return false;
    }

    public static void main(String[] args) {
        int[] jobs = {1, 2, 4, 7, 8};
        int k = 2;
        int[] jobs2 = {9899456, 8291115, 9477657, 9288480, 5146275, 7697968, 8573153, 3582365, 3758448, 9881935, 2420271, 4542202};
        int k2 = 9;
        LeetCode1723 leetCode1723 = new LeetCode1723();
//        System.out.println(leetCode1723.minimumTimeRequired(jobs, k));
        System.out.println(leetCode1723.minimumTimeRequired(jobs2, k2));
    }
}
