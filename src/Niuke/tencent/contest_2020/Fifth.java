package Niuke.tencent.contest_2020;

import java.util.Arrays;
import java.util.Scanner;

// 视野争夺
// 最小区间覆盖问题
public class Fifth {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int l = sc.nextInt();
        int[][] eyes = new int[n][2];
        for (int i = 0; i < n; i++) {
            eyes[i][0] = sc.nextInt();
            eyes[i][1] = sc.nextInt();
        }
        sc.close();

        Arrays.sort(eyes, (a,b)->(a[0] - b[0]));
        int start = 0, res = 0, index =0;
        while (start < l) {
            int temp = start;
            for (int i = index; i < n; i++) {
                if (eyes[i][0] <= temp && eyes[i][1] > start) {
                    index = i;
                    start = eyes[i][1];
                }
            }

            if (temp == start) {
                return;
            }
            res++;
        }
        System.out.println(res);
    }
}
