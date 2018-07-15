package Niuke.netease;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//分苹果
//题目描述
//n 只奶牛坐在一排，每个奶牛拥有 ai 个苹果，现在你要在它们之间转移苹果，使得最后所有奶牛拥有的苹果数都相同，每一
// 次，你只能从一只奶牛身上拿走恰好两个苹果到另一个奶牛上，问最少需要移动多少次可以平分苹果，如果方案不存在输出 -1。
//输入描述:
//每个输入包含一个测试用例。每个测试用例的第一行包含一个整数 n（1 <= n <= 100），接下来的一行包含 n 个整数 ai
//（1 <= ai <= 100）。
//输出描述:
//输出一行表示最少需要移动多少次可以平分苹果，如果方案不存在则输出 -1。
//输入
//4
//7 15 9 5
//输出
//3
public class DivideApple {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int len = Integer.parseInt(br.readLine());

        String[] numsString = br.readLine().trim().split(" ");

        int[] nums = new int[len];
        int sum = 0;
        for (int i = 0; i < len; i++) {
            nums[i] = Integer.parseInt(numsString[i]);
            sum += nums[i];
        }

        if (sum % len != 0) {
            System.out.println("-1");
            return;
        }

        int average = sum / len, count = 0;
        boolean flag = true;
        for (int i = 0; i < len; i++) {
            if ((nums[i] - average) % 2 == 1) {
                System.out.println("-1");
                flag = false;
                break;
            } else {
                count += Math.abs(nums[i] - average) / 2;
            }
        }
        if (flag) {
            System.out.println(count / 2);
        }
    }
}
