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
        linkEdges();
    }

    /**
     * Пытается связать дерево (отсортировать вершины в правильном порядке)
     */
    public void linkEdges() {
        INSERTION_SORT.sort(edges, (a, b) -> a.getU() == b.getV() ? -1 : a.getV() == b.getU() ? 1 : 0);
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
        String[] resultList = new String[edges.size() + 1];
        for (int i = 0, l = edges.size(); i < l; i++) {
            Edge e = edges.get(i);
            resultList[i] = e.getUKey() + " " + e.getVKey();
        }
        resultList[edges.size()] = Integer.toString(getWeight());
        return String.join(System.lineSeparator(), resultList);
    }
}
