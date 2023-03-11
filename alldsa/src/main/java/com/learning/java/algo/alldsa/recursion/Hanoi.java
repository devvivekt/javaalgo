package com.learning.java.algo.alldsa.recursion;

/**
 * This is a classical problem that can occur in an interview at any time.
 * The Tower of Hanoi is a problem with three rods (A, B, and C) and n disks.
 * Initially, all the disks are placed in ascending order on a single rod
 * (the largest disk is on the bottom (disk n), a smaller one sitting on it (n-1)
 * , and so on (n-2, n-3, ...) until the smallest disk is on the top (disk 1).
 * The aim is to move all the disks from this rod to another rod while respecting the following rules:
 * Only one disk can be moved at a time.
 * A move means to slide the upper disk from one rod to another rod.
 * A disk cannot be placed on top of a smaller disk.
 */
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
