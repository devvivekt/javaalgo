package com.learning.java.algo.alldsa.array;

/****
 *
 * https://leetcode.com/problems/trapping-rain-water/
 *
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.
 *
 * Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * Output: 6
 * Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
 */
public class TrappingRainWater {

    public int trapBrut(int[] height) {
        int totalWater = 0;
        for(int i = 0 ; i < height.length ; i++){
            int lefP = i, rightP = i, maxLeft = -1, maxRight = -1;
            while (lefP >= 0){
                maxLeft = Math.max(maxLeft, height[lefP]);
                lefP--;
            }
            while (rightP < height.length){
                maxRight = Math.max(maxRight, height[rightP]);
                rightP++;
            }
            int currWater = Math.min(maxLeft, maxRight) -height[i];
            if(currWater > 0){
                totalWater+=currWater;
            }
        }
        return totalWater;
    }

    public static void main(String[] args) {
        int[] elevationArray = {0, 1, 0, 2, 1, 0, 3, 1, 0, 1, 2};
        TrappingRainWater trappingRainWater = new TrappingRainWater();
        int areaTrapped = trappingRainWater.trapBrut(elevationArray);
        System.out.println("area:::::::"+areaTrapped);
    }
}
