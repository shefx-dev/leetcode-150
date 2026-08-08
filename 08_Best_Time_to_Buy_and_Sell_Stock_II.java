// Problem: Best Time to Buy and Sell Stock II
// LeetCode: https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/

// Goal:
// Find the maximum profit with MULTIPLE transactions allowed.

// Example:
// prices = [7,1,5,3,6,4]
// Output = 7
// Explanation: Buy at 1, sell at 5 (profit 4), buy at 3, sell at 6 (profit 3). Total = 7.

// -------------------------------------------------------------

// Brute Force Approach:
// - Try all buy/sell combinations recursively.
// Time Complexity: O(2^n)
// Space Complexity: O(n)

// Better Approach (DP):
// - Track two states: hold (profit when holding stock), cash (profit when not holding).
// Time Complexity: O(n)
// Space Complexity: O(1)

// Optimal Approach (Greedy):
// - Add every positive difference prices[i] - prices[i-1].
// Time Complexity: O(n)
// Space Complexity: O(1)

import java.util.*;

class Solution {

    // Brute Force
    public int brute(int[] prices) {
        return dfs(prices, 0, false);
    }

    private int dfs(int[] prices, int i, boolean holding) {
        if (i == prices.length) return 0;
        int profit = dfs(prices, i + 1, holding);
        if (holding) {
            profit = Math.max(profit, prices[i] + dfs(prices, i + 1, false));
        } else {
            profit = Math.max(profit, -prices[i] + dfs(prices, i + 1, true));
        }
        return profit;
    }

    // Better Approach (DP)
    public int better(int[] prices) {
        int hold = -prices[0], cash = 0;
        for (int i = 1; i < prices.length; i++) {
            hold = Math.max(hold, cash - prices[i]);
            cash = Math.max(cash, hold + prices[i]);
        }
        return cash;
    }

    // Optimal Approach (Greedy)
    public int optimal(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                profit += prices[i] - prices[i - 1];
            }
        }
        return profit;
    }
}
