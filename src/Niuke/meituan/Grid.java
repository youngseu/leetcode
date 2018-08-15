package Niuke.meituan;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//网格走法数目
//题目描述
//有一个X*Y的网格，小团要在此网格上从左上角到右下角，只能走格点且只能向右或向下走。请设计一个算法，计算小团有多少种走法。给定两个正整数int x,int y，请返回小团的走法数目。
//输入描述:
//输入包括一行，逗号隔开的两个正整数x和y，取值范围[1,10]。
//输出描述:
//输出包括一行，为走法的数目。
//示例1
//输入
//复制
//3 2
//输出
//复制
//10
public class Grid {
    public static void main(String[] args) throws Exception {
        BufferedReader st = new BufferedReader(new InputStreamReader(System.in));
        String[] str = st.readLine().split(" ");
        int m = Integer.parseInt(str[0]);
        int n = Integer.parseInt(str[1]);
        long[] array = new long[m + n + 1];
        array[0] = 1;
        for (int i = 1; i <= m + n; i++) {
            array[i] = i * array[i - 1];
        }
        System.out.println(array[m + n] / (array[n] * array[m]));
    }
}
