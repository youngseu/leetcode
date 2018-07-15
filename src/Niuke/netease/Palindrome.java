package Niuke.netease;

import java.io.BufferedReader;
import java.io.InputStreamReader;
//回文序列
//题目描述
//如果一个数字序列逆置之后跟原序列是一样的就称这样的数字序列为回文序列。例如：
//{1, 2, 1}, {15, 78, 78, 15} , {112} 是回文序列,
//{1, 2, 2}, {15, 78, 87, 51} ,{112, 2, 11} 不是回文序列。
//现在给出一个数字序列，允许使用一种转换操作：
//选择任意两个相邻的数，然后从序列移除这两个数，并用这两个数字的和插入到这两个数之前的位置(只插入一个和)。
//现在对于所给序列要求出最少需要多少次操作可以将其变成回文序列。
//输入描述:
//输入为两行，第一行为序列长度n ( 1 ≤ n ≤ 50) 第二行为序列中的n个整数item[i] (1 ≤ iteam[i] ≤ 1000)，以空格分隔。
//输出描述:
//输出一个数，表示最少需要的转换次数
//示例1
//输入
//4 1 1 1 3
//输出
//1
public class Palindrome {
    public static int backtracing(int[] nums, int start, int end) {
        if (start > end) return 0;
        if (nums[start] == nums[end]) {
            return backtracing(nums, start + 1, end - 1);
        } else if (nums[start] > nums[end]) {
            nums[end - 1] = nums[end - 1] + nums[end];
            return 1 + backtracing(nums, start, end - 1);
        } else if (nums[start] < nums[end]) {
            nums[start + 1] = nums[start + 1] + nums[start];
            return 1 + backtracing(nums, start + 1, end);
        }
        return 1;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(bf.readLine());

        String[] arrays = bf.readLine().trim().split(" ");
        int[] nums = new int[length];
        for (int i = 0; i < length; i++) {
            nums[i] = Integer.parseInt(arrays[i]);
        }

        System.out.println(backtracing(nums, 0, length - 1));
    }
}
