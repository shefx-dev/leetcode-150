// Problem: Palindrome Number : Check if an integer is a palindrome

// Brute Force Approach (String Conversion):
// - Convert integer to string
// - Reverse the string and compare with original
// - Time Complexity: O(n) where n = number of digits
// - Space Complexity: O(n) due to string storage

// Better Approach (Full Reverse Integer):
// - Reverse the entire integer mathematically
// - Compare reversed number with original
// - Watch out for negative numbers and overflow
// - Time Complexity: O(n)
// - Space Complexity: O(1)

// Optimal Approach (Half Reverse):
// - Reverse only half of the digits
// - Compare first half with reversed second half
// - Handles odd/even length numbers efficiently
// - Time Complexity: O(n)
// - Space Complexity: O(1)

class Solution {

    // Brute Force (String Conversion)
    public boolean bruteCheck(int x) {
        String s = String.valueOf(x);
        String rev = new StringBuilder(s).reverse().toString();
        return s.equals(rev);
    }

    // Better (Reverse Entire Integer)
    public boolean betterCheck(int x) {
        if (x < 0) return false;
        int original = x;
        long reversed = 0; // use long to avoid overflow
        while (x != 0) {
            int digit = x % 10;
            reversed = reversed * 10 + digit;
            x /= 10;
        }
        return reversed == original;
    }

    // Optimal (Reverse Half)
    public boolean optimalCheck(int x) {
        // Negative numbers and numbers ending with 0 (except 0 itself) are not palindromes
        if (x < 0 || (x % 10 == 0 && x != 0)) return false;

        int reversedHalf = 0;
        while (x > reversedHalf) {
            int digit = x % 10;
            reversedHalf = reversedHalf * 10 + digit;
            x /= 10;
        }

        // For even length numbers → x == reversedHalf
        // For odd length numbers → x == reversedHalf/10
        return (x == reversedHalf || x == reversedHalf / 10);
    }

    // Driver
    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.bruteCheck(121));   // true
        System.out.println(sol.bruteCheck(-121));  // false
        System.out.println(sol.bruteCheck(10));    // false

        System.out.println(sol.betterCheck(121));  // true
        System.out.println(sol.betterCheck(-121)); // false
        System.out.println(sol.betterCheck(10));   // false

        System.out.println(sol.optimalCheck(121));   // true
        System.out.println(sol.optimalCheck(-121));  // false
        System.out.println(sol.optimalCheck(10));    // false
        System.out.println(sol.optimalCheck(1221));  // true
    }
}
