package DynamicProgramming;

//96 problem
//Unique Binary Search Trees I
public class UniqueBinarySearchTreesI {
    public static int numTrees(int n) {
        //注意数组的大小，dp[i]代表以第i个节点为根节点，卡特兰数
        int[] dp = new int[n + 1];
        dp[0] = dp[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(numTrees(4));
    }
}
