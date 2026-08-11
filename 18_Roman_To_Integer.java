// Problem: Roman to Integer
// LeetCode: https://leetcode.com/problems/roman-to-integer/

// Goal:
// Convert Roman numeral to integer.

// Example:
// Input: "MCMXCIV"
// Output: 1994

// -------------------------------------------------------------

// Brute Force:
// - Convert each char, handle subtractive cases manually.
// Time Complexity: O(n)
// Space Complexity: O(1)

// Better Approach (HashMap):
// - Use map for values, check next char.
// Time Complexity: O(n)
// Space Complexity: O(1)

// Optimal Approach (Right-to-left):
// - Traverse from right, subtract if curr < prev.
// Time Complexity: O(n)
// Space Complexity: O(1)

import java.util.*;

class RomanToInteger {

    // Brute Force
    public int brute(String s) {
        int sum = 0;

        for (int i = 0; i < s.length(); i++) {
            int curr = value(s.charAt(i));

            if (i + 1 < s.length()) {
                int next = value(s.charAt(i + 1));
                if (curr < next) {
                    sum += next - curr;
                    i++;
                    continue;
                }
            }
            sum += curr;
        }
        return sum;
    }

    // Better Approach (HashMap)
    public int better(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1); map.put('V', 5); map.put('X', 10);
        map.put('L', 50); map.put('C', 100); map.put('D', 500);
        map.put('M', 1000);

        int sum = 0;

        for (int i = 0; i < s.length(); i++) {
            int curr = map.get(s.charAt(i));

            if (i + 1 < s.length() && curr < map.get(s.charAt(i + 1))) {
                sum += map.get(s.charAt(i + 1)) - curr;
                i++;
            } else {
                sum += curr;
            }
        }
        return sum;
    }

    // Optimal Approach (Right-to-left)
    public int optimal(String s) {
        int sum = 0;
        int prev = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            int curr = value(s.charAt(i));

            if (curr < prev) sum -= curr;
            else sum += curr;

            prev = curr;
        }
        return sum;
    }

    private int value(char c) {
        switch (c) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            default: return 1000; // M
        }
    }
}
