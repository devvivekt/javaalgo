package com.learning.java.algo.alldsa.sorting;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {
        BubbleSort bb = new BubbleSort();
        int[] arr = new int[]{2,5,4,10,50,30,16,4,7,29,20};
        System.out.println("arrBefore-->" + Arrays.toString(arr));
        bb.sort(arr);
        System.out.println("arrAfter-->" + Arrays.toString(arr));

    }

    public void sort(int[] arr){
        for(int i=0; i< arr.length; i++){
            for(int j=0; j< arr.length-i-1; j++){
                if(arr[j] > arr[j+1]){
                    swap(arr, j , j+1);
                }
                System.out.println("After first Inner Loop index j-->"+j+"-"+Arrays.toString(arr));

            }
            System.out.println("After first Outer Loop index I-->"+i+"-"+Arrays.toString(arr));
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
