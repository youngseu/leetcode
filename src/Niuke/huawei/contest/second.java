package Niuke.huawei.contest;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class second {
    static int[][] array = new int[5][2];
    static int max = Integer.MIN_VALUE;

    public static void backtracing(int count, int start, int m) {
        if (count < 0) return;
        else {
            if (m > max) max = m;
            for (int i = start; i < array.length; i++) {
                backtracing(count - array[i][1], i + 1, m + array[i][0]);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] str1 = bf.readLine().trim().split(",");
        String[] str2 = bf.readLine().trim().split(",");
        int count = Integer.parseInt(bf.readLine().trim());
        for (int i = 0; i < 5; i++) {
            array[i][0] = Integer.parseInt(str1[i]);
            array[i][1] = Integer.parseInt(str2[i]);
        }
        backtracing(count, 0, 0);
        System.out.println(max);
    }
}
