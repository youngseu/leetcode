package Greedy;

//121 problem
//Best Time to Buy and Sell Stock
//Say you have an array for which the ith element is the price of a given stock on day i.
//If you were only permitted to complete at most one transaction (i.e., buy one and sell one
//share of the stock), design an algorithm to find the maximum profit.
//Example 1:
//Input: [7,1,5,3,6,4]
//Output: 5
//Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
//             Not 7-1 = 6, as selling price needs to be larger than buying price.
public class BestTimetoBuyandSellStock {
    public int maxProfit(int[] prices) {
        int minnum = Integer.MAX_VALUE;
        int max = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minnum)
                minnum = prices[i];
            else if (prices[i] - minnum > max)
                max = prices[i] - minnum;
        }
        return max;
    }
}
