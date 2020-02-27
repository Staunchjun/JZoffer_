package leetcode;

public class LeetCode547 {
    public int findCircleNum(int[][] M) {
        int n = M.length;
        UF uf = new UF(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (M[i][j] == 1) {
                    uf.union(i, j);
                }
            }
        }
        return uf.count;
    }

    class UF {
        // 连通分量个数
        private int count;
        // 存储一棵树的父节点
        private int[] parent;
        // 记录树的尺寸
        private int[] size;

        public UF(int n) {
            this.count = n;
            parent = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        /**
         * 连接两个小伙伴
         *
         * @param x
         * @param y
         */
        public void union(int x, int y) {
            int XRoot = findRoot(x);
            int YRoot = findRoot(y);
            /**
             * 如果root相同就没啥好说的
             */
            if (XRoot == YRoot) {
                return;
            }
            /**
             * 小的接到大树上
             */
            if (size[XRoot] > size[YRoot]) {
                parent[YRoot] = XRoot;
                size[XRoot] += size[YRoot];
            } else {
                parent[XRoot] = YRoot;
                size[YRoot] += size[XRoot];
            }
            /**
             * 二合为一
             */
            count--;
        }

        /**
         * 寻找根节点
         * 使用路径压缩
         *
         * @param i
         * @return 根节点
         */
        private int findRoot(int i) {
            /**
             * 按照设定 只有根节点他的父节点是自己~
             */
            while (parent[i] != i) {
//                普通解法
//                i = parent[i];
//                路径压缩 每一步find 操作顺便把到root节点的路径压缩一下
//                如果这里 i == parent[i] 则 parent[parent[i]] == parent[i] = i 没毛病
                parent[i] = parent[parent[i]];
                i = parent[i];
            }
            return i;
        }

        /**
         * 是否连接
         *
         * @param x
         * @param y
         * @return 是否连接
         */
        public boolean checkConnected(int x, int y) {
            int XRoot = findRoot(x);
            int YRoot = findRoot(y);
            return XRoot == YRoot;
        }

        /**
         * 获取有多少联通分量
         *
         * @return 分量数目
         */
        public int getCount() {
            return count;
        }
    }

    public static void main(String[] args) {

    }
}
