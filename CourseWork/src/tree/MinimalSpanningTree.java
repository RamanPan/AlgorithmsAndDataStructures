package tree;

import entities.Edge;
import sort.InsertionSortByRoman;
import structures.ArrayListByRoman;

import java.util.Comparator;

public class MinimalSpanningTree {
    private ArrayListByRoman<Edge> edges = new ArrayListByRoman<>();
    private static final InsertionSortByRoman<Edge> INSERTION_SORT = new InsertionSortByRoman<>();

    public int getWeight() {
        int weight = 0;
        for (int i = 0, l = edges.size(); i < l; i++)
            weight += edges.get(i).getW();
        return weight;
    }

    public ArrayListByRoman<Edge> getEdges() {
        return edges;
    }

    public void addEdge(Edge e) {
        edges.add(e);
    }


    public void setEdges(ArrayListByRoman<Edge> edges) {
        this.edges = edges;
    }

    /**
     * Преобразование полученного результата в формат,
     * необходимый для курсовой работы
     *
     * @return необходимый вывод для курсовой
     */

    public String kruskalResult() {
        INSERTION_SORT.sort(edges, Comparator.comparing(e -> e.getUKey() + " " + e.getVKey()));
        StringBuilder builder = new StringBuilder();
        for (int i = 0, l = edges.size(); i < l; i++) {
            Edge e = edges.get(i);
            builder.append(e.getUKey()).append(" ").append(e.getVKey()).append(System.lineSeparator());
        }
        builder.append(getWeight());
        return builder.toString();
    }
}
