package com.learning.java.algo.alldsa.searching;

public class BinarySearch {

    static int binarysearch(int arr[], int n, int k) {
        // code here
        return find(arr,0, arr.length-1,k);
    }

    static int find(int arr[], int startIdx, int endIdx, int k){
        if(startIdx > endIdx){
            return -1;
        }
        int midIdx = (startIdx + endIdx)/2;
        int val = arr[midIdx];
        if(val == k){
            return midIdx;
        }
        if( val > k){
            return find(arr, startIdx, midIdx, k);
        }
        if(val < k){
            return find(arr, midIdx, endIdx, k);
        }
        return -1;
    }

    public static void main(String[] args){
        int[] arr = {1, 4 ,5,6,11,12,15,17,20,21};
        int pos = binarysearch(arr, arr.length, 11);
        System.out.println(pos);
    }

}
