package com.learning.java.algo.alldsa.recursion;

import lombok.extern.log4j.Log4j2;
import org.springframework.util.StopWatch;

/**
 * passed the position k , find the kth fabonacci number
 */
@Log4j2
public class Fibonacci {


    /**
     * using recursion
     * time complexity 2^n
     * horrible time complexity
     */
    public int findFibonacciRecursion(int k){
        if(k <= 1){
            return k;
        }
        return findFibonacciRecursion(k-2)+ findFibonacciRecursion(k-1);
    }

    /**
     * Dynamic programming topdown approach
     * I wrote a book. How? I wrote its chapters. How? I wrote the sections of each chapter
     * . How? I wrote the paragraphs of each section.
     * called memoization
     * memoization caches the result for given inputs
     * O(n) memory O(n)
     * @param k
     * @return
     */
    public int findFibonacciDynamicMemo(int k){
       return findFibonacciDynMemoHelper(k, new int[k+1]);
    }

    public int findFibonacciDynMemoHelper(int k, int[] cache){
        if(k <= 1){
            return k;
        }
        if(cache[k] > 0){
            return cache[k];
        }
        cache[k] = findFibonacciDynMemoHelper(k-2,cache) + findFibonacciDynMemoHelper(k-1,cache);
        return cache[k];
    }

    /**
     * Dynamic Programming using Tabulation Approach
     * Bottom Up runtime O(n) , memory O(1)
     * Going bottom-up is an approach that avoids recursion and is quite natural
     * I wrote the paragraphs of each section. And? And I wrote the sections of each chapter.
     * And? And I wrote all the chapters. And? And I wrote a book.
     * Bottom-Up reduces the memory cost imposed by recursion when it builds up the call stack,
     * which means that Bottom-Up eliminates the vulnerability of getting stack overflow errors.
     * @param k
     * @return
     */
    public int findFibonacciDynamicTab(int k){
        if( k <= 1){
            return k;
        }
        int first = 1;
        int second = 0;
        int result = 0;
        for(int i = 1; i < k ; i++){
            result = first + second;
            second = first;
            first = result;
        }
        return result;
    }



    public static void main(String args[]){
        Fibonacci fibonacci = new Fibonacci();
        StopWatch watch = new StopWatch("fibonacci");
        watch.start("faboRecusrion");
        int number = fibonacci.findFibonacciRecursion(38);
        watch.stop();
        log.info("time taken for task {} is {}"
                ,watch.getLastTaskInfo().getTaskName()
                        ,watch.getLastTaskInfo().getTimeNanos());
        log.info("number = {}" , number);

        watch.start("faboRecusrionDynamicMemo");
        number = fibonacci.findFibonacciDynamicMemo(38);
        watch.stop();
        log.info("time taken for task {} is {}"
                ,watch.getLastTaskInfo().getTaskName()
                ,watch.getLastTaskInfo().getTimeNanos());
        log.info("number = {}" , number);

        watch.start("faboDynamicTabulation");
        number = fibonacci.findFibonacciDynamicTab(38);
        watch.stop();
        log.info("time taken for task {} is {}"
                ,watch.getLastTaskInfo().getTaskName()
                ,watch.getLastTaskInfo().getTimeNanos());
        log.info("number = {}" , number);
    }

}
