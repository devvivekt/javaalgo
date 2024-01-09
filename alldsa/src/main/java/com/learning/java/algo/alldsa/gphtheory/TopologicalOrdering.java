package com.learning.java.algo.alldsa.gphtheory;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.Vector;

public class TopologicalOrdering {

    private Stack<Vertex> stack;

    public Stack<Vertex> getStack() {
        return stack;
    }

    public void setStack(Stack<Vertex> stack) {
        this.stack = stack;
    }

    public TopologicalOrdering(){
        this.stack = new Stack<>();
    }

    public void dfs(Vertex vertex){
        vertex.setVisited(true);
        for(Vertex neighbor : vertex.getNeighbours()){
            if(!neighbor.isVisited()){
                dfs(neighbor);
            }
        }
        stack.push(vertex);
    }

    public static void main(String[] args) {
        TopologicalOrdering topologicalOrdering = new TopologicalOrdering();
        List<Vertex> graph = new ArrayList<>();
        graph.add(new Vertex("0"));
        graph.add(new Vertex("1"));
        graph.add(new Vertex("2"));
        graph.add(new Vertex("3"));
        graph.add(new Vertex("4"));
        graph.add(new Vertex("5"));

        graph.get(2).addNeighbour(graph.get(3));
        graph.get(3).addNeighbour(graph.get(1));

        graph.get(4).addNeighbour(graph.get(0));
        graph.get(4).addNeighbour(graph.get(1));
        graph.get(5).addNeighbour(graph.get(0));
        graph.get(5).addNeighbour(graph.get(2));

        for(int i = 0 ; i< graph.size(); i++){
            if(!graph.get(i).isVisited()){
                topologicalOrdering.dfs(graph.get(i));
            }
        }
        Stack<Vertex> stackRes = topologicalOrdering.getStack();

        for(int i =0; i< graph.size(); i++){
            System.out.println("topologicalOrdering"+stackRes.pop());
        }


    }
}
