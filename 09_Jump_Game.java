// Problem: Jump Game
// LeetCode: https://leetcode.com/problems/jump-game/

// Goal:
// Determine if you can reach the last index starting from the first index.

// Example:
// nums = [2,3,1,1,4]
// Output = true
// Explanation: Jump 1 step to index 1, then 3 steps to last index.

// -------------------------------------------------------------

// Brute Force Approach:
// - Try all possible jumps recursively.
// Time Complexity: O(2^n)
// Space Complexity: O(n)

// Better Approach (DP with memoization):
// - Cache states: GOOD (can reach end), BAD (cannot), UNKNOWN.
// Time Complexity: O(n^2)
// Space Complexity: O(n)

// Optimal Approach (Greedy):
// - Track farthest index reachable.
// - If current index > farthest, return false.
// - If farthest >= last index, return true.
// Time Complexity: O(n)
// Space Complexity: O(1)

import java.util.*;

class Solution {

    // Brute Force
    public boolean brute(int[] nums) {
        return canReach(nums, 0);
    }

    private boolean canReach(int[] nums, int pos) {
        if (pos >= nums.length - 1) return true;
        int maxJump = nums[pos];
        for (int step = 1; step <= maxJump; step++) {
            if (canReach(nums, pos + step)) return true;
        }
        return false;
    }

    // Better Approach (DP with memoization)
    enum State { GOOD, BAD, UNKNOWN }

    public boolean better(int[] nums) {
        State[] memo = new State[nums.length];
        Arrays.fill(memo, State.UNKNOWN);
        memo[nums.length - 1] = State.GOOD;
        return canReachMemo(nums, 0, memo);
    }

    private boolean canReachMemo(int[] nums, int pos, State[] memo) {
        if (memo[pos] != State.UNKNOWN) return memo[pos] == State.GOOD;
        int furthest = Math.min(pos + nums[pos], nums.length - 1);
        for (int next = pos + 1; next <= furthest; next++) {
            if (canReachMemo(nums, next, memo)) {
                memo[pos] = State.GOOD;
                return true;
            }
        }
        memo[pos] = State.BAD;
        return false;
    }

    // Optimal Approach (Greedy)
    public boolean optimal(int[] nums) {
        int farthest = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > farthest) return false;
            farthest = Math.max(farthest, i + nums[i]);
        }
        return true;
    }
}
