package Base;

//单源最短路径
public class Dijkstra {
    private static int N = 10000;

    private static int[][] Graph = {
            {0, 1, 5, N, N, N, N, N, N},
            {1, 0, 3, 7, 5, N, N, N, N},
            {5, 3, 0, N, 1, 7, N, N, N},
            {N, 7, N, 0, 2, N, 3, N, N},
            {N, 5, 1, 2, 0, 3, 6, 9, N},
            {N, N, 7, N, 3, 0, N, 5, N},
            {N, N, N, 3, 6, N, 0, 2, 7},
            {N, N, N, N, 9, 5, 2, 0, 4},
            {N, N, N, N, N, N, 7, 4, 0}};

    private static void dijkstra(int startV, int[][] graph) {
        int length = graph.length;
        //前驱节点
        int[] preNode = new int[length];
        //最近距离
        int[] minDist = new int[length];
        //标记节点是否找到最短路径
        boolean[] isFind = new boolean[length];

        //初始化
        for (int i = 0; i < length; i++) {
            preNode[i] = i;
            minDist[i] = graph[startV][i];
        }

        isFind[startV] = true;
        int vNear = 0;

        for (int i = 1; i < length; i++) {
            int min = N;
            //找到当前为标记的最短路径
            for (int j = 0; j < length; j++) {
                if (!isFind[j] && minDist[j] < min) {
                    min = minDist[j];
                    vNear = j;
                }
            }
            isFind[vNear] = true;

            for (int k = 0; k < length; k++) {
                if (!isFind[k] && (min + graph[vNear][k]) < minDist[k]) {
                    preNode[k] = vNear;
                    minDist[k] = min + graph[vNear][k];
                }
            }
        }
        for (int i = 0; i < length; i++) {
            System.out.println(startV + " " + preNode[i] + "->" + i + ":" + minDist[i]);
        }
    }

    public static void main(String[] args) {
        dijkstra(0, Graph);
    }
}
