package entities;

import structures.ArrayListByRoman;

public class Graph {
    ArrayListByRoman<Edge> edges = new ArrayListByRoman<>();

    public void addEdge(Edge e) {
        edges.add(e);
    }

    public ArrayListByRoman<Edge> getEdges() {
        return edges;
    }

}