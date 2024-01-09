package com.learning.java.algo.alldsa.stringi;

/**
 * https://leetcode.com/problems/backspace-string-compare/
 *
 * Given two strings s and t, return true if they are equal when both are typed into empty text editors. '#' means a backspace character.
 *
 * Note that after backspacing an empty text, the text will continue empty.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "ab#c", t = "ad#c"
 * Output: true
 * Explanation: Both s and t become "ac".
 * Example 2:
 *
 * Input: s = "ab##", t = "c#d#"
 * Output: true
 * Explanation: Both s and t become "".
 * Example 3:
 *
 * Input: s = "a#c", t = "b"
 * Output: false
 * Explanation: s becomes "c" while t becomes "b".
 *
 *
 * Constraints:
 *
 * 1 <= s.length, t.length <= 200
 * s and t only contain lowercase letters and '#' characters.
 * Follow up: Can you solve it in O(n) time and O(1) space?
 */
public class BackSpaceString {

    public boolean backspaceCompare(String s, String t) {
        String input1 = backify(s);
        String input2 = backify(t);
        return input2.equals(input1);
    }

    private String backify(String input){
        StringBuilder sb = new StringBuilder();
        char prevChar = '%';
        for(int i= input.length()-1 ; i >=0 ; i--){
            if(input.charAt(i) == '#'){
                prevChar = '#';
            }
            if(prevChar == '#'){
                prevChar = '%';
            }else {
                sb.append(input.charAt(i));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {

        String input1 = "ab#c";
        String input2 = "ad#c";
        BackSpaceString backSpaceString = new BackSpaceString();
        boolean comp = backSpaceString.backspaceCompare(input1, input2);
        System.out.println("comparision::::"+comp);
        input1 = "xywrrmp";
        input2 = "xywrrmu#p";
        comp = backSpaceString.backspaceCompare(input1, input2);
        System.out.println("comparision xywrrmp::::"+comp);
    }
}
