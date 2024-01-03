package com.learning.java.algo.alldsa.gphtheory;

public class AdjacencyListGph {

    public static void main(String[] args) {
        Vertex a = new Vertex("A");
        Vertex b = new Vertex("B");
        Vertex c = new Vertex("C");
        Vertex d = new Vertex("D");

        a.addNeighbour(b);
        a.addNeighbour(c);
        b.addNeighbour(d);

        a.showNeighbours();
        b.showNeighbours();
        c.showNeighbours();
        d.showNeighbours();
    }
}
