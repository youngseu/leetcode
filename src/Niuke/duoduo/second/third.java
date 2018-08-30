package Niuke.duoduo.second;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

//小数循环节开始和循环节长度
//给出被除数和除数，求出循环小数开始的位置(小数点后的位数)和循环长度
//输入
//第一行包含两个数字分别是被除数a和除数
//输出
//输出一行，分别表示循环小数开始的位置和循环体的长度(无循环则开始位置为结束位置，长度为0)
//输入
//1 3
//输出
//0 1
//输入
//5 4
//输出
//2 0
public class third {
    //模拟除法
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        Map<Integer, Integer> mp = new TreeMap<>();
        a %= b;
        for (int i = 0; ; i++) {
            int x = a % b;
            if (x == 0) {
                System.out.println(i + " 0");
                break;
            }
            Integer t = mp.get(x);
            if (t != null) {
                System.out.printf("%d %d\n", t, i - t);
                break;
            }
            mp.put(x, i);
            a = x * 10;
        }
    }
}
