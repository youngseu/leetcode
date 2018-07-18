package Niuke.didi;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class LongestSumSequence {
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(bf.readLine());

        String[] str = bf.readLine().trim().split(" ");
        int[] nums = new int[num];
        int cur_sum=0,max_sum=0;
        for (int i = 0; i < num; i++) {
            nums[i] = Integer.parseInt(str[i]);
            if (i == 0) {
                cur_sum = nums[i];
                max_sum = nums[i];
            } else if (cur_sum < 0) {
                cur_sum = nums[i];
            } else {
                cur_sum += nums[i];
            }
            if (cur_sum > max_sum) {
                max_sum = cur_sum;
            }
        }
        System.out.println(max_sum);
    }
}
