package com.learning.java.algo.alldsa.gphtheory;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DepthFirstSearch {

    private Stack<Vertex> stack;

    public DepthFirstSearch(){
        this.stack = new Stack<>();
    }

    //for handling multiple independent clusters
    public void dfsStack(List<Vertex> vertexList){
        for(Vertex vertex : vertexList){
            if(!vertex.isVisited()){
                vertex.setVisited(true);
                dfsHelperStack(vertex);
            }
        }
    }

    public void dfsRecursion(List<Vertex> vertexList){
        for(Vertex vertex : vertexList){
            if(!vertex.isVisited()){
                vertex.setVisited(true);
                dfsHelperRecursion(vertex);
            }
        }
    }

    public void dfsHelperRecursion(Vertex rootVertex){

        System.out.println("currently visiting recursion::::"+rootVertex);
        for(Vertex neighbor : rootVertex.getNeighbours()){
            if(!neighbor.isVisited()){
                neighbor.setVisited(true);
                dfsHelperRecursion(neighbor);
            }
        }
    }

    public void dfsHelperStack(Vertex rootVertex){
        stack.push(rootVertex);
        rootVertex.setVisited(true);
        while(!stack.empty()){
            Vertex current = stack.pop();
            System.out.println("currently visiting stack::::"+current);
            for(Vertex neighbor : current.getNeighbours()){
                if(!neighbor.isVisited()){
                    neighbor.setVisited(true);
                    stack.push(neighbor);
                }
            }
        }
    }

    public static void main(String[] args) {
        Vertex v1 = new Vertex("A");
        Vertex v2 = new Vertex("B");
        Vertex v3 = new Vertex("C");
        Vertex v4 = new Vertex("D");
        Vertex v5 = new Vertex("E");

        List<Vertex> list = new ArrayList<>();

        v1.addNeighbour(v2);
        v1.addNeighbour(v3);
        v3.addNeighbour(v4);
        v4.addNeighbour(v5);

        list.add(v1);
        list.add(v2);
        list.add(v3);
        list.add(v4);
        list.add(v5);

        DepthFirstSearch dfs = new DepthFirstSearch();
        //dfs.dfsStack(list);

        dfs.dfsRecursion(list);
    }
}
