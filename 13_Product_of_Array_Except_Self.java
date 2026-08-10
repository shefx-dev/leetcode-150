// Problem: Product of Array Except Self
// LeetCode: https://leetcode.com/problems/product-of-array-except-self/

// Goal:
// Return an array where each element is the product of all other elements except itself.
// No division allowed.

// Example:
// nums = [1,2,3,4]
// Output = [24,12,8,6]

// -------------------------------------------------------------

// Brute Force Approach:
// - For each index, multiply all other elements.
// Time Complexity: O(n^2)
// Space Complexity: O(n)

// Better Approach (Prefix + Suffix):
// - Build prefix and suffix arrays.
// Time Complexity: O(n)
// Space Complexity: O(n)

// Optimal Approach (Greedy Prefix + Suffix in one pass):
// - Use output array as prefix storage.
// - Multiply suffix on the fly.
// Time Complexity: O(n)
// Space Complexity: O(1)

import java.util.*;

class ProductOfArrayExceptSelf {

    // Brute Force
    public int[] brute(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            int prod = 1;
            for (int j = 0; j < n; j++) {
                if (i != j) prod *= nums[j];
            }
            result[i] = prod;
        }
        return result;
    }

    // Better Approach (Prefix + Suffix)
    public int[] better(int[] nums) {
        int n = nums.length;
        int[] prefix = new int[n];
        int[] suffix = new int[n];
        int[] result = new int[n];

        prefix[0] = 1;
        for (int i = 1; i < n; i++)
            prefix[i] = prefix[i - 1] * nums[i - 1];

        suffix[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--)
            suffix[i] = suffix[i + 1] * nums[i + 1];

        for (int i = 0; i < n; i++)
            result[i] = prefix[i] * suffix[i];

        return result;
    }

    // Optimal Approach (O(1) extra space)
    public int[] optimal(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        // Prefix
        result[0] = 1;
        for (int i = 1; i < n; i++)
            result[i] = result[i - 1] * nums[i - 1];

        // Suffix
        int suffix = 1;
        for (int i = n - 1; i >= 0; i--) {
            result[i] *= suffix;
            suffix *= nums[i];
        }

        return result;
    }
}
