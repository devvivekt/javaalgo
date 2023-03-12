package com.learning.java.algo.alldsa.recursion;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Consider a 5x5 grid with five defensive towers spread across the grid.
 * To provide an optimal defense for the grid,
 * we have to build a tower on each row of the grid.
 * Find all the solutions for building these towers so that none of them
 * share the same column and diagonal.
 */
public class FiveTower {

    public static final int GRID_SIZE = 5;

    public static void buildTower(int row, Integer[] columns, Set<Integer[]> solutions){

        if(row< 0){
            throw new IllegalArgumentException("row cant be negative");
        }
        if(columns ==null || columns.length != GRID_SIZE){
            throw new IllegalArgumentException("column length must be equal to grid size"+GRID_SIZE);
        }

        if(solutions == null){
            throw new IllegalArgumentException("solution cant be null");
        }

        if(row == GRID_SIZE){
            solutions.add(columns.clone());
        } else {
            for(int col = 0; col < GRID_SIZE; col++) {
                if(canBuild(columns, row, col)){
                    columns[row] = col;
                    buildTower(row+1, columns, solutions);
                }
            }
        }

    }

    private static boolean canBuild(Integer[] columns, int nextRow, int nextCol){
        for(int currRow = 0 ; currRow < nextRow ; currRow++){
            int currCol = columns[currRow];

            //same column
            if(currCol == nextCol){
                return false;
            }
            int colDistance = Math.abs(currCol - nextCol);
            int rowDistnace = nextRow - currRow;
            //no diagonal
            if(colDistance == rowDistnace){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
        Integer[] cols = new Integer[]{0,1,2,3,4};
        Set<Integer[]> solutions = new HashSet<>();
        FiveTower.buildTower(0, cols, solutions);
        for(Integer[] arr : solutions){
            System.out.println(Arrays.asList(arr));
        }
    }
}
