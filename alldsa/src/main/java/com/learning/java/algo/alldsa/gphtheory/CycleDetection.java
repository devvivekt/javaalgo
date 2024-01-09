package com.learning.java.algo.alldsa.gphtheory;

import java.util.ArrayList;
import java.util.List;

public class CycleDetection {

    public void detectCycles(List<Vartexx> graph){
        //multiple independent clusters
        for(int i=0; i< graph.size(); i++){
            if(!graph.get(i).isVisited()){
                dfs(graph.get(i));
            }
        }
    }

    public void dfs(Vartexx vartexx){
        vartexx.setBeingVisited(true);
        for(Vartexx neighbour :vartexx.getNeighbour()){
            if(neighbour.isBeingVisited()){
                System.out.println("Backward Edge ......There is cycle in the graph");
                return;
            }
            if(!neighbour.isVisited()){
                neighbour.setVisited(true);
                dfs(neighbour);
            }
            vartexx.setBeingVisited(false);
            vartexx.setVisited(true);
        }
    }
    public static void main(String[] args) {
        Vartexx v0 = new Vartexx("A");
        Vartexx v1 = new Vartexx("B");
        Vartexx v2 = new Vartexx("C");
        Vartexx v3 = new Vartexx("D");
        Vartexx v4 = new Vartexx("E");
        Vartexx v5 = new Vartexx("F");

        v5.addNeighbour(v0);
        v0.addNeighbour(v4);
        v0.addNeighbour(v2);
        v4.addNeighbour(v5);
        v2.addNeighbour(v1);
        v2.addNeighbour(v3);

        List<Vartexx> graph = new ArrayList<>();
        graph.add(v0);
        graph.add(v1);
        graph.add(v2);
        graph.add(v3);
        graph.add(v4);
        graph.add(v5);

        CycleDetection algorithm = new CycleDetection();
        algorithm.detectCycles(graph);

    }

}

class Vartexx{
    private String name;
    private List<Vartexx> adjecencyList;
    private boolean visited;
    private boolean beingVisited;
    public Vartexx(String name) {
        this.name = name;
        adjecencyList = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Vartexx> getNeighbour() {
        return adjecencyList;
    }

    public void addNeighbour(Vartexx vartexx) {
        this.adjecencyList.add(vartexx);
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public boolean isBeingVisited() {
        return beingVisited;
    }

    public void setBeingVisited(boolean beingVisited) {
        this.beingVisited = beingVisited;
    }
}