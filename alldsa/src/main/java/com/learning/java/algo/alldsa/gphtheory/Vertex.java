package com.learning.java.algo.alldsa.gphtheory;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

public class Vertex {

    private String name;
    private boolean visited;
    private List<Vertex> adjacencyList;

    public List<Vertex> getAdjacencyList() {
        return adjacencyList;
    }

    public Vertex(String name){
        this.name = name;
        this.adjacencyList = new ArrayList<>();
    }

    public void addNeighbour(Vertex v){
        this.adjacencyList.add(v);
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public void showNeighbours(){
        for(Vertex v : adjacencyList){
            System.out.println(v);
        }
    }

    public List<Vertex> getNeighbours(){
        return this.adjacencyList;
    }

    @Override
    public String toString(){
        return this.name;
    }
}
