// Problem: Find the Index of the First Occurrence in a String
// LeetCode: https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/

// Goal:
// Return the index of the first occurrence of needle in haystack.
// If needle is not found, return -1.

// Example:
// haystack = "sadbutsad", needle = "sad"
// Output = 0

// -------------------------------------------------------------

// Brute Force:
// - Check every index and compare substring manually.
// Time Complexity: O(n * m)
// Space Complexity: O(1)

// Better Approach (Using substring):
// - Use built-in substring comparison.
// Time Complexity: O(n * m)
// Space Complexity: O(1)

// Optimal Approach (Two Pointer / Sliding Window):
// - Slide window of needle length across haystack.
// Time Complexity: O(n)
// Space Complexity: O(1)

class FindFirstOccurrence {

    // Brute Force
    public int brute(String haystack, String needle) {
        int n = haystack.length();
        int m = needle.length();

        for (int i = 0; i <= n - m; i++) {
            int j = 0;
            while (j < m && haystack.charAt(i + j) == needle.charAt(j)) {
                j++;
            }
            if (j == m) return i;
        }
        return -1;
    }

    // Better Approach
    public int better(String haystack, String needle) {
        int n = haystack.length();
        int m = needle.length();

        for (int i = 0; i <= n - m; i++) {
            if (haystack.substring(i, i + m).equals(needle)) {
                return i;
            }
        }
        return -1;
    }

    // Optimal Approach (Sliding Window)
    public int optimal(String haystack, String needle) {
        return haystack.indexOf(needle);
    }
}
