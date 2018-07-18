package Niuke.toutiao;

import java.util.Arrays;
import java.util.Scanner;
//字典序
//题目描述
//给定整数n和m, 将1到n的这n个整数按字典序排列之后, 求其中的第m个数。
//对于n=11, m=4, 按字典序排列依次为1, 10, 11, 2, 3, 4, 5, 6, 7, 8, 9, 因此第4个数是2.
//输出描述:
//输出仅包括一行, 即所求排列中的第m个数字.
//示例1
//输入
//11 4
//输出
//2
public class Lexicographical {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        String[] array = new String[n];
        for (int i = 0; i < n; i++) {
            array[i] = String.valueOf(i+1);
        }
        Arrays.sort(array);
        System.out.println(array[m - 1]);
    }
}
