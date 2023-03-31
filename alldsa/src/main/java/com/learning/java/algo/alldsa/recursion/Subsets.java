package com.learning.java.algo.alldsa.recursion;

import lombok.extern.log4j.Log4j2;
import org.springframework.util.StopWatch;

/**
 * Problem: Consider a given set (arr) of positive integers and a value, s.
 * Write a snippet of code that finds out if there
 * is a subset in this array whose sum is equal to the given s.
 * Solution: Let's consider the array, arr = {3, 2, 7, 4, 5, 1, 6, 7, 9}. If s=7,

 * The subset containing the elements 2, 4, and 1 is just one of the possible subsets.
 * All possible subsets include (3, 4), (2, 4, 1), (2, 5), (7), (1, 6), and (7).
 * Recursive approach
 * Let's try to find a solution via recursion. If we add the subset arr[0]=3,
 * then we have to find the subset for s = s-arr[0] = 7-3 = 4.
 * Finding a subset for s=4 is a sub-problem that can be solved based on the same logic,
 * which means we can add arr[1]=2 in the subset, and the next sub-problem will
 * consist of finding the subset for s = s-arr[1] = 4-2 = 2.
 * Alternatively, we can think like this: start with sum=0. We add arr[0]=3 to
 * this sum as sum=sum+arr[0] = 3. Next, we check if sum = s (for example, if 3 = 7).
 * If so, we found a subset. If not, we add the next element, arr[1]=2,
 * to the sum as sum = sum+arr[1] = 3+2 =5. We recursively continue to repeat this
 * process until there are no more elements to add. At this point, we recursively
 * remove elements from sum and check if sum = s upon each removal. In other words,
 * we build every possible subset and check if its sum is equal to s.
 * When we have this equality, we print the current subset.
 * For each element from arr we must make a decision. Mainly, we have two options:
 * include the current element in the subset or not include it. Starting from these statements,
 * we can create the following algorithm:
 * Define a subset as an array of the same length as the given arr.
 * This array takes only values of 1 and 0.
 * Recursively add each element from arr to the subset by setting a value
 * of 1 at that particular index. Check for the solution (current sum = given sum).
 * Recursively remove each element from the subset by setting a value of
 * 0 at that particular index. Check for the solution (current sum = given sum).
 */
@Log4j2
public class Subsets {


    //recursion
    public static void findSumRecursive(int[] arr, int idx, int currSum, int givenSum, int[] subset){

        if(arr == null || arr.length == 0
        || idx < 0 || currSum < 0 || givenSum < 0
        || subset == null || subset.length != arr.length){
            throw new IllegalArgumentException("the given argument(s) are wrong");
        }

        if(currSum == givenSum){
            for(int i=0 ; i< arr.length; i++){
                if(subset[i] == 1){
                    log.info(arr[i]+ " ");

                }
            }
            log.info("next subset................");
        } else if(idx != arr.length){
            subset[idx] = 1;
            currSum+= arr[idx];
            findSumRecursive(arr,idx+1,currSum,givenSum,subset);

            subset[idx] = 0;
            currSum-=arr[idx];
            findSumRecursive(arr,idx+1, currSum, givenSum, subset);
        }
    }

    //dynamic programming bottom up
    public static boolean findSumDP(int[] arr, int givenSum) {

        if (arr == null || arr.length == 0 || givenSum < 0) {
            throw new IllegalArgumentException("The given argument(s) are wrong");
        }

        boolean[][] matrix = new boolean[arr.length + 1][givenSum + 1];

        // prepare the first row
        for (int i = 1; i <= givenSum; i++) {
            matrix[0][i] = false;
        }

        // prepare the first column
        for (int i = 0; i <= arr.length; i++) {
            matrix[i][0] = true;
        }

        for (int i = 1; i <= arr.length; i++) {
            for (int j = 1; j <= givenSum; j++) {

                // first, copy the data from the above row
                matrix[i][j] = matrix[i - 1][j];

                // if matrix[i][j] == false compute if the value should be F or T
                if (matrix[i][j] == false && j >= arr[i - 1]) {
                    matrix[i][j] = matrix[i][j] || matrix[i - 1][j - arr[i - 1]];
                }
            }
        }

        printSubsetMatrix(arr, givenSum, matrix);
        printOneSubset(matrix, arr, arr.length, givenSum);

        return matrix[arr.length][givenSum];
    }

    private static void printSubsetMatrix(int[] arr, int givenSum, boolean matrix[][]) {

        System.out.println("\nSubset matrix for sum " + givenSum + ": ");
        System.out.print("\t");
        for (int j = 0; j <= givenSum; j++) {
            System.out.print(j + "\t");
        }
        System.out.println();

        for (int i = 0; i <= arr.length; i++) {
            System.out.print(i == 0 ? 0 + "\t" : arr[i - 1] + "\t");
            for (int j = 0; j <= givenSum; j++) {
                System.out.print(matrix[i][j] ? "T\t" : "F\t");
            }
            System.out.println();
        }
    }

    private static void printOneSubset(boolean[][] matrix, int[] arr, int row, int col) {

        int i = row;
        int j = col;

        System.out.println("\nSubset: ");
        while (i > 0 && j >= 0) {
            int value = arr[i - 1];
            if (j - value >= 0 && matrix[i - 1][j - value] && !matrix[i - 1][j]) {
                i = i - 1;
                j = j - value;
                System.out.print(value + " ");
            } else {
                i--;
            }
        }
    }

    public static void main(String[] args) {

        StopWatch watch = new StopWatch("fibonacci");
        watch.start("subsetRecursion");

        int[] arr = {5, 1, 6, 10, 7, 11, 2, 12,4,8};

        int[] subset = new int[arr.length];

        System.out.println("Recursive approach:");
        Subsets.findSumRecursive(arr, 0, 0, 9, subset);
        watch.stop();
        log.info("time taken for task {} is {}"
                ,watch.getLastTaskInfo().getTaskName()
                ,watch.getLastTaskInfo().getTimeNanos());

        watch.start("subsetDP");

        Subsets.findSumDP(arr , 9);

        watch.stop();
        log.info("time taken for task {} is {}"
                ,watch.getLastTaskInfo().getTaskName()
                ,watch.getLastTaskInfo().getTimeNanos());

    }

}
