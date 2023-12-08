import entities.Graph;
import utils.GraphBuilder;
import utils.MinimalSpanningTreeFinder;

import java.io.IOException;
import java.nio.file.Path;

public class Main {
    private static final String input = "A  B  C\n" +
            "0  3  1\n" +
            "3  0  2\n" +
            "1  2  0";


    public static void main(String[] args) throws IOException {
        Graph firstGraph = GraphBuilder.createGraphFromString(input);
        Graph secondGraph = GraphBuilder.createGraphFromFile(Path.of("resources\\test.txt"));
        Graph thirdGraph = GraphBuilder.createGraphFromFile(Path.of("resources\\difficultTest.txt"));
        System.out.println("Для первого графа");
        System.out.println(MinimalSpanningTreeFinder.mstKruskal(firstGraph.getEdges()).kruskalResult());
        System.out.println("Для второго графа");
        System.out.println(MinimalSpanningTreeFinder.mstKruskal(secondGraph.getEdges()).kruskalResult());
        System.out.println("Для третьего графа");
        System.out.println(MinimalSpanningTreeFinder.mstKruskal(thirdGraph.getEdges()).kruskalResult());
    }
}
