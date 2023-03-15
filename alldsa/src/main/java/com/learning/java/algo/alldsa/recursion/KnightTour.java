package com.learning.java.algo.alldsa.recursion;

public class KnightTour {

    private final int n;
    public KnightTour(int n){
        if(n <=1){
            throw new IllegalArgumentException("board Size must be greater than n");
        }
        this.n = n;
    }

    //all 8 possible movements of Knight
    public static final int ROW[] = {1,-1,-2,-2,-1, 1, 2, 2};
    public static final int COL[] = {2, 2, 1,-1,-2,-2,-1, 1};

    public static void knightTour(int r, int c, int cell, int visited[][]){

        if(r<0 || c< 0 || cell < 0){
            throw new IllegalArgumentException("row orc col or cell cant be negative");
        }

        if(visited == null){
            throw new IllegalArgumentException("the visited[][] cant be null");
        }
    }

}
