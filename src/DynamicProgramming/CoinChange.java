package DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//problem 322
//Coin Change
//You are given coins of different denominations and a total amount of money amount. Write a function
// to compute the fewest number of coins that you need to make up that amount. If that amount of money
//cannot be made up by any combination of the coins, return -1.
//Input: coins = [1, 2, 5], amount = 11
//Output: 3
//Explanation: 11 = 5 + 5 + 1
//Input: coins = [2], amount = 3
//Output: -1
public class CoinChange {

    //Dynamic programming - Top down
    public int coinChange(int[] coins, int amount) {
        if (amount < 1) return 0;
        return coinChange(coins, amount, new int[amount]);
    }

    private int coinChange(int[] coins, int rem, int[] count) {
        if (rem < 0) return -1;
        if (rem == 0) return 0;
        if (count[rem - 1] != 0) return count[rem - 1];
        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int res = coinChange(coins, rem - coin, count);
            if (res >= 0 && res < min)
                min = 1 + res;
        }
        count[rem - 1] = (min == Integer.MAX_VALUE) ? -1 : min;
        return count[rem - 1];
    }

    //Dynamic programming - Bottom up
    public int coinChange1(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

    //Backtracing time out
    public int coinChange2(int[] coins, int amount) {
        List<List<Integer>> res = new ArrayList<>();
        backtracing(res, new ArrayList(), amount, coins, 0);
        return res.size() > 0 ? res.get(0).size() : -1;
    }

    public void backtracing(List<List<Integer>> res, List list, int target, int[] coins, int start) {
        if (target < 0) return;
        else if (target == 0) {
            if (res.size() > 0 && list.size() < res.get(0).size()) {
                res.clear();
                res.add(new ArrayList<>(list));
            } else
                res.add(new ArrayList<>(list));
        } else {
            for (int i = start; i < coins.length; i++) {
                list.add(coins[i]);
                backtracing(res, list, target - coins[i], coins, i);
                list.remove(list.size() - 1);
            }
        }
    }


}
