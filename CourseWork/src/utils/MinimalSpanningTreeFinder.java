package utils;

import entities.Edge;
import sort.InsertionSortByRoman;
import structures.ArrayListByRoman;
import structures.DisjointSetByRoman;
import tree.MinimalSpanningTree;

public class MinimalSpanningTreeFinder {

    private static final InsertionSortByRoman<Edge> INSERTION_SORT = new InsertionSortByRoman<>();

    /**
     * Находит минимальное остовное дерево по алгоритму Краскала
     * с использованием системы непересекающихся множеств
     *
     * @param edges Массив связей
     * @return минимальное остовное дерево
     */
    public static MinimalSpanningTree mstKruskal(ArrayListByRoman<Edge> edges) {
        DisjointSetByRoman disjointSetByRoman = new DisjointSetByRoman(edges.size()); // СНМ
        MinimalSpanningTree mst = new MinimalSpanningTree();
        INSERTION_SORT.sort(edges, Edge::compareTo); // Сортируем ребра
        for (int i = 0; i < edges.size(); i++) { // Перебираем ребра в порядке неубывания
            Edge e = edges.get(i);
            if (disjointSetByRoman.union(e.getU(), e.getV())) // Если ребра принадлежат разным компонентам
                mst.addEdge(e); // Добавляем ребро в дерево
        }
        return mst;
    }


}
