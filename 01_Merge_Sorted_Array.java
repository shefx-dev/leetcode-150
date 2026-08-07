// Problem: Merge Sorted Array
// LeetCode: https://leetcode.com/problems/merge-sorted-array/

// Brute Force Approach:
// - Copy nums2 into nums1
// - Sort the entire nums1 array
// Time Complexity: O((m+n) log (m+n))
// Space Complexity: O(1)

// Better Approach:
// - Use an extra array (like merge step in merge sort)
// - Merge nums1[0..m-1] and nums2[0..n-1] into temp[]
// - Copy temp[] back into nums1
// Time Complexity: O(m+n)
// Space Complexity: O(m+n)

// Optimal Approach:
// - Use three pointers from the END of nums1
// - Place the largest element at the end (nums1[k])
// - This avoids extra space and works in-place
// Time Complexity: O(m+n)
// Space Complexity: O(1)

import java.util.Arrays;

class Solution {

    // Brute Force
    public void brute(int[] nums1, int m, int[] nums2, int n) {
        // Copy nums2 into nums1
        for (int i = 0; i < n; i++) {
            nums1[m + i] = nums2[i];
        }
        // Sort the entire array
        Arrays.sort(nums1);
    }

    // Better Approach
    public void better(int[] nums1, int m, int[] nums2, int n) {
        int[] temp = new int[m + n];
        int i = 0, j = 0, k = 0;

        // Merge like merge-sort
        while (i < m && j < n) {
            if (nums1[i] < nums2[j]) {
                temp[k++] = nums1[i++];
            } else {
                temp[k++] = nums2[j++];
            }
        }

        // Remaining elements
        while (i < m) temp[k++] = nums1[i++];
        while (j < n) temp[k++] = nums2[j++];

        // Copy back to nums1
        System.arraycopy(temp, 0, nums1, 0, m + n);
    }

    // Optimal Approach
    public void optimal(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;        // pointer for nums1
        int j = n - 1;        // pointer for nums2
        int k = m + n - 1;    // pointer for final position in nums1

        // Merge from the end
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }

        // If nums2 still has elements
        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }
    }
}
