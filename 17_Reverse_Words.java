// Problem: Reverse Words in a String
// LeetCode: https://leetcode.com/problems/reverse-words-in-a-string/

// Goal:
// Reverse the order of words in a string.
// Remove extra spaces.

// Example:
// Input: "  hello   world  "
// Output: "world hello"

// -------------------------------------------------------------

// Brute Force:
// - Split by spaces, filter empty, reverse list.
// Time Complexity: O(n)
// Space Complexity: O(n)

// Better Approach (Trim + Split):
// - Use regex split and reverse.
// Time Complexity: O(n)
// Space Complexity: O(n)

// Optimal Approach (Manual Scan):
// - Traverse from right to left, build words manually.
// Time Complexity: O(n)
// Space Complexity: O(n)

import java.util.*;

class ReverseWords {

    // Brute Force
    public String brute(String s) {
        String[] parts = s.split(" ");
        List<String> words = new ArrayList<>();

        for (String p : parts) {
            if (!p.isEmpty()) words.add(p);
        }

        Collections.reverse(words);
        return String.join(" ", words);
    }

    // Better Approach
    public String better(String s) {
        s = s.trim();
        String[] arr = s.split("\\s+");

        int left = 0, right = arr.length - 1;
        while (left < right) {
            String temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }

        return String.join(" ", arr);
    }

    // Optimal Approach
    public String optimal(String s) {
        StringBuilder result = new StringBuilder();
        int i = s.length() - 1;

        while (i >= 0) {
            while (i >= 0 && s.charAt(i) == ' ') i--;
            if (i < 0) break;

            int end = i;
            while (i >= 0 && s.charAt(i) != ' ') i--;
            int start = i + 1;

            result.append(s.substring(start, end + 1)).append(" ");
        }

        return result.toString().trim();
    }
}
