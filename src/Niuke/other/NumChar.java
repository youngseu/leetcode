package Niuke.other;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
//数串
//题目描述
//设有n个正整数，将他们连接成一排，组成一个最大的多位整数。
//如:n=3时，3个整数13,312,343,连成的最大整数为34331213。
//如:n=4时,4个整数7,13,4,246连接成的最大整数为7424613。
//输入描述:
//有多组测试样例，每组测试样例包含两行，第一行为一个整数N（N<=100），第二行包含N个数(每个数不超过1000，空格分开)。
//输出描述:
//每组数据输出一个表示最大的整数。
//示例1
//输入
//2
//12 123
//4
//7 13 4 246
//输出
//12312
//7424613
public class NumChar {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(bf.readLine().trim());
        String[] strs = bf.readLine().trim().split(" ");
        Arrays.sort(strs, (o1, o2) -> Integer.parseInt(o1 + o2) - Integer.parseInt(o2 + o1));
        for (int i = strs.length - 1; i >= 0; i--) {
            System.out.print(strs[i]);
        }
    }
}
