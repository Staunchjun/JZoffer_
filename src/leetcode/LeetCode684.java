package leetcode;

public class LeetCode684 {
    public int[] findRedundantConnection(int[][] edges) {
        int num = edges.length + 1;
        UnionFriend uf = new UnionFriend(num);
        int[] res = new int[2];
        for (int[] edge : edges) {
            int x = edge[0];
            int y = edge[1];
            if (uf.isCOnnected(x, y)) {
                res[0] = x;
                res[1] = y;
                break;
            } else {
                uf.union(x, y);
            }
        }
        return res;
    }

    class UnionFriend {
        private int count;
        private int[] size;
        private int[] parent;

        public void union(int x, int y) {
            int rootA = findRoot(x);
            int rootB = findRoot(y);
            if (rootA == rootB) {
                return;
            }
            if (size[rootA] > size[rootB]) {
                parent[rootB] = rootA;
                size[rootA] += rootB;
            } else {
                parent[rootA] = rootB;
                size[rootB] += rootA;
            }
            count--;
        }

        public UnionFriend(int n) {
            this.count = n;
            size = new int[n];
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                size[i] = 1;
                /**
                 * parent 是自己
                 */
                parent[i] = i;
            }
        }

        public int getCount() {
            return count;
        }

        public boolean isCOnnected(int x, int y) {
            int rootA = findRoot(x);
            int rootB = findRoot(y);
            return rootA == rootB;
        }

        /**
         * 找root顺便路径压缩
         *
         * @param i
         * @return
         */
        private int findRoot(int i) {
            while (parent[i] != i) {
                parent[i] = parent[parent[i]];
                i = parent[i];
            }
            return i;
        }
    }
}
