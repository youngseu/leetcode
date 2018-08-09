package Niuke.other;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class MoreThanHalf {
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] strs = bf.readLine().trim().split(" ");
        int[] nums = new int[strs.length];
        for (int i = 0; i < strs.length; i++) {
            nums[i] = Integer.parseInt(strs[i]);
        }
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < strs.length; i++) {
            if (stack.isEmpty()) stack.push(nums[i]);
            else if (nums[i] != stack.peek()) {
                stack.pop();
            }
        }
        if (!stack.isEmpty())
            System.out.println(stack.peek());
    }
}
