package Niuke.netease.contest_huyu;

import java.io.BufferedReader;
import java.io.InputStreamReader;
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
