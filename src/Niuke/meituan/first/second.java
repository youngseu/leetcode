package Niuke.meituan.first;

import java.util.*;
import java.util.Scanner;

//小明拿到了一个数列a1 , a2 , ... an ，小明想知道存在多少个区间[l,r]同时满足下列两个条件：
//1、r-l+1=k;
//2、在a l , a l+1,...ar中，存在一个数至少出现了 t 次。
//输出满足条件的区间个数。
//数组在滑动窗口值为k时 满足窗口某数字重复次数超过t 的窗口个数
//第一行为数字个数n 窗口大小k 重复次数t
//第二行为n个数字
//输入为两行
//输入
//5 3 2
//3 1 1 1 2
//输出
//3
public class second {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int t = sc.nextInt();
        int count = 0;
        int[] num = new int[n];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < n; i++) {
            num[i] = sc.nextInt();
            int c = map.getOrDefault(num[i], 0);
            map.put(num[i], c + 1);
            if (i + 1 - k == 0) {
                for (Integer val : map.values()) {
                    if (val >= t) count++;
                }
            } else if (i + 1 - k > 0) {
                int remove = map.get(num[i - k]);
                if (remove == 1) {
                    map.remove(num[i - k]);
                } else {
                    map.put(num[i - k], remove - 1);
                }
                for (Integer val : map.values()) {
                    if (val >= t) count++;
                }
            }
        }
        System.out.println(count);
    }
}

