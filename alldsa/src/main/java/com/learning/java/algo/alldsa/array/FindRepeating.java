package com.learning.java.algo.alldsa.array;

import java.util.HashMap;
import java.util.Map;

public class FindRepeating {

    public static void main(String[] args) {
        char[] arr = {'a', 'b', 'c' , 'f', 't', 'w', 'b', 'd', 'e', 'f'};
        System.out.println(findRepeatingChar(arr));
    }

    public static String findRepeatingChar(char[] arr){
        Map<Character, Integer> charFreq = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for(char x : arr){
            charFreq.put(x, charFreq.getOrDefault(x,0)+1);
            if(charFreq.get(x) == 2){
                sb.append(x);
            }
        }
        return sb.toString();
    }
}
