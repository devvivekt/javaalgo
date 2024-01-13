package com.learning.java.algo.alldsa.stringi;

/**
 * https://leetcode.com/problems/valid-palindrome/description/
 *
 * A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.
 *
 * Given a string s, return true if it is a palindrome, or false otherwise.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "A man, a plan, a canal: Panama"
 * Output: true
 * Explanation: "amanaplanacanalpanama" is a palindrome.
 * Example 2:
 *
 * Input: s = "race a car"
 * Output: false
 * Explanation: "raceacar" is not a palindrome.
 * Example 3:
 *
 * Input: s = " "
 * Output: true
 * Explanation: s is an empty string "" after removing non-alphanumeric characters.
 * Since an empty string reads the same forward and backward, it is a palindrome.
 */
public class ValidPalindrome {

    public boolean isPalindrome(String s) {
        s = s.replaceAll("[^A-Za-z0-9/g]","").toLowerCase();
        int left = 0;
        int right = s.length()-1;
        while (left < right){
            if(s.charAt(left) != s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    /**
     * https://leetcode.com/problems/valid-palindrome-ii/
     *
     * Given a string s, return true if the s can be palindrome after deleting at most one character from it.
     *
     *
     *
     * Example 1:
     *
     * Input: s = "aba"
     * Output: true
     * Example 2:
     *
     * Input: s = "abca"
     * Output: true
     * Explanation: You could delete the character 'c'.
     * Example 3:
     *
     * Input: s = "abc"
     * Output: false
     *
     *
     * Constraints:
     *
     * 1 <= s.length <= 105
     * s consists of lowercase English letters.
     * @param s
     * @return
     */
    public boolean validPalindrome(String s) {
        int left = 0;
        int right = s.length()-1;
        while (left < right){
            if(s.charAt(left) != s.charAt(right)){
                return compareShift(s, left+1, right) || compareShift(s, left, right-1);
            }
            left++;
            right--;
        }
        return true;
    }

    private boolean compareShift(String s, int leftIdx, int rightIdx){
        while (leftIdx < rightIdx){
            if(s.charAt(leftIdx) != s.charAt(rightIdx)){
                return false;
            }
            leftIdx++;
            rightIdx--;
        }
        return true;
    }

    public static void main(String[] args) {
        String input = "A man, a plan, a canal: Panama";
        ValidPalindrome validPalindrome = new ValidPalindrome();
        System.out.println(validPalindrome.isPalindrome(input));
        input = "abca";
        System.out.println(validPalindrome.validPalindrome(input));
        input = "cbbcc";
        System.out.println(validPalindrome.validPalindrome(input));

    }

}
