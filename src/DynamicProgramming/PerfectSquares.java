package DynamicProgramming;

import java.util.Arrays;

//279 problem
//Perfect Squares
//Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...)
//which sum to n.
//Example 1:
//Input: n = 12
//Output: 3
//Explanation: 12 = 4 + 4 + 4.
//Example 2:
//Input: n = 13
//Output: 2
//Explanation: 13 = 4 + 9.
public class PerfectSquares {
    public int numSquares(int n) {
        int[] count = new int[n + 1];
        Arrays.fill(count, n);
        count[0] = 0;
        for (int i = 1; i * i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (j - i * i >= 0) count[j] = Math.min(count[j], count[j - i * i] + 1);
            }
        }
        return count[n];
    }
}
