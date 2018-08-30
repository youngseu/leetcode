package ArrayorList;

import java.util.Stack;

//84 problem
//Largest Rectangle in Histogram
//Given n non-negative integers representing the histogram's bar height where the width of each
//bar is 1, find the area of largest rectangle in the histogram.
//Example:
//Input: [2,1,5,6,2,3]
//Output: 10
//单调栈
public class LargestRectangleinHistogram {
    public int largestRectangleArea(int[] height) {
        int len = height.length;
        Stack<Integer> s = new Stack<Integer>();
        int maxArea = 0;
        for (int i = 0; i <= len; i++) {
            int h = (i == len ? 0 : height[i]);
            if (s.isEmpty() || h >= height[s.peek()]) {
                s.push(i);
            } else {
                int tp = s.pop();
                maxArea = Math.max(maxArea, height[tp] * (s.isEmpty() ? i : i - 1 - s.peek()));
                i--;
            }
        }
        return maxArea;
    }
}
