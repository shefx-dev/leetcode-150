// Problem: Remove Duplicates from Sorted Array
// LeetCode: https://leetcode.com/problems/remove-duplicates-from-sorted-array/

// Brute Force Approach:
// - Use a HashSet to store unique elements
// - Copy them back into nums
// Time Complexity: O(n)
// Space Complexity: O(n)

// Better Approach:
// - Traverse array and overwrite duplicates by shifting
// - Still linear but unnecessary shifting
// Time Complexity: O(n)
// Space Complexity: O(1)

// Optimal Approach:
// - Use two pointers
// - nums[k] holds the next unique element
// - Only write when nums[i] != nums[k-1]
// Time Complexity: O(n)
// Space Complexity: O(1)

import java.util.*;

class Solution {

    // Brute Force
    public int brute(int[] nums) {
        Set<Integer> set = new LinkedHashSet<>();

        // Collect unique elements
        for (int n : nums) {
            set.add(n);
        }

        // Copy back to nums
        int k = 0;
        for (int n : set) {
            nums[k++] = n;
        }

        return k;
    }

    // Better Approach
    public int better(int[] nums) {
        int k = 1; // write pointer

        for (int i = 1; i < nums.length; i++) {
            // If new unique element found
            if (nums[i] != nums[i - 1]) {
                nums[k++] = nums[i];
            }
        }

        return k;
    }

    // Optimal Approach (Two-pointer)
    public int optimal(int[] nums) {
        int k = 1; // write pointer

        for (int i = 1; i < nums.length; i++) {
            // Compare with last written unique element
            if (nums[i] != nums[k - 1]) {
                nums[k++] = nums[i];
            }
        }

        return k;
    }
}
