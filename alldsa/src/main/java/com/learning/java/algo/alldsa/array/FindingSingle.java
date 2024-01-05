package com.learning.java.algo.alldsa.array;

import java.util.HashMap;
import java.util.Map;

/**
 * You do not need to read input or print anything.
 * Your task is to complete the function findSingle() which takes the
 * size of the array N and the array arr[] as input parameters and
 * returns the only single person.
 *
 *
 * Expected Time Complexity: O(N)
 * Expected Auxiliary Space: O(1)
 *
 *
 * Constraints:
 * 1 ≤ N ≤ 104
 * 1 ≤ arr[i] ≤ 106
 */
public class FindingSingle {

    static int findSingle(int N, int arr[]){
        // code here
        int result = 0;
        for(int i=0; i< N; i++){
            result ^= arr[i];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,3,2,1};
        int single = findSingle(arr.length,arr);
        System.out.println("single-->"+single);
    }

}
