package Niuke.didi;

import java.util.Arrays;
import java.util.Scanner;
//餐厅
//题目描述
//某餐馆有n张桌子，每张桌子有一个参数：a 可容纳的最大人数； 有m批客人，每批客人有两个参数:b人数，c预计消费金额。 在
//不允许拼桌的情况下，请实现一个算法选择其中一部分客人，使得总预计消费金额最大
//输入描述:
//输入包括m+2行。 第一行两个整数n(1 <= n <= 50000),m(1 <= m <= 50000) 第二行为n个参数a,即每个桌子可容纳的最大人
//数,以空格分隔,范围均在32位int范围内。 接下来m行，每行两个参数b,c。分别表示第i批客人的人数和预计消费金额,以空格分
//隔,范围均在32位int范围内。
//输出描述:
//输出一个整数,表示最大的总预计消费金额
//示例1
//输入
//3 5 2 4 2 1 3 3 5 3 7 5 9 1 10
//输出
//20
public class Restaurant {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();//table num
        int m = sc.nextInt();//batch

        int[] table = new int[n];
        for (int i = 0; i < n; i++) {
            table[i] = sc.nextInt();
        }

        int[][] person = new int[m][2];
        for (int i = 0; i < m; i++) {
            person[i][0] = sc.nextInt();
            person[i][1] = sc.nextInt();
        }

        //sort
        Arrays.sort(table);
        Arrays.sort(person, (o1, o2) -> o2[1] - o1[1]);


        long sum = 0;
        boolean[] table_flag = new boolean[n];
        //iterate, greedy
        for (int i = 0; i < m; i++) {
            if (person[i][0] > table[n - 1]) {
                continue;
            } else {
                int index = bs(table, person[i][0]);
                while (index < n && table_flag[index]) {
                    index++;
                }
                if (index < n) {
                    sum += person[i][1];
                    table_flag[index] = true;
                }
            }
        }
        System.out.println(sum);
    }

    public static int bs(int[] table, int value) {
        int start = 0;
        int end = table.length - 1;
        int mid;
        while (start <= end) {
            mid = (start + end) >> 1;
            if (table[mid] >= value) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }
}
