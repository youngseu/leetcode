package Niuke.netease.contest_huyu;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//题目描述
//小易觉得高数课太无聊了，决定睡觉。不过他对课上的一些内容挺感兴趣，所以希望老师讲到有趣的地方的时候叫醒他一下。
//你知道了小易对一堂课每分钟知识点的感兴趣程度，并以分数量化，以及他在这堂课上每分钟是否会睡着，你可以叫醒他一次，
//这会使得他在接下来的k分钟内保持清醒。你需要选择一种方案最大化小易这堂课听到的知识点分值。
//输入描述
//第一行n，k, (1 <= n, k <= $10^5$)，表示这堂课持续多少分钟，以及叫醒小易一次使他能够保持清醒的时间。
//第二行 n个数，$a{1},a{2},..., a{n} (1<= a{i} <= 10^4)$，表示小易对每分钟知识点的感兴趣评分。
//第三行 n个数，$t{1}, t{2}, ..., t_{n}$，表示每分钟小易是否清醒，1表示清醒。
//输出描述
//小易这堂课听到的知识点的最大兴趣值。
//输入
//1
//2
//3
//6 3
//1 3 5 2 5 4
//1 1 0 1 0 0
//输出
//1
//有n节课，每次叫醒可以清醒k节课，每节课包含兴趣值和是否清醒，1为清醒，0为睡着，求只叫醒一次，兴趣值最大为多少
public class first {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] arg = bf.readLine().trim().split(" ");

        int n = Integer.parseInt(arg[0]);
        int k = Integer.parseInt(arg[1]);
        int[][] nums = new int[n][2];
        String[] xingqu = bf.readLine().trim().split(" ");
        String[] shuizhao = bf.readLine().trim().split(" ");

        int sum = 0;
        int max = 0;
        for (int i = 0; i < n; i++) {
            nums[i][0] = Integer.parseInt(xingqu[i]);
            nums[i][1] = Integer.parseInt(shuizhao[i]);
            if (nums[i][1] == 1) {
                sum += nums[i][0];
            }
        }

        max = sum;
        for (int i = 0; i <= n - k; i++) {
            int temp = sum;
            for (int j = 0; j < k; j++) {
                if (nums[i + j][1] == 0)
                    temp += nums[i + j][0];
            }
            max = Math.max(max, temp);
        }
        System.out.println(max);
    }
}
