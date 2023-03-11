package com.learning.java.algo.alldsa.recursion;


/**
 * Consider an r x c grid where r stands for rows and c stands for columns.
 * Each cell has a color represented by a number k (for example, for three colors, k=3).
 * We define the connected set of a cell (or a color spot) as the total cells in which
 * we can go from the respective cell by successive displacements on the row or the column,
 * thus keeping the color. The goal is to determine the color and the number of cells of
 * the maximum connected set.
 * In other words, we need to determine the biggest color spot.
 */
public class BiggestColorSpot {

    private int currentColorSpot;

    void determineBiggestColorSpot(int cols, int rows, int a[][] ){
        if(a == null){
            throw new IllegalArgumentException("matrix cant be null");
        }
        if(rows <= 0 || cols <=0){
            throw new IllegalArgumentException("rowa sand columns cant be 0");
        }

        int biggestColorSpot = 0;
        int color = 0;

        for(int i = 0; i < rows ; i++){
            for(int j = 0; j< cols ; j++){
                if(a[i][j] > 0){
                    currentColorSpot = 0;
                    computeColorSpot(i, j , cols, rows, a, a[i][j]);
                    if(currentColorSpot > biggestColorSpot){
                        biggestColorSpot = currentColorSpot;
                        color = a[i][j]*(-1);
                    }
                }
            }
        }
        System.out.println("Color "+color + " Biggest Spot "+biggestColorSpot);

    }

    private void computeColorSpot(int i, int j , int cols, int rows, int a[][], int color){
        a[i][j] = -a[i][j];
        currentColorSpot++;
        if(i > 1 && a[i-1][j] == color){
            computeColorSpot(i-1, j , cols, rows , a, color);
        }
        if(i+1 < rows && a[i+1][j] == color){
            computeColorSpot(i+1, j , cols, rows, a, color);
        }
        if(j > 1 && a[i][j-1] == color){
            computeColorSpot(i, j-1, cols,rows, a, color);
        }
        if(j+1 < cols && a[i][j+1] == color){
            computeColorSpot(i, j+1, cols, rows, a, color);
        }
    }

    public static void main(String[] args){
        BiggestColorSpot spot = new BiggestColorSpot();
        int[][] a = {
                {1,2,3,3,2}
                ,{2,1,2,3,3}
                ,{2,3,3,3,3}
                ,{3,2,1,1,3}
                ,{1,3,2,3,3}
        };
        spot.determineBiggestColorSpot(5, 5, a);
    }

}
