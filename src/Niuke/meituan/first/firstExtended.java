package Niuke.meituan.first;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class firstExtended {
    class State {
        int cover, head;

        State(int c, int h) {
            cover = c;
            head = h;
        }
    }

    public int shortestPathLength(int[][] graph) {
        int N = graph.length;
        Queue<State> queue = new LinkedList();
        int[][] dist = new int[1 << N][N];
        for (int[] row : dist) Arrays.fill(row, N * N);

        for (int x = 0; x < N; ++x) {
            queue.offer(new State(1 << x, x));
            dist[1 << x][x] = 0;
        }

        while (!queue.isEmpty()) {
            State node = queue.poll();
            int d = dist[node.cover][node.head];
            if (node.cover == (1 << N) - 1) return d;

            for (int child : graph[node.head]) {
                int cover2 = node.cover | (1 << child);
                if (d + 1 < dist[cover2][child]) {
                    dist[cover2][child] = d + 1;
                    queue.offer(new State(cover2, child));
                }
            }
        }
        throw null;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(bf.readLine().trim());
        int[][] map = new int[length][length];
        for (int i = 0; i < length - 1; i++) {
            String[] input = bf.readLine().trim().split(" ");
            int x = Integer.parseInt(input[0]) - 1;
            int y = Integer.parseInt(input[1]) - 1;
            map[x][y] = 1;
            map[y][x] = 1;
        }
        int[][] graph = new int[length][];
        for (int i = 0; i < length; i++) {
            int count = 0;
            LinkedList<Integer> list = new LinkedList<>();
            for (int j = 0; j < length; j++) {
                if (map[i][j] != 0) list.add(j);
            }
            int[] tmp = new int[list.size()];
            for (int j = 0; j < list.size(); j++) {
                tmp[j] = list.get(j);
            }
            graph[i] = tmp;
        }
        System.out.println();
        System.out.println(new firstExtended().shortestPathLength(graph));
    }
}
