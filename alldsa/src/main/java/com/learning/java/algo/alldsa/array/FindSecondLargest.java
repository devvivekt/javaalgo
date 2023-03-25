package com.learning.java.algo.alldsa.array;

/**
 * Given an array Arr of size N, print second largest distinct element from an array.
 */
public class FindSecondLargest {

    static int print2largest(int arr[], int n) {
        // code here
        int largest = Integer.MIN_VALUE + 1;
        int secondLargest = Integer.MIN_VALUE;
        if(n<2){
            return -1;
        }
        for(int i =0 ; i< n ; i++){

            if(arr[i] < largest && arr[i] > secondLargest){
                secondLargest = arr[i];
            }

            if(arr[i] > largest){
                secondLargest = largest;
                largest = arr[i];
            }
            if(arr[i] == largest && secondLargest == Integer.MIN_VALUE+1){
                secondLargest = -1;
            }

        }
        return secondLargest;
    }

    public static void main(String[] args) {
        int arr[] = {30,40,20,10,90,60,90,60,40,50};
        System.out.println("secondLargest is "+print2largest(arr,arr.length));
    }
}
