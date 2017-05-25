/**
 * Created by Administrator on 2017/5/23.
 */
public class EditDistance {
    public static void main(String[] args) {
//        Compare two trajectories of customer Input format: "1,236,58,9,777,53465,231,12345," Each number denotes a node ID.
        String a = "1,236,58,9,777,53465,231,12345,";
        String[] as = a.split(",");
        String b = "1,236,57,9,777,231,12345,53465,";
        String[] bs = b.split(",");
        System.out.println("similarity:"+(1-(minDistance(as, bs)*1.0/Math.max(as.length,bs.length))));
        System.out.println("distance:"+(minDistance(as, bs)));
    }

    public static int minDistance(String[] word1, String[] word2) {
        if (word1.length == 0) return word2.length;
        if (word2.length == 0) return word1.length;

        int[][] distance = new int[word1.length + 1][word2.length + 1];

        for (int i = 0; i <= word1.length;i++) {
            distance[i][0] = i;
        }

        for (int i = 0; i <= word2.length; i++) {
            distance[0][i] = i;
        }

        for (int i = 1; i <= word1.length; i++) {
            for (int j = 1; j <= word2.length; j++) {
                int cost;
                if (word1[i - 1].endsWith(word2[j - 1])) {
                     cost = 0;
                } else {
                     cost = 1;
                }
                distance[i][j] = min(distance[i - 1][j]+1, distance[i][j - 1]+1, distance[i - 1][j - 1]+ cost);
            }
        }
        return distance[word1.length][word2.length];
    }

    public static int min(int a, int b, int c) {
        int min = 0;
        if (a > b) {
            min = b;
        } else {
            min = a;
        }
        if (min > c) {
            min = c;
        }
        return min;
    }
}