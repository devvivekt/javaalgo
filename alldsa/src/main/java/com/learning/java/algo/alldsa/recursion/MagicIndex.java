package com.learning.java.algo.alldsa.recursion;

/**
 * Consider a sorted array of n elements that allows duplicates.
 * An index k is magic if array[k] = k.
 * Write a recursive algorithm that finds the first magic index.
 */
public class MagicIndex {

    public static int find(int[] arr){

        if(arr == null){
            return -1;
        }

        return find(arr, 0, arr.length-1);
    }

    private static int find(int[] arr,int startIdx,int endIdx){
        if(startIdx > endIdx){
            return -1;
        }
        int midIdx = (startIdx + endIdx)/2;
        int value = arr[midIdx];
        int leftIdx = find(arr , startIdx, Math.min(midIdx-1, value));
        if(leftIdx > 0){
            return leftIdx;
        }
        if(value == midIdx){
            return midIdx;
        }
        return find(arr , Math.max(midIdx+1,value), endIdx);
    }

    public static void main(String[] args){
        int[] arr = {1, 4, 4, 4,5, 5,6,6,6,11,12,12,12,15,17,20,21,21};
        int pos = find(arr);
        System.out.println(pos);
    }

}
