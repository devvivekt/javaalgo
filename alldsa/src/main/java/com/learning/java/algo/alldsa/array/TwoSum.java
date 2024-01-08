package com.learning.java.algo.alldsa.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
Given an array of integers nums and an integer target,
return indices of the two numbers such that they add up to target.
You may assume that each input would have exactly one solution,
and you may not use the same element twice.
You can return the answer in any order.
 */
public class TwoSum {


    //T O(n^2)  S O(1)
    public int[] getSumBruteForce(int[] arr, int sum){
        for(int i=0 ; i< arr.length; i++){
            for(int j = i+1; j< arr.length ; j++){
                if(sum - arr[i] == arr[j]){
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    //T O(n)  S O(n)
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer val = map.get(target - nums[i]);
            if (val == null) {
                map.put(nums[i], i);
            } else {
                return new int[]{map.get(target - nums[i]), i};
            }
        }
        return null;
    }

        public static void main(String[] args) {
        int[] arr = {2,5,6,4,3,9};
        TwoSum twoSum = new TwoSum();
        int[] res = twoSum.getSumBruteForce(arr, 12);
        System.out.println("result::"+ Arrays.toString(res));

        int[] arr2 = {2};
        int[] res2 = twoSum.getSumBruteForce(arr2, 12);
        System.out.println("result2::"+ Arrays.toString(res2));

        int[] resop = twoSum.twoSum(arr, 12);
        System.out.println("result::"+ Arrays.toString(resop));
    }


}
