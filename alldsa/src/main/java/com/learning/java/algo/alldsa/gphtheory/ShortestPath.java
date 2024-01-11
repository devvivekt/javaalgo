package com.learning.java.algo.alldsa.gphtheory;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ShortestPath {

    private TopoOrdering topoOrdering;

    public ShortestPath(List<Vartex> graph){
        topoOrdering = new TopoOrdering(graph);
        graph.get(0).setMinDistance(0);
    }

    public void compute(){
        Stack<Vartex> topologicalOrder = topoOrdering.getStack();
        while(!topologicalOrder.isEmpty()){
            Vartex u = topologicalOrder.pop();

            for(Edge e : u.getNeighbour()){
                Vartex v = e.getTarget();
                if(v.getMinDistance() >  u.getMinDistance() + e.getWeight()){
                    v.setMinDistance(u.getMinDistance() + e.getWeight());
                    v.setPredecessor(u);
                }
            }
        }
    }

    //negating the weight will give the longest paths
    public static void main(String[] args) {
        List<Vartex> graph = new ArrayList<>();
        Vartex v0 = new Vartex("S");
        Vartex v1 = new Vartex("A");
        Vartex v2 = new Vartex("B");
        Vartex v3 = new Vartex("C");
        Vartex v4 = new Vartex("D");
        Vartex v5 = new Vartex("E");

        v0.addNeighbour(new Edge(v1, 1));
        v0.addNeighbour(new Edge(v3, 2));

        v1.addNeighbour(new Edge(v2, 6));

        v2.addNeighbour(new Edge(v4, 1));
        v2.addNeighbour(new Edge(v5, 2));

        v3.addNeighbour(new Edge(v1, 4));
        v3.addNeighbour(new Edge(v4, 3));

        v4.addNeighbour(new Edge(v5, 1));

        graph.add(v0);
        graph.add(v1);
        graph.add(v2);
        graph.add(v3);
        graph.add(v4);
        graph.add(v5);

        ShortestPath algorithm = new ShortestPath(graph);
        algorithm.compute();

        for(Vartex v : graph){
            System.out.println("Distance from s : "+v.getMinDistance() +" -- "+v.getPredecessor());
        }


    }

}

class TopoOrdering{
    private Stack<Vartex> stack;

    TopoOrdering(List<Vartex> graph){
        this.stack = new Stack<>();
        for(int i =0 ; i< graph.size(); i++){
            if(!graph.get(i).isVisited()){
                dfs(graph.get(i));
            }
        }
    }
    public void dfs(Vartex vartex){
        vartex.setVisited(true);
        for(Edge e : vartex.getNeighbour()){
            if(!e.getTarget().isVisited()){
                dfs(e.getTarget());
            }
        }
        stack.add(vartex);
    }

    public Stack<Vartex> getStack() {
        return stack;
    }

    public void setStack(Stack<Vartex> stack) {
        this.stack = stack;
    }
}

class Vartex {
    private String name;
    private boolean visited;
    //shortest path from source vartex to actual vartex
    private int minDistance;
    private Vartex predecessor;
    private List<Edge> adjecencyList;

    public Vartex(String name){
        this.name = name;
        this.minDistance = Integer.MAX_VALUE;
        this.adjecencyList = new ArrayList<>();
    }

    @Override
    public String toString() {
        return
                "name='" + name + '\'' + " predessor -" + this.predecessor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public int getMinDistance() {
        return minDistance;
    }

    public void setMinDistance(int minDistance) {
        this.minDistance = minDistance;
    }

    public Vartex getPredecessor() {
        return predecessor;
    }

    public void setPredecessor(Vartex predecessor) {
        this.predecessor = predecessor;
    }

    public List<Edge> getNeighbour() {
        return adjecencyList;
    }

    public void addNeighbour(Edge neighbour) {
        this.adjecencyList.add(neighbour);
    }
}

class Edge {
    private Vartex target;
    private int weight;

    public Edge(Vartex target, int weight){
        this.target = target;
        this.weight = weight;
    }

    public Vartex getTarget() {
        return target;
    }

    public void setTarget(Vartex target) {
        this.target = target;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
