package Niuke.toutiao;

import java.util.Arrays;
import java.util.Scanner;

//头条校招
//输入描述:
//输入的第一行包含一个整数n，表示目前已经出好的题目数量。
//第二行给出每道题目的难度系数d1,d2,...,dn。
//数据范围
//对于30%的数据，1 ≤ n,di ≤ 5;
//对于100%的数据，1 ≤ n ≤ 10^5,1 ≤ di ≤ 100。
//在样例中，一种可行的方案是添加2个难度分别为20和50的题目，这样可以组合成两场考试：（20 20 23）和（35,40,50）。
//输出描述:
//输出只包括一行，即所求的答案。
//输入
//4
//20 35 23 40
//输出
//2
public class IntervalTen {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            Arrays.sort(a);
            int t = 1;
            int cnt = 0;
            for (int i = 1; i < n; i++) {
                if (t < 3) {
                    if (a[i] - a[i - 1] <= 10)
                        t++;
                    else if (t == 1 && a[i] - a[i - 1] <= 20) {
                        cnt++;
                        t = 3;
                    } else {
                        cnt += 3 - t;
                        t = 1;
                    }
                } else
                    t = 1;
            }
            cnt += 3 - t;
            System.out.println(cnt);
        }
    }
}
