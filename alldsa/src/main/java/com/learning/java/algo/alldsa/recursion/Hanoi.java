package com.learning.java.algo.alldsa.recursion;

public class Hanoi {

    public static void moveDisk(int n , char origin, char target, char intermediate){
        if(n <= 0 ){
            return;
        }
        if(n ==1 ){
            System.out.println("move disk 1 from rod "+ origin +" to rod "+target);
            return;
        }
        //move top n-1 rod from origin to intermediate using target as intermediate
        moveDisk(n-1, origin, intermediate, target);
        System.out.println("move disk "+n+ " from rod "+ origin +" to rod "+target);

        //move top n-1 disk from intermediate to target using origin as intermediate
        moveDisk(n-1, intermediate,target,origin);
    }

    public static void main(String[] args){
        int n = 5;
        moveDisk(5,'o', 't', 'i');
    }

}
