// Problem: Longest Common Prefix
// LeetCode: https://leetcode.com/problems/longest-common-prefix/

// Goal:
// Return the longest common prefix among all strings.

// Example:
// strs = ["flower","flow","flight"]
// Output = "fl"

// -------------------------------------------------------------

// Brute Force Approach:
// - Reduce prefix until all strings start with it.
// Time Complexity: O(n * m)
// Space Complexity: O(1)

// Better Approach (Vertical Scanning):
// - Compare characters column-wise.
// Time Complexity: O(n * m)
// Space Complexity: O(1)

// Optimal Approach (Sort + Compare first & last):
// - Sort array, compare first and last strings.
// Time Complexity: O(n log n)
// Space Complexity: O(1)

import java.util.*;

class LongestCommonPrefix {

    // Brute Force
    public String brute(String[] strs) {
        if (strs.length == 0) return "";

        String prefix = strs[0];

        for (int i = 1; i < strs.length; i++) {
            while (!strs[i].startsWith(prefix)) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        }
        return prefix;
    }

    // Better Approach (Vertical Scanning)
    public String better(String[] strs) {
        if (strs.length == 0) return "";

        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);

            for (int j = 1; j < strs.length; j++) {
                if (i >= strs[j].length() || strs[j].charAt(i) != c)
                    return strs[0].substring(0, i);
            }
        }
        return strs[0];
    }

    // Optimal Approach (Sort + Compare)
    public String optimal(String[] strs) {
        if (strs.length == 0) return "";

        Arrays.sort(strs);
        String first = strs[0];
        String last = strs[strs.length - 1];

        int i = 0;
        while (i < first.length() && i < last.length() &&
               first.charAt(i) == last.charAt(i)) {
            i++;
        }

        return first.substring(0, i);
    }
}
