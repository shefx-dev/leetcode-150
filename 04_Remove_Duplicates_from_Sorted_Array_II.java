// Problem: Remove Duplicates from Sorted Array II
// LeetCode: https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/

// Requirement:
// - Array is sorted
// - Each element can appear AT MOST twice
// - Modify array in-place and return new length

// Brute Force Approach:
// - Use a HashMap to count occurrences
// - Write elements only if count <= 2
// Time Complexity: O(n)
// Space Complexity: O(n)

// Better Approach:
// - Use a counter to track duplicates
// - If count > 2, skip writing
// - Otherwise write element
// Time Complexity: O(n)
// Space Complexity: O(1)

// Optimal Approach:
// - Use two pointers
// - Key trick: If nums[j-2] == current element → it's the 3rd duplicate → skip
// - Otherwise write it
// Time Complexity: O(n)
// Space Complexity: O(1)

import java.util.*;

class Solution {

    // Brute Force
    public int brute(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int k = 0;

        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);

            if (map.get(n) <= 2) {
                nums[k++] = n;
            }
        }
        return k;
    }

    // Better Approach (your count-based logic)
    public int better(int[] nums) {
        int j = 1;      // write pointer
        int count = 1;  // count occurrences

        for (int i = 1; i < nums.length; i++) {

            if (nums[i] == nums[i - 1]) {
                count++;
                if (count > 2) continue;  // skip 3rd+ duplicates
            } else {
                count = 1; // reset for new number
            }

            nums[j++] = nums[i];
        }

        return j;
    }

    // Optimal Approach (two-pointer trick)
    public int optimal(int[] nums) {
        int j = 0; // write pointer

        for (int n : nums) {
            // First two elements always allowed
            // If current element != element at j-2 → not a 3rd duplicate
            if (j < 2 || n != nums[j - 2]) {
                nums[j++] = n;
            }
        }

        return j;
    }
}
