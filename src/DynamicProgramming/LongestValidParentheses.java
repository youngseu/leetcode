package DynamicProgramming;

import java.util.Stack;

/**
 * Created by youngyoung on 2018/3/28.
 */
//32 problem
//Longest Valid Parentheses
//Given a string containing just the characters '(' and ')', find the length of the longest valid
//(well-formed) parentheses substring.
//Example 1:
//Input: "(()"
//Output: 2
//Explanation: The longest valid parentheses substring is "()"
//Example 2:
//Input: ")()())"
//Output: 4
//Explanation: The longest valid parentheses substring is "()()"
public class LongestValidParentheses {
    //dp
    public static int longestValidParentheses(String s) {
        int maxlen = 0;
        int dp[] = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            //judge index wheathe out of range
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
                maxlen = Math.max(maxlen, dp[i]);
            }
        }
        return maxlen;
    }

    //stack
    public static int longestValidParentheses1(String s) {
        int maxlen = 0;
        Stack<Integer> stack = new Stack<Integer>();
        //初始
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            //左括号直接进栈
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                //右括号弹栈
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    maxlen = Math.max(maxlen, i - stack.peek());
                }
            }
        }
        return maxlen;
    }

    public static void main(String[] args) {
        System.out.println(longestValidParentheses("(()())"));
    }
}
