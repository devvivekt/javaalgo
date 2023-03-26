package com.learning.java.algo.alldsa.recursion;


import lombok.extern.log4j.Log4j2;
import org.springframework.util.StopWatch;

import java.awt.*;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * We have an m x n grid. A robot is placed in the top-left corner of this grid.
 * The robot can only move either right or down at any point in time,
 * but it is not allowed to move in certain cells.
 * The robot's goal is to find a path from the top-left corner to the bottom-right corner of the grid.
 */
@Log4j2
public class RobotGrid {

    /*
        plain recursive algorithm,
        traverse recursively from top left (m,n) to bottom right (0,0)
     */
    public static boolean computePath(int m, int n,boolean[][] maze, Set<Point> path){
        if(path == null || maze == null){
            throw new IllegalArgumentException("path maze cannot be null");
        }

        //off the grid
        if(m < 0 || n < 0) {
            return false;
        }

        //blocked cell in maze
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

        //blocked cell in maze
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

    public static void main(String[] args) {
        /* 0 - robot, # - maze, X - target
        (m, n) +           +
        |0| | | | | |
        |0|0| | | | |
        |#|0|0|0|0| |
        |#|#|#|#|0| |
        | | | | |0| |
        | | | | |0|X|
        +           + (0, 0)
        */
        Set<Point> path = new LinkedHashSet<>();

        boolean[][] maze = new boolean[6][6];
        maze[2][0]=true;
        maze[3][0]=true;
        maze[3][1]=true;
        maze[3][2]=true;
        maze[3][3]=true;

        StopWatch watch = new StopWatch("RobotGridRecursion");
        watch.start("RobotGridPlainRecursion");
        RobotGrid.computePath(5, 5, maze, path);
        watch.stop();
        log.info("time taken for task {} is {}"
                ,watch.getLastTaskInfo().getTaskName()
                ,watch.getLastTaskInfo().getTimeNanos());
        path.forEach(e -> log.info("path = {}",e.toString()));

        watch.start("RobotGridMemoRecursion");

        // we define a Set for storing the visited cells
        Set<Point> visited = new HashSet<>();
        // we compute and display the path

        RobotGrid.computePath(5, 5, maze, path, visited);
        watch.stop();
        log.info("time taken for task {} is {}"
                ,watch.getLastTaskInfo().getTaskName()
                ,watch.getLastTaskInfo().getTimeNanos());
        path.forEach(e -> log.info("path = {}",e.toString()));

    }

}
