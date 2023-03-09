package com.learning.java.algo.alldsa.recursion;


import java.awt.*;
import java.util.Set;

/**
 * We have an m x n grid. A robot is placed in the top-left corner of this grid.
 * The robot can only move either right or down at any point in time,
 * but it is not allowed to move in certain cells.
 * The robot's goal is to find a path from the top-left corner to the bottom-right corner of the grid.
 */
public class RobotGrid {

    /*
        plain recursive algorithm
     */
    public static boolean computePath(int m, int n,boolean[][] maze, Set<Point> path){
        if(path == null || maze == null){
            throw new IllegalArgumentException("path maze cannot be null");
        }

        //off the grid
        if(m < 0 || n < 0) {
            return false;
        }

        if(maze[m][n]){
            return false;
        }

        if((m == 0 && n == 0)
                || computePath(m-1, n , maze, path)
                || computePath(m, n-1, maze, path)){
            path.add(new Point(m,n));
            return true;
        }
        return false;
    }


    /*
    recursive algorithm using memoization
    robot start top left corner at grid position m,n, need to reach 0,0
 */
    public static boolean computePath(int m, int n,boolean[][] maze, Set<Point> path, Set<Point> visitFailed){

        if(path == null || maze == null){
            throw new IllegalArgumentException("path maze cannot be null");
        }

        //off the grid
        if(m < 0 || n < 0) {
            return false;
        }

        if(maze[m][n]){
            return false;
        }

        Point cell = new Point(m,n);

        if(visitFailed.contains(cell)){
            return false;
        }

        if((m == 0 && n == 0)
                || computePath(m-1, n , maze, path, visitFailed)
                || computePath(m, n-1, maze, path, visitFailed)){
            path.add(cell);
            return true;
        }
        visitFailed.add(cell);
        return false;
    }
}
