package com.pbhatna.core.Implementations.graphs.algorithms;
import com.pbhatna.core.Implementations.graphs.algorithms.Graph;

import java.util.*;

/**
 * Find in degree for all the elements and start from in degree zero. Remove edges and and vertex
 * once processed and find next element like that.
 */
public class TopologicalSort {

    public static List<Integer> sort(Graph graph) {

        LinkedList<Integer> queue = new LinkedList<>();
        Map<Integer, Integer> indegreeMap = new HashMap<>();

        //
        for (int vertex =0; vertex < graph.getNumVertices(); vertex ++) {
            int indegree = graph.getIndegree(vertex);
            indegreeMap.put(vertex, indegree);

            if (indegree == 0) {
                queue.add(vertex);
            }
        }

        List<Integer> sortedList = new ArrayList<>();
        while (!queue.isEmpty()) {
            int vertex = queue.pollLast();
            sortedList.add(vertex);

            List<Integer> adjacentVertices = graph.getAdjacentVertices(vertex);
            for (int adjacentVertex: adjacentVertices) {
                int updateIndegree =  indegreeMap.get(adjacentVertex) - 1;
                indegreeMap.remove(adjacentVertex);
                indegreeMap.put(adjacentVertex, updateIndegree);

                if (updateIndegree == 0) {
                    queue.add(adjacentVertex);
                }
            }

            if (sortedList.size() != graph.getNumVertices()) {
                throw new RuntimeException("Graph had a cycle:");
            }
        }

        return sortedList;
    }

}
