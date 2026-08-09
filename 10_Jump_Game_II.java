// Problem: Jump Game II
// LeetCode: https://leetcode.com/problems/jump-game-ii/

// Goal:
// Find the minimum number of jumps to reach the last index.

// Example:
// nums = [2,3,1,1,4]
// Output = 2
// Explanation: Jump from index 0 to 1, then 1 to 4.

// -------------------------------------------------------------

// Brute Force Approach:
// - Try all possible paths recursively.
// - Track minimum jumps.
// Time Complexity: O(2^n)
// Space Complexity: O(n)

// Better Approach (Dynamic Programming):
// - dp[i] = minimum jumps to reach index i.
// - Transition: dp[i] = min(dp[j] + 1) for all j that can reach i.
// Time Complexity: O(n^2)
// Space Complexity: O(n)

// Optimal Approach (Greedy):
// - Track current range and farthest reach.
// - Each time you finish a range, increment jumps.
// - Stop when farthest covers last index.
// Time Complexity: O(n)
// Space Complexity: O(1)

class Solution {
    // Brute Force
    public int brute(int[] nums) {
        return dfs(nums, 0);
    }
    private int dfs(int[] nums, int pos) {
        if (pos >= nums.length - 1) return 0;
        int min = Integer.MAX_VALUE;
        for (int step = 1; step <= nums[pos]; step++) {
            min = Math.min(min, 1 + dfs(nums, pos + step));
        }
        return min;
    }

    // Better (DP)
    public int better(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= nums[i] && i + j < n; j++) {
                dp[i + j] = Math.min(dp[i + j], dp[i] + 1);
            }
        }
        return dp[n - 1];
    }

    // Optimal (Greedy)
    public int optimal(int[] nums) {
        int jumps = 0, currentEnd = 0, farthest = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            farthest = Math.max(farthest, i + nums[i]);
            if (i == currentEnd) {
                jumps++;
                currentEnd = farthest;
            }
        }
        return jumps;
    }
}
