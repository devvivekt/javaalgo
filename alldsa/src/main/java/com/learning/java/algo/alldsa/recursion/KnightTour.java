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

    public void knightTour(int r, int c, int cell, int visited[][]){

        if(r<0 || c< 0 || cell < 0){
            throw new IllegalArgumentException("row or col or cell cant be negative");
        }

        if(visited == null){
            throw new IllegalArgumentException("the visited[][] cant be null");
        }

        visited[r][c] = cell;

        if(cell >= n*n){
            print(visited);
            visited[r][c] = 0;
            return;
        }

        for(int i = 0 ; i < ROW.length-1; i++){
            int newR = r + ROW[i];
            int newC = c + COL[i];
            if(isValid(newR, newC) && visited[newR][newC] ==0){
                knightTour(newR, newC, cell+1 , visited);
            }
        }
        //backtrack from current cell and remove it from current path
        visited[r][c] = 0;
    }

    private boolean isValid(int r, int c){
        return !(r<0 || c< 0 || r>= n || c >=n);
    }

    private void print(int[][] visited){
        for(int i=0; i< n; i++){
            for(int j = 0; j< n ; j++){
                System.out.format("%3s", visited[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args){
        int n = 8;
        KnightTour tour = new KnightTour(n);
        int[][] visited = new int[n][n];
        tour.knightTour(1,1,1, visited);
    }

}
