// Problem: Majority Element
// LeetCode: https://leetcode.com/problems/majority-element/

// Definition:
// Majority Element = element that appears more than n/2 times.

// Brute Force Approach:
// - Use a HashMap to count frequency of each element
// - Return the element whose count > n/2
// Time Complexity: O(n)
// Space Complexity: O(n)

// Better Approach:
// - Sort the array
// - The middle element (nums[n/2]) is always the majority element
// Time Complexity: O(n log n)
// Space Complexity: O(1)

// Optimal Approach (Boyer-Moore Voting Algorithm):
// - Maintain a candidate and a counter
// - Increase counter when same element appears
// - Decrease counter when different element appears
// - When counter becomes 0, choose new candidate
// - Final candidate is the majority element
// Time Complexity: O(n)
// Space Complexity: O(1)

import java.util.*;

class Solution {

    // Brute Force
    public int brute(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        // Count frequencies
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        // Find majority element
        for (int key : map.keySet()) {
            if (map.get(key) > nums.length / 2) {
                return key;
            }
        }

        return -1; // Should never happen for valid input
    }

    // Better Approach
    public int better(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    // Optimal Approach (Boyer-Moore Voting Algorithm)
    public int optimal(int[] nums) {
        int count = 0;
        int candidate = 0;

        for (int n : nums) {
            if (count == 0) {
                candidate = n;
            }
            count += (n == candidate) ? 1 : -1;
        }

        return candidate;
    }
}
