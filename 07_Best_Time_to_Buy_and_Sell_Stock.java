// Problem: Best Time to Buy and Sell Stock
// LeetCode: https://leetcode.com/problems/best-time-to-buy-and-sell-stock/

// Goal:
// Find the maximum profit from ONE buy and ONE sell.

// Example:
// prices = [7,1,5,3,6,4]
// Output = 5
// Explanation: Buy at 1, sell at 6, profit = 5.

// -------------------------------------------------------------

// Brute Force Approach:
// - Try all pairs (buy, sell).
// - Track max profit.
// Time Complexity: O(n^2)
// Space Complexity: O(1)

// Better Approach (Prefix Min):
// - Track minimum price so far.
// - At each step, compute profit = price - minPrice.
// Time Complexity: O(n)
// Space Complexity: O(1)

// Optimal Approach:
// - Same as better (this problem doesn’t need DP).
// - Just one pass with minPrice and maxProfit.
// Time Complexity: O(n)
// Space Complexity: O(1)

import java.util.*;

class Solution {

    // Brute Force
    public int brute(int[] prices) {
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                maxProfit = Math.max(maxProfit, prices[j] - prices[i]);
            }
        }
        return maxProfit;
    }

    // Better Approach
    public int better(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int price : prices) {
            minPrice = Math.min(minPrice, price);
            maxProfit = Math.max(maxProfit, price - minPrice);
        }
        return maxProfit;
    }

    // Optimal Approach (same as better)
    public int optimal(int[] prices) {
        return better(prices);
    }
}
