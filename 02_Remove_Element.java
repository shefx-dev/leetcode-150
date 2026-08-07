// Problem: Remove Element
// LeetCode: https://leetcode.com/problems/remove-element/

// Brute Force Approach:
// - Create a temporary array
// - Copy all elements that are NOT equal to val
// - Copy temp back into nums
// Time Complexity: O(n)
// Space Complexity: O(n)

// Better Approach:
// - Shift elements left whenever nums[i] == val
// - This may cause repeated shifting (worst O(n²))
// Time Complexity: O(n²)
// Space Complexity: O(1)

// Optimal Approach:
// - Use a write pointer (k)
// - Overwrite nums[k] with elements != val
// - Return k (new length)
// Time Complexity: O(n)
// Space Complexity: O(1)

import java.util.*;

class Solution {

    // Brute Force
    public int brute(int[] nums, int val) {
        int[] temp = new int[nums.length];
        int k = 0;

        // Copy only elements != val
        for (int n : nums) {
            if (n != val) {
                temp[k++] = n;
            }
        }

        // Copy back to nums
        System.arraycopy(temp, 0, nums, 0, k);
        return k;
    }

    // Better Approach (shifting)
    public int better(int[] nums, int val) {
        int k = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[k++] = nums[i];
            }
        }

        return k;
    }

    // Optimal Approach (two-pointer overwrite)
    public int optimal(int[] nums, int val) {
        int k = 0;

        for (int n : nums) {
            if (n != val) {
                nums[k++] = n;
            }
        }

        return k;
    }
}
