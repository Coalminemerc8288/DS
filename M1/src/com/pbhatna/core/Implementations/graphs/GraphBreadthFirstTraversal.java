package com.pbhatna.core.Implementations.graphs;

import java.util.Queue;
import java.util.ArrayDeque;
import java.util.List;

public class GraphBreadthFirstTraversal {

    public static void breadthFirstTraversal(Graph graph, int[] visited, int currentVertex) {

        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(currentVertex);

        while(!queue.isEmpty()) {
            int vertex = queue.remove();

            if (visited[currentVertex] == 1) {
                continue;
            }
            System.out.print(vertex + "->");
            visited[currentVertex] = 1;

            List<Integer> list = graph.getAdjacentVertices(currentVertex);
            for (int v: list) {
                if (visited[v] != 1) {
                    queue.add(v);
                }
            }
        }
    }
}
