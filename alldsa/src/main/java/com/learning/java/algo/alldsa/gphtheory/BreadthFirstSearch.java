package com.learning.java.algo.alldsa.gphtheory;

import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch {

    public void traverse(Vertex root){
        Queue<Vertex> queue = new LinkedList<>();

        root.setVisited(true);
        queue.add(root);

        while (!queue.isEmpty()){
            Vertex current = queue.remove();
            System.out.println("Currently Visiting:::"+current);
            for(Vertex neighbor :current.getAdjacencyList()){
                if(!neighbor.isVisited()){
                    neighbor.setVisited(true);
                    queue.add(neighbor);
                }
            }
        }


    }

    public static void main(String[] args) {
        BreadthFirstSearch bfs = new BreadthFirstSearch();

        Vertex a = new Vertex("A");
        Vertex b = new Vertex("B");
        Vertex c = new Vertex("C");
        Vertex d = new Vertex("D");
        Vertex e = new Vertex("E");
        Vertex f = new Vertex("F");
        Vertex g = new Vertex("G");
        Vertex h = new Vertex("H");

        a.addNeighbour(b);
        a.addNeighbour(f);
        a.addNeighbour(g);

        b.addNeighbour(a);
        b.addNeighbour(c);
        b.addNeighbour(d);

        c.addNeighbour(b);

        d.addNeighbour(b);
        d.addNeighbour(e);

        f.addNeighbour(a);

        g.addNeighbour(a);
        g.addNeighbour(h);

        h.addNeighbour(g);

        bfs.traverse(a);


    }
}
