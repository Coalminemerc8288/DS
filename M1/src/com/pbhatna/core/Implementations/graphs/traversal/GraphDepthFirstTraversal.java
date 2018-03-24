package com.pbhatna.core.Implementations.graphs.traversal;

import com.pbhatna.core.Implementations.graphs.impl.AdjacencyMatrixGraph;
import com.pbhatna.core.Implementations.graphs.interfaces.Graph;

import java.util.List;

public class GraphDepthFirstTraversal {
    private static int N = 8;

    public static void depthFirstTraversal(Graph graph, int[] visited, int currentVertex) {
        if (visited[currentVertex] == 1) {
            return;
        }
        visited[currentVertex] = 1;

        List<Integer> list = graph.getAdjacentVertices(currentVertex);
        for (int vertex: list) {
            depthFirstTraversal(graph,visited, vertex);
        }
        System.out.println("-->" + currentVertex);
    }

    public static void main(String[] args) {

        Graph graph = new AdjacencyMatrixGraph(N, Graph.GraphType.DIRECTED);
        graph.addEdge(1, 0);
        graph.addEdge(1, 2);
        graph.addEdge(2, 7);
        graph.addEdge(2, 4);
        graph.addEdge(2, 3);
        graph.addEdge(1, 5);
        graph.addEdge(5, 6);
        graph.addEdge(6, 3);
        graph.addEdge(3, 4);

        int[] visited = new int[] {0, 0, 0, 0, 0, 0, 0, 0};

        // This for-loop ensures that all nodes are covered even for an unconnected
        // graph.
        for (int i = 0; i < N; i++) {
            depthFirstTraversal(graph, visited, i);
        }
    }
}
