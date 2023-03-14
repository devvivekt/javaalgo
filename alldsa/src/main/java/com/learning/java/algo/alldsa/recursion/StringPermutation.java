package com.learning.java.algo.alldsa.recursion;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

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


    public static List<String> nodupPermutation(String str){
        if(str == null || str.isBlank()){
            return Collections.emptyList();
        }
        return nodupPermutation("", str.length(),charactersMap(str));
    }

    public static List<String> nodupPermutation(String prefix, int strLen
            , Map<Character, Long> characters){
        List<String> permutations = new ArrayList<>();
        if(strLen == 0){
            permutations.add(prefix);
        }else{
            for(Character c : characters.keySet()){
                int count = characters.get(c).intValue();
                if(count > 0){
                    characters.put(c, Long.valueOf(count-1));
                    permutations.addAll(nodupPermutation(prefix+ c
                            , strLen-1, characters));
                    characters.put(c, Long.valueOf(count));
                }

            }
        }
        return permutations;
    }

    public static Map<Character, Long> charactersMap(String str){
        Map<Character, Long> charMap = Collections.singletonList(str).stream().flatMap(a -> a.chars().mapToObj(c -> (char) c)) // Stream<Character>
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        return charMap;
    }


    public static void main(String[] args){
        String str = "two";
        StringPermutation.simplePermutation(str);
        str = "hellohowru";
        StringPermutation.dupPermutation(str);
    }
}
