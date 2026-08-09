// Problem: H-Index
// LeetCode: https://leetcode.com/problems/h-index/

// Goal:
// Find the largest h such that at least h papers have >= h citations.

// Example:
// citations = [3,0,6,1,5]
// Output = 3

// -------------------------------------------------------------

// Brute Force Approach:
// - Try all possible h values from 1 to n.
// - Count papers with >= h citations.
// Time Complexity: O(n^2)
// Space Complexity: O(1)

// Better Approach (Sorting):
// - Sort citations.
// - For each index i, check if citations[i] >= n - i.
// - Return largest valid h.
// Time Complexity: O(n log n)
// Space Complexity: O(1)

// Optimal Approach (Counting):
// - Bucket citations into count[0..n].
// - Traverse from high to low, accumulate papers.
// - First h where total >= h is answer.
// Time Complexity: O(n)
// Space Complexity: O(n)

class Solution {
    // Brute Force
    public int brute(int[] citations) {
        int n = citations.length, hIndex = 0;
        for (int h = 1; h <= n; h++) {
            int count = 0;
            for (int c : citations) if (c >= h) count++;
            if (count >= h) hIndex = h;
        }
        return hIndex;
    }

    // Better (Sorting)
    public int better(int[] citations) {
        Arrays.sort(citations);
        int n = citations.length;
        for (int i = 0; i < n; i++) {
            int h = n - i;
            if (citations[i] >= h) return h;
        }
        return 0;
    }

    // Optimal (Counting)
    public int optimal(int[] citations) {
        int n = citations.length;
        int[] count = new int[n + 1];
        for (int c : citations) {
            if (c >= n) count[n]++;
            else count[c]++;
        }
        int total = 0;
        for (int h = n; h >= 0; h--) {
            total += count[h];
            if (total >= h) return h;
        }
        return 0;
    }
}
