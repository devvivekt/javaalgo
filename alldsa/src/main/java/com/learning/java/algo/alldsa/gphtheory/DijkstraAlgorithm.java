package com.learning.java.algo.alldsa.gphtheory;

import java.util.ArrayList;

import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class DijkstraAlgorithm {

    public void compute(Vartax source){
        source.setDistance(0);
        //queue
        PriorityQueue<Vartax> queue = new PriorityQueue<>();
        queue.add(source);
        while(!queue.isEmpty()){
            Vartax actualVartax = queue.poll();
            for(Edges edge : actualVartax.getNeighbour()){
                Vartax u = edge.getStartVertex();
                Vartax v = edge.getTargetVertex();
                double d = actualVartax.getDistance() + edge.getWeight();
                if(d < v.getDistance()){
                    queue.remove(v);
                    v.setDistance(d);
                    v.setPredecessor(actualVartax);
                    queue.add(v);
                }
            }
        }
    }

    public List<Vartax> getShortestPathTo(Vartax targetVartax){
        List<Vartax> path = new ArrayList<>();
        for(Vartax vertex = targetVartax; vertex != null; vertex = vertex.getPredecessor()){
            path.add(vertex);
        }
        Collections.reverse(path);
        return path;
    }

    public static void main(String[] args) {
        Vartax vertex0 = new Vartax("A");
        Vartax vertex1 = new Vartax("B");
        Vartax vertex2 = new Vartax("C");
        Vartax vertex3 = new Vartax("D");
        Vartax vertex4 = new Vartax("E");
        Vartax vertex5 = new Vartax("F");
        Vartax vertex6 = new Vartax("G");
        Vartax vertex7 = new Vartax("H");

        vertex0.addNeighbour(new Edges(5, vertex0, vertex1));
        vertex0.addNeighbour(new Edges(9, vertex0, vertex4));
        vertex0.addNeighbour(new Edges(8, vertex0, vertex7));

        vertex1.addNeighbour(new Edges(12, vertex1, vertex2));
        vertex1.addNeighbour(new Edges(15, vertex1, vertex3));
        vertex1.addNeighbour(new Edges(4, vertex1, vertex7));

        vertex2.addNeighbour(new Edges(3, vertex2, vertex3));
        vertex2.addNeighbour(new Edges(11, vertex2, vertex6));

        vertex3.addNeighbour(new Edges(9, vertex3, vertex6));

        vertex4.addNeighbour(new Edges(4, vertex4, vertex5));
        vertex4.addNeighbour(new Edges(20, vertex4, vertex6));
        vertex4.addNeighbour(new Edges(5, vertex4, vertex7));

        vertex5.addNeighbour(new Edges(1, vertex5, vertex2));
        vertex5.addNeighbour(new Edges(13, vertex5, vertex7));

        vertex5.addNeighbour(new Edges(7, vertex7, vertex2));
        vertex5.addNeighbour(new Edges(6, vertex7, vertex5));

        DijkstraAlgorithm algorithm = new DijkstraAlgorithm();
        algorithm.compute(vertex0);
        System.out.println(algorithm.getShortestPathTo(vertex6));
        System.out.println(algorithm.getShortestPathTo(vertex3));
    }

}
class Vartax implements Comparable<Vartax> {
    private String name;
    private boolean visited;
    private List<Edges> adjecencyList;
    //distance from source
    private double distance;

    public Vartax(String name) {
        this.name = name;
        this.adjecencyList = new ArrayList<>();
        this.distance = Double.MAX_VALUE;
    }

    //previous vartax on the shortest path
    private Vartax predecessor;

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

    public List<Edges> getNeighbour() {
        return adjecencyList;
    }

    public void addNeighbour(Edges neighbour) {
        this.adjecencyList.add(neighbour);
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public Vartax getPredecessor() {
        return predecessor;
    }

    public void setPredecessor(Vartax predecessor) {
        this.predecessor = predecessor;
    }

    @Override
    public int compareTo(Vartax otherVartax) {
        return Double.compare(this.distance, otherVartax.getDistance());
    }

    @Override
    public String toString() {
        return  this.name + " -- "+this.distance;
    }
}

class Edges{
    private double weight;
    private Vartax startVertex;
    private Vartax targetVertex;

    public Edges(double weight, Vartax startVertex, Vartax targetVertex) {
        this.weight = weight;
        this.startVertex = startVertex;
        this.targetVertex = targetVertex;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public Vartax getStartVertex() {
        return startVertex;
    }

    public void setStartVertex(Vartax startVertex) {
        this.startVertex = startVertex;
    }

    public Vartax getTargetVertex() {
        return targetVertex;
    }

    public void setTargetVertex(Vartax targetVertex) {
        this.targetVertex = targetVertex;
    }
}
