package com.learning.java.algo.alldsa.gphtheory;

public class AdjacencyMatrixGph {

    private static int[][] adjacencyMatrix = {
            {0,2,4,0},
            {0,0,0,3},
            {0,0,0,0},
            {0,0,0,0}
    };

    public static void main(String[] args) {
        for(int i=0; i< adjacencyMatrix.length; i++){
            for(int j=0; j< adjacencyMatrix.length; j++){
                if(adjacencyMatrix[i][j] != 0){
                    System.out.println("Edge with weight::" + adjacencyMatrix[i][j]);
                }
            }
        }
    }

}
