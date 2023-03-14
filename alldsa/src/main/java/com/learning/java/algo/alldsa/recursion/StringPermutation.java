package com.learning.java.algo.alldsa.recursion;

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

    public static void main(String[] args){
        String str = "two";
        StringPermutation.simplePermutation(str);
    }
}
