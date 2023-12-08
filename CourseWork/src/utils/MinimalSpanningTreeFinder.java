package utils;

import entities.Edge;
import sort.InsertionSortByRoman;
import structures.ArrayListByRoman;
import structures.DisjointSetByRoman;
import tree.MinimalSpanningTree;

public class MinimalSpanningTreeFinder {

    private MinimalSpanningTreeFinder() {
    }

    private static final InsertionSortByRoman<Edge> INSERTION_SORT = new InsertionSortByRoman<>();

    public static MinimalSpanningTree mstKruskal(ArrayListByRoman<Edge> edges) {
        DisjointSetByRoman disjointSetByRoman = new DisjointSetByRoman(edges.size());
        MinimalSpanningTree mst = new MinimalSpanningTree();
        INSERTION_SORT.sort(edges, Edge::compareTo);
        for (int i = 0; i < edges.size(); i++) {
            Edge e = edges.get(i);
            if (disjointSetByRoman.union(e.getU(), e.getV()))
                mst.addEdge(e);
        }
        return mst;
    }


}
