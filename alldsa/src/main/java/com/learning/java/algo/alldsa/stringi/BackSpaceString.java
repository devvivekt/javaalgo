package com.learning.java.algo.alldsa.stringi;

import io.netty.util.internal.StringUtil;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

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

    public boolean backspaceCompareOpt(String s, String t) {
        int pointers = s.length()-1, pointert = t.length()-1;
        while(pointers >= 0 || pointert >= 0){
            if((pointers>=0 && s.charAt(pointers) =='#') || (pointert >=0 && t.charAt(pointert) == '#')){
                if (s.charAt(pointers) == '#') {
                    int backcounter = 2;
                    while (backcounter > 0){
                        pointers --;
                        backcounter --;
                        if(pointers == '#'){
                            backcounter += 2;
                        }
                    }
                }

                if (t.charAt(pointert) == '#') {
                    int backcounter = 2;
                    while (backcounter > 0){
                        pointert --;
                        backcounter --;
                        if(pointert == '#'){
                            backcounter += 2;
                        }
                    }
                }
            } else {
                if(pointers >= 0 && pointert >=0 && (( s.charAt(pointers)) != t.charAt(pointert))){
                    return false;
                } else{
                    pointers--;
                    pointert--;
                }
            }
        }
        return true;
    }


    private String backify(String input){
        StringBuilder sb = new StringBuilder();
        for(int i= 0 ; i < input.length() ; i++){
            if(input.charAt(i) != '#'){
                sb.append(input.charAt(i));
            } else{
                if(sb.length() >= 1) {
                    sb.deleteCharAt(sb.length() - 1);
                }
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
        System.out.println("comparision::::"+backSpaceString.backspaceCompareOpt(input1, input2));
        ;
        input1 = "xywrrmp";
        input2 = "xywrrmu#p";
        comp = backSpaceString.backspaceCompare(input1, input2);
        System.out.println("comparision xywrrmp::::"+comp);
        System.out.println("comparision::::"+backSpaceString.backspaceCompareOpt(input1, input2));
        input1 = "ab##";
        input2 = "c#d#";
        comp = backSpaceString.backspaceCompare(input1, input2);
        System.out.println("comparision ab##::::"+comp);
        System.out.println("comparision::::"+backSpaceString.backspaceCompareOpt(input1, input2));
    }
}
