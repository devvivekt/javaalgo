package com.learning.java.algo.alldsa.recursion;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class StringPermutation {

    public static void simplePermutation(String str){
        if(str == null || str.isBlank()){
            return;
        }
        simplePermutation("", str);
    }

    public static void simplePermutation(String prefix, String str){
        int n = str.length();
        if(n == 0){
            System.out.println(prefix+" ");
        }else{
            for(int i=0; i< str.length(); i++){
                simplePermutation(prefix+ str.charAt(i)
                        , str.substring(i+1,n) + str.substring(0,i));
            }
        }
    }

    public static Set<String> dupPermutation(String str){
        if(str == null || str.isBlank()){
            return Collections.emptySet();
        }
        return dupPermutation("", str);
    }

    public static Set<String> dupPermutation(String prefix, String str){
        Set<String> permutations = new HashSet<>();
        int n = str.length();
        if(n == 0){
            permutations.add(prefix);
        }else{
            for(int i=0; i< str.length(); i++){
                permutations.addAll(dupPermutation(prefix+ str.charAt(i)
                        , str.substring(i+1,n) + str.substring(0,i)));
            }
        }
        return permutations;
    }


    public static void main(String[] args){
        String str = "two";
        StringPermutation.simplePermutation(str);
        str = "hellohowru"
        StringPermutation.dupPermutation(str);
    }
}
