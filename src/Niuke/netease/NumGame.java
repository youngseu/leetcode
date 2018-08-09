package Niuke.netease;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

//数串游戏
//题目描述
//小易邀请你玩一个数字游戏，小易给你一系列的整数。你们俩使用这些整数玩游戏。每次小易会任意说一个数字出来，然后你需要从这
//一系列数字中选取一部分出来让它们的和等于小易所说的数字。 例如： 如果{2,1,2,7}是你有的一系列数，小易说的数字是11.你可
//以得到方案2+2+7 = 11.如果顽皮的小易想坑你，他说的数字是6，那么你没有办法拼凑出和为6 现在小易给你n个数，让你找出无法
//从n个数中选取部分求和的数字中的最小数（从1开始）。
//输入描述:
//输入第一行为数字个数n (n ≤ 20)
//第二行为n个数xi (1 ≤ xi ≤ 100000)
//输出描述:
//输出最小不能由n个数选取求和组成的数
//示例1
//输入
//3
//5 1 2
//输出
//4
public class NumGame {
    public static void backtrace(int[] array, int start, int[] flag, int sum) {
        if (flag[sum] == 0) flag[sum] = 1;
        for (int i = start; i < array.length; i++) {
            sum += array[i];
            backtrace(array, i + 1, flag, sum);
            sum -= array[i];
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(bf.readLine());
        int[] flag = new int[num * 100000 + 1];

        int[] numarray = new int[num];
        String[] arraystr = bf.readLine().trim().split(" ");
        for (int i = 0; i < num; i++) {
            numarray[i] = Integer.parseInt(arraystr[i]);
        }
        Arrays.sort(numarray);
//        backtrace(numarray, 0, flag, 0);
//        for (int i = 1; i < length * 100000; i++) {
//            if (flag[i] == 0) {
//                System.out.println(i);
//                break;
//            }
//        }
        int miss = 0;
        for (int i = 0; i < num; i++) {
            if (numarray[i] > miss + 1) break;
            miss += numarray[i];
        }
        System.out.println(miss + 1);
    }
}
