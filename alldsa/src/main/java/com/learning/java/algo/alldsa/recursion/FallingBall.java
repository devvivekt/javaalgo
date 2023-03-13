package com.learning.java.algo.alldsa.recursion;

/**
 * Consider an m x n grid where each (m, n) cell has an elevation
 * represented by a number between 1 and 5 (5 is the highest elevation).
 * A ball is placed in a cell of the grid. This ball can fall into another cell,
 * as long as that cell has a smaller elevation than the ball cell.
 * The ball can fall in four directions: north, west, east, and south.
 * Display the initial grid, as well as the grid after the ball falls on all possible paths.
 * Mark the paths with 0
 */
public class FallingBall {

    public static void computePath(int prevElevation , int i, int j
            , int rows, int cols, int[][] elevations){

        if(elevations == null){
            throw new IllegalArgumentException("Elevations cant be null");
        }



        //boundary for ball
        if(i >=0 && i< rows && j >= 0 && j < cols){
            int currElevation = elevations[i][j];
            if(prevElevation >= currElevation && currElevation > 0){

                //save for next iteration
                prevElevation = currElevation;

                //mark visited
                elevations[i][j] = 0;

                //moving ball in different directions
                computePath(prevElevation, i-1, j , rows, cols, elevations);
                computePath(prevElevation, i+1, j , rows, cols, elevations);
                computePath(prevElevation, i, j-1 , rows, cols, elevations);
                computePath(prevElevation, i, j+1 , rows, cols, elevations);


            }
        }
    }

    public static void printGrid(int[][] elevations, int rows, int cols){
        for(int i = 0; i< rows; i++){
            for(int j = 0 ; j< cols; j++){
                System.out.format("%2s", elevations[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args){
        int[][] grid = {
                {2,5,4,3,3,4,2},
                {1,4,3,4,2,2,1},
                {4,3,2,2,1,2,3},
                {3,2,5,3,2,1,5},
                {5,4,3,2,1,1,3}
        };
        System.out.println("grid before visiting balls");
        printGrid(grid, 5, 7);
        int elevation = grid[0][1];
        FallingBall.computePath(elevation,0,1,5,7,grid);
        System.out.println("grid after visiting balls");
        printGrid(grid, 5, 7);

    }
}
