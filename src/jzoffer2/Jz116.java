package jzoffer2;

public class Jz116 {
    public int findCircleNum(int[][] isConnected) {
        UF uf = new UF(isConnected.length);
        for (int i = 0; i < isConnected.length; i++) {
            for (int j = 0; j < isConnected.length; j++) {
                if (isConnected[i][j] == 1) {
                    uf.union(i, j);
                }
            }
        }
        return uf.count;
    }

    class UF {
        int count = 0;
        int[] parent;
        int[] size;

        public UF(int n) {
            this.parent = new int[n];
            this.size = new int[n];
            // 初始化的时候，自己是自己的parent
            for (int i = 0; i < parent.length; i++) {
                parent[i] = i;
                size[i] = 1;
            }
            this.count = n;
        }

        public int findRoot(int x) {
            // 循环直接找到parent
            while (x != parent[x]) {
                x = parent[x];
            }
            return x;
        }

        public void union(int x, int y) {
            int yParent = findRoot(y);
            int xParent = findRoot(x);
            // 如果根相等则不需要挂啦
            if (xParent == yParent) {
                return;
            }

            // 选择谁挂在谁上。这里不判断先后
            // 随便挂把，反正合在一起就行了
            // 设置x的parent为 y的parent
            parent[x] = yParent;
            size[y] += size[x];

            count--;
        }
    }

    public static void main(String[] args) {
        Jz116 jz116 = new Jz116();
        System.out.println(jz116.findCircleNum(new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}));
        System.out.println(jz116.findCircleNum(new int[][]{{1, 0, 0}, {0, 1, 0}, {0, 0, 1}}));
    }
}
