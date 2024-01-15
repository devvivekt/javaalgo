package com.learning.java.algo.alldsa.stringi;

import java.util.HashMap;
import java.util.Map;

public class Stringi {

    /**
     * https://leetcode.com/problems/determine-if-string-halves-are-alike/?envType=daily-question&envId=2024-01-12
     *
     * You are given a string s of even length. Split this string into two halves of equal lengths, and let a be the first half and b be the second half.
     *
     * Two strings are alike if they have the same number of vowels ('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'). Notice that s contains uppercase and lowercase letters.
     *
     * Return true if a and b are alike. Otherwise, return false.
     *
     *
     *
     * Example 1:
     *
     * Input: s = "book"
     * Output: true
     * Explanation: a = "bo" and b = "ok". a has 1 vowel and b has 1 vowel. Therefore, they are alike.
     * Example 2:
     *
     * Input: s = "textbook"
     * Output: false
     * Explanation: a = "text" and b = "book". a has 1 vowel whereas b has 2. Therefore, they are not alike.
     * Notice that the vowel o is counted twice.
     * @param s
     * @return
     */
    public boolean halvesAreAlike(String s) {
        int mid = s.length()/2;
        return countVowels(s.substring(0,mid)) == countVowels(s.substring(mid));
    }

    private int countVowels(String s){
        int countVowels = 0;
        Map<Character, Integer> mapVowels = new HashMap<>();
        mapVowels.put('a',1);
        mapVowels.put('e',1);
        mapVowels.put('i',1);
        mapVowels.put('o',1);
        mapVowels.put('u',1);
        mapVowels.put('A',1);
        mapVowels.put('E',1);
        mapVowels.put('I',1);
        mapVowels.put('O',1);
        mapVowels.put('U',1);
        for(int i=0; i< s.length(); i++){
            if(mapVowels.get(s.charAt(i)) != null){
                countVowels++;
            }
        }
        return countVowels;
    }

    //Best Solution
    public boolean halvesAreAlikes(String s) {

        int n = s.length();
        String s1 = s.substring(0,n/2);
        String s2 = s.substring(n/2);

        return countVowelss(s1) == countVowelss(s2);
    }
    private int countVowelss(String s)
    {
        int count=0;
        for(char c:s.toCharArray())
        {
            if(isVowel(c))
                count++;
        }
        return count;

    }
    private boolean isVowel(char c)
    {
        return "aeiouAEIOU".indexOf(c)!=-1;
    }

    public static void main(String[] args) {
        String s = "textbook";
        Stringi stringi = new Stringi();
        System.out.println(stringi.halvesAreAlike(s));
    }
}
