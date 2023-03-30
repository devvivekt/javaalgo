package com.learning.java.algo.alldsa.recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Problem: Print all the valid combinations of n pairs of curly braces.
 * A valid combination is when the curly braces are properly opened and closed.
 * For n=3, the valid combinations are as follows:
 * {{{}}},{{}{}},{{}}{},{}{{}},{}{}{}
 */
public class CurlyBraces {

    public static List<String> braces(int countbr){
        if(countbr <= 0){
            return Collections.emptyList();
        }
        List<String> result = new ArrayList<>();
        braces(countbr, countbr,new char[countbr*2], 0, result);
        return  result;
    }

    public static void braces(int leftHand, int rightHand, char[] str, int index, List<String> result){
        if(rightHand < leftHand || leftHand < 0){
            return;
        }
        if(leftHand == 0 && rightHand ==0){
            result.add(String.valueOf(str));
        } else {
            //left brace
            str[index] = '{';
            braces(leftHand - 1, rightHand, str, index + 1, result);
            str[index] = '}';
            braces(leftHand, rightHand - 1, str, index + 1, result);
        }
    }

    public static void main(String[] args) {
        int count = 4;
        List<String> output = CurlyBraces.braces(count);
        System.out.println("result--->"+output);
    }

}
