// Problem: Length of Last Word
// LeetCode: https://leetcode.com/problems/length-of-last-word/

// Goal:
// Return the length of the last word in a string.

// Example:
// s = "Hello World"
// Output = 5

// -------------------------------------------------------------

// Brute Force Approach:
// - Trim and split the string.
// Time Complexity: O(n)
// Space Complexity: O(n)

// Better Approach:
// - Trim and count characters from end.
// Time Complexity: O(n)
// Space Complexity: O(1)

// Optimal Approach:
// - Skip trailing spaces, count last word.
// Time Complexity: O(n)
// Space Complexity: O(1)

class LengthOfLastWord {

    // Brute Force
    public int brute(String s) {
        String[] parts = s.trim().split(" ");
        return parts[parts.length - 1].length();
    }

    // Better Approach
    public int better(String s) {
        s = s.trim();
        int count = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') break;
            count++;
        }
        return count;
    }

    // Optimal Approach
    public int optimal(String s) {
        int count = 0;
        int i = s.length() - 1;

        // Skip trailing spaces
        while (i >= 0 && s.charAt(i) == ' ') i--;

        // Count last word
        while (i >= 0 && s.charAt(i) != ' ') {
            count++;
            i--;
        }

        return count;
    }
}
