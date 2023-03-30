package com.learning.java.algo.alldsa.recursion;

/**
 * A person walks up a staircase. They can hop either one step, two steps, or three steps at a time.
 * Count the number of possible ways they can reach the top of the staircase.
 * By going one step further in our logic, we may ask ourselves how to reach step n.
 * Mainly, the nth step can be reached if we do the following:
 * n-1 step and hop 1 step
 * n-2 step and hop 2 steps
 * n-3 step and hop 3 steps
 */
public class StairCase {

    public static int count ( int n){

        if(n == 0){
            return 1;
        }else if(n < 0){
            return 0;
        }
        return count(n-1) + count(n-2) + count(n -3);
    }

    public static int countviaMemo(int n){
        int cache[] = new int[n+1];
        return countMemo(n, cache);
    }
    public static int countMemo ( int n, int[] cache){

        if(n == 0){
            return 1;
        }else if(n < 0){
            return 0;
        }

        cache[n] =  countMemo(n-1,cache) + countMemo(n-2,cache) + countMemo(n -3,cache);
        return cache[n];
    }

    public static void main(String[] args) {
        int count = StairCase.count(10);
        System.out.println("count -->"+count);
        int countmemo = StairCase.countviaMemo(10);
        System.out.println("countmemo -->"+countmemo);

    }

}
