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

    public Edge getEdge(String from, String to) {
        return edges.get(edges.indexOfFirst(e -> e.getUKey().equals(from) && e.getVKey().equals(to)));
    }

    public Edge getEdge(Integer from, Integer to) {
        return edges.get(edges.indexOfFirst(e -> e.getU() == from && e.getV() == to));
    }
}