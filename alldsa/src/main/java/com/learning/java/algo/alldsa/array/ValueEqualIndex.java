package com.learning.java.algo.alldsa.array;

import java.util.ArrayList;
import java.util.List;

/*
Given an array Arr of N positive integers. Your task is to find the elements whose value
 is equal to that of its index value ( Consider 1-based indexing ).

Note: There can be more than one element in the array which have the same value as its index.
You need to include every such element's index.
Follows 1-based indexing of the array.

Your Task:
You don't need to read input or print anything. Your task is to complete the
function valueEqualToIndex() which takes the array of integers arr[] and n as
parameters and returns an array of indices where the given conditions are satisfied.
When there is no such element exists then return an empty array of length 0.

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)


Constraints:
1 ≤ N ≤ 105
1 ≤ Arr[i] ≤ 106
 */
public class ValueEqualIndex {

    static ArrayList<Integer> valueEqualToIndex(int arr[], int n) {
        // code here
        ArrayList<Integer> result = new ArrayList<>();

        for(int i=0; i<n; i++){
            if(arr[i] == i+1){
                result.add(arr[i]);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int arr[] = {};
        List val = valueEqualToIndex(arr,arr.length);
        System.out.println("value-->"+val);
    }
}
