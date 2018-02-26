package com.pbhatna.core.Implementations.graphs;

import java.util.*;

public class AdjacencySetGraph implements Graph {

    private List<Node> vertexList = new ArrayList<>();
    private GraphType graphType = GraphType.DIRECTED;
    private int numVertices = 0;

    public AdjacencySetGraph (int numVertices, GraphType graphType) {
        this.numVertices = numVertices;
        for (int i=0; i <numVertices; i++) {
            vertexList.add(new Node(i));
        }
        this.graphType = graphType;
    }

    @Override
    public void addEdge(int v1, int v2) {
        if (v1 < 0 || v2 < 0 || v1 > numVertices || v2 > numVertices) {
            throw new IllegalArgumentException("Vertex number not found:");
        }
        vertexList.get(v1).addEdge(v2);
        if (graphType == GraphType.UNDIRECTED) {
            vertexList.get(v2).addEdge(v1);
        }
    }

    @Override
    public List<Integer> getAdjacentVertices(int v) {
        if (v < 0 || v > numVertices) {
            throw new IllegalArgumentException("Vertex number not found:");
        }
        return vertexList.get(v).getAdjacencyVertices();
    }

    public static class Node {
        private int vertexNumber;
        private Set<Integer> adjacencySet = new HashSet<>();

        public Node(int vertexNumber) {
            this.vertexNumber = vertexNumber;
        }

        public int getVertexNumber() {
            return vertexNumber;
        }

        public void addEdge(int vertexNumber) {
            adjacencySet.add(vertexNumber);
        }

        public List<Integer> getAdjacencyVertices() {
            List<Integer> sortedList = new ArrayList<>(adjacencySet);

            Collections.sort(sortedList);

            return sortedList;
        }
    }
}
