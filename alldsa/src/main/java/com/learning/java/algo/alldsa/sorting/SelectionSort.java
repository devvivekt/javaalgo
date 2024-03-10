package com.learning.java.algo.alldsa.sorting;

import java.util.Arrays;

public class SelectionSort {

    public static void main(String[] args) {
        SelectionSort bb = new SelectionSort();
        int[] arr = new int[]{15,5,4,10,50,30,16,4,7,2,29,20};
        System.out.println("arrBefore-->" + Arrays.toString(arr));
        bb.sort(arr);
        System.out.println("arrAfter-->" + Arrays.toString(arr));

    }

    public void sort(int[] arr){
        for(int i=0; i< arr.length; i++){
            int minPlaceHolder = i;
            for(int j=i; j< arr.length; j++){
                if(arr[j] < arr[minPlaceHolder]){
                    minPlaceHolder = j;
                }
                System.out.println("After first Inner Loop index j-->"+j+"-"+Arrays.toString(arr));
            }
            swap(arr,i, minPlaceHolder);
            System.out.println("After first Outer Loop index I-->"+i+"-"+Arrays.toString(arr));
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
