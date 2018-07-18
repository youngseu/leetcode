package Niuke.other;

import java.io.BufferedReader;
import java.io.InputStreamReader;
//酒店价格
//题目描述
//酒店房间的价格录入是通过时间段来录入的，比如10月1日至10月7日800元，10月8日至10月20日500元，请实现以下
//函数int[][] merge(int[][] dateRangePrices)，输入是某个酒店多个日期段的价格，每个日期段（终止日期大于
//等于起始日期）和对应的价格使用长度为3的数组来表示，比如[0, 19, 300], [10, 40, 250]分别表示从某天开始
//第1天到第20天价格都是300，第11天到第41天价格都是250，这些日期端有可能重复，重复的日期的价格以后面的为准，
//请以以下规则合并并输出合并结果：
//1.相邻两天的价格如果相同，那么这两个日期段应该合并
//2.合并的结果应该以起始日期从小到大排序
//输入描述:
//输入数据包括多行，如样例输入所示。
//输出描述:
//输出数据为一行，如样例输出所示
//示例1
//输入
//1 1 100
//2 3 100
//4 5 110
//输出
//[1, 3, 100],[4, 5, 110]
public class PriceOfRestaurant {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String str;
        int[] x = new int[20000];
        int start, end, price, flag = 0, max = 0;
        while ((str = bf.readLine()) != null) {
            String[] str1 = str.split(" ");
            start = Integer.parseInt(str1[0]);
            end = Integer.parseInt(str1[1]);
            price = Integer.parseInt(str1[2]);
            max = Math.max(max, end);
            for (int i = start; i <= end; i++) {
                x[i] = price;
            }
        }

        start = 0;
        for (int i = 0; i <= max; i++) {
            if (x[i] == 0) {
                start = i + 1;
                continue;
            }
            if (i == max) {
                System.out.print(",[" + start + ", " + max + ", " + x[i] + "]");
                break;
            }
            if (x[i] != x[i + 1]) {
                end = i;
                price = x[i];
                if (flag == 0) {
                    System.out.print("[" + start + ", " + end + ", " + price + "]");
                } else
                    System.out.print(",[" + start + ", " + end + ", " + price + "]");
                flag = 1;
                start = i + 1;
                continue;
            }
        }
    }
}
