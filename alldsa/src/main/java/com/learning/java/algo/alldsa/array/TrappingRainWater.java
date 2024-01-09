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

    /**
     * /*
     * 1. Identify the pointer with the lesser value
     * 2. Is this pointer value greater than or equal to max on that side
     *   yes -> update max on that side
     *   no -> get water for pointer, add to total
     * 3. move pointer inwards
     * 4. repeat for other pointer
     *  */
    public int trap(int[] height) {
        int left = 0, right = height.length -1, totalWater = 0, maxLeft = 0, maxRight = 0;
        while(left < right){
            if(height[left] <= height[right]){
                if(height[left] >= maxLeft){
                    maxLeft = height[left];
                } else{
                    totalWater+= maxLeft - height[left];
                }
                left ++;
            } else{
                if(height[right] >= maxRight){
                    maxRight = height[right];
                } else {
                    totalWater+= maxRight - height[right];
                }
                right --;
            }
        }
        return totalWater;
    }


    public static void main(String[] args) {
        int[] elevationArray = {0, 1, 0, 2, 1, 0, 3, 1, 0, 1, 2};
        TrappingRainWater trappingRainWater = new TrappingRainWater();
        int areaTrapped = trappingRainWater.trapBrut(elevationArray);
        System.out.println("area:::::::"+areaTrapped);
        System.out.println("areaoptimized"+trappingRainWater.trap(elevationArray));
    }
}
