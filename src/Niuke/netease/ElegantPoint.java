package Niuke.netease;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//优雅的点
//题目描述
//小易有一个圆心在坐标原点的圆，小易知道圆的半径的平方。小易认为在圆上的点而且横纵坐标都是整数的点是优雅的，小
//易现在想寻找一个算法计算出优雅的点的个数，请你来帮帮他。
//例如：半径的平方如果为25
//优雅的点就有：(+/-3, +/-4), (+/-4, +/-3), (0, +/-5) (+/-5, 0)，一共12个点。
//输入描述:
//输入为一个整数，即为圆半径的平方,范围在32位int范围内。
//输出描述:
//输出为一个整数，即为优雅的点的个数
//输入
//25
//输出
//12
public class ElegantPoint {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int r2 = Integer.parseInt(bf.readLine());
        double r = Math.sqrt(r2);
        int count = 0;
        for (int i = 0; i < r; i++) {
            double res = Math.sqrt(r2 - i * i);
            if (res == Math.round(res)) {
                count++;
            }
        }
        System.out.println(4 * count);
    }
}
