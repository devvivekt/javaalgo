package com.learning.java.algo.alldsa.array;

/**
 * You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
 *
 * Find two lines that together with the x-axis form a container, such that the container contains the most water.
 *
 * Return the maximum amount of water a container can store.
 *
 * Notice that you may not slant the container.
 *
 * Input: height = [1,8,6,2,5,4,8,3,7]
 * Output: 49
 * Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.
 *
 * Constraints:
 *
 * n == height.length
 * 2 <= n <= 105
 * 0 <= height[i] <= 104
 */
public class MaxAreaContainer {

    public int maxArea(int[] height) {
        int start = 0;
        int end = height.length-1;
        int maxArea = 0;
        while(start < end) {
            maxArea = Math.max(Math.min(height[start], height[end])*(end-start), maxArea);
            if(height[start] > height[end]){
                end --;
            } else {
                start++;
            }
        }
        return  maxArea;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {1,8,6,2,5,4,8,3,7};
        MaxAreaContainer maxAreaContainer = new MaxAreaContainer();
        int maxArea = maxAreaContainer.maxArea(arr);

        System.out.println("maxArea :::"+ maxArea);

        arr = new int[] {2,3,4,5,18,17,6};
        maxArea = maxAreaContainer.maxArea(arr);

        System.out.println("maxArea second :::"+ maxArea);
    }
}
