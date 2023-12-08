package utils;

import entities.Edge;
import entities.Graph;
import structures.ArrayListByRoman;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class GraphBuilder {
    private GraphBuilder() {
    }

    public static Graph createGraphFromString(String s) {
        Graph graph = new Graph();
        String[] lines = s.replace("\r", "").split("\n");
        String[] keys = lines[0].trim().split(" +");
        for (int i = 0, j = 0, k = 1; k < lines.length; k++, ++i, j = 0) {
            String[] lineValues = lines[k].trim().split(" +");
            for (String value : lineValues) {
                int weight = Integer.parseInt(value);
                if (weight != 0) graph.addEdge(new Edge(i, j, weight, keys[i], keys[j]));
                j++;
            }
        }
        return graph;
    }

    public static Graph createGraphFromFile(Path filePath) throws IOException {
        return createGraphFromString(String.join(System.lineSeparator(), Files.readAllLines(filePath)));
    }
}
