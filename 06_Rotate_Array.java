// Problem: Rotate Array
// LeetCode: https://leetcode.com/problems/rotate-array/

// Goal:
// Rotate the array to the RIGHT by k steps.

// Example:
// nums = [1,2,3,4,5,6,7], k = 3
// Output = [5,6,7,1,2,3,4]

// -------------------------------------------------------------

// Brute Force Approach:
// - Rotate the array one step at a time
// - Repeat k times
// - Each rotation is O(n)
// Time Complexity: O(n * k)
// Space Complexity: O(1)

// Better Approach:
// - Use an extra array
// - Place each element at its rotated position
// - Copy back to nums
// Time Complexity: O(n)
// Space Complexity: O(n)

// Optimal Approach:
// - Reverse the entire array
// - Reverse first k elements
// - Reverse remaining n-k elements
// Time Complexity: O(n)
// Space Complexity: O(1)

import java.util.*;

class Solution {

    // Brute Force (rotate one step at a time)
    public void brute(int[] nums, int k) {
        int n = nums.length;
        k = k % n; // handle large k

        while (k-- > 0) {
            int last = nums[n - 1];
            for (int i = n - 1; i > 0; i--) {
                nums[i] = nums[i - 1];
            }
            nums[0] = last;
        }
    }

    // Better Approach (extra array)
    public void better(int[] nums, int k) {
        int n = nums.length;
        k = k % n;

        int[] temp = new int[n];

        for (int i = 0; i < n; i++) {
            temp[(i + k) % n] = nums[i];
        }

        System.arraycopy(temp, 0, nums, 0, n);
    }

    // Optimal Approach (reverse method)
    public void optimal(int[] nums, int k) {
        int n = nums.length;
        k = k % n;

        // Step 1: Reverse entire array
        reverse(nums, 0, n - 1);

        // Step 2: Reverse first k elements
        reverse(nums, 0, k - 1);

        // Step 3: Reverse remaining elements
        reverse(nums, k, n - 1);
    }

    // Helper function to reverse array
    private void reverse(int[] nums, int left, int right) {
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }
}
