package Niuke.duoduo;

import java.util.*;
//有N个货车（0<=N<=1024），每个货物的重量是w（100<=w<=300），如果每辆车最多的载重为300，请问最少需要多少辆车才能
//运输所有货物
//输入描述
//一行输入，包含N个正整数，表示每个货物的重量，空格分开
//输出描述
//一行输出，包含一个整数，表示需要的车辆数
//示例
//130 140 150 160
//输出
//2
public class three {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String in = s.nextLine();
        String[] tmps = in.split(" ");
        int[] A = new int[tmps.length];
        int count100 = 0;
        for (int i = 0; i < tmps.length; i++) {
            A[i] = Integer.parseInt(tmps[i]);
            if (A[i] == 100) count100++;
        }
        Arrays.sort(A);

        int res1 = count100 / 3;

        int res = 0;
        boolean[] tmp2 = new boolean[A.length];
        for (int i = res1 * 3; i < A.length; i++) {
            if (tmp2[i] == true) continue;
            res++;
            int total = 300 - A[i];
            for (int j = A.length - 1; j > i; j--) {
                if (total >= A[j] && tmp2[j] == false) {
                    tmp2[j] = true;
                    break;
                }
            }
        }
        System.out.print(res + res1);
    }
}