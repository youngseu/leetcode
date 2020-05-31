package Niuke.toutiao.contest_toutiao3;

import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

//毕业旅行问题
public class Fifth {
    private static void dfs(int[][] arr, boolean[] vis, final int SIZE, int visted, int price, int cur, AtomicInteger ans) {
        if (price > ans.get())
            return;

        if (visted == SIZE) {
            int val = price + arr[cur][0];
            if (val < ans.get()) {
                ans.set(val);
            }
            return;
        }

        for (int i = 1; i < SIZE; i++) {
            if (vis[i])
                continue;
            vis[i] = true;
            dfs(arr, vis, SIZE, visted + 1, price + arr[cur][i], i, ans);
            vis[i] = false;
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        boolean[] vis = new boolean[n];
        vis[0] = true;

        AtomicInteger ans = new AtomicInteger(Integer.MAX_VALUE);
        dfs(arr, vis, n, 1, 0, 0, ans);
        System.out.println(ans.get());
    }
}
