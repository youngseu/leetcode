package Niuke.toutiao.contest_toutiao;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

//小明在抖音关注了N个主播，每个主播开播时间固定，分别在s时刻开始直播，t时刻结束直播，小明无法同时观看两个主播的直播，一天
//被分为M个时间单位，请问小明每天最多能完整观看多少场直播
//第一行输入代表N，第二行输入代表M，第三行2*N个数代表s，t
//s<t代表连续直播，跨天
//输入
//3
//10
//0 3 3 7 7 0
//输出
//3
//输入
//3
//10
//0 5 2 7 6 9
//输出
//2
public class fifth {
    public static int max;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine().trim());
        int m = Integer.parseInt(bf.readLine().trim());
        int[][] array = new int[n][2];
        String[] str = bf.readLine().trim().split(" ");
        for (int i = 0; i < n; i++) {
            array[i][0] = Integer.parseInt(str[2 * i]);
            array[i][1] = Integer.parseInt(str[2 * i + 1]);
            if (array[i][1] < array[i][0]) {
                array[i][1] += m;
            }
        }
        Arrays.sort(array, (o1, o2) -> o1[1] - o2[1]);
        max = 0;
        for (int i = 0; i < array.length; i++) {
            int count = 1;
            int start = array[i][0];
            int lastEnd = array[i][1];
            for (int j = i + 1; j < array.length; j++) {
                if (array[j][1] - start > m) {
                    max = Math.max(max, count);
                    break;
                } else if (array[j][0] >= lastEnd) {
                    count++;
                    lastEnd = array[j][0];
                }
            }
            max = Math.max(max, count);
        }
        System.out.println(max);
    }
}
