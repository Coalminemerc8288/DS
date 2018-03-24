package com.pbhatna.core.Implementations.graphs.impl;

import com.pbhatna.core.Implementations.graphs.interfaces.Graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AdjacencyMatrixGraph implements Graph {

    private int[][] adjacencyMatrix;
    private GraphType graphType = GraphType.DIRECTED;
    private int numVertices = 0;

    public AdjacencyMatrixGraph(int numVertices, GraphType graphType) {
        this.numVertices = numVertices;
        this.graphType = graphType;

        for (int i=0; i < numVertices; i++) {
            for (int j=0; j< numVertices; j++) {
                //default initialize
                adjacencyMatrix[i][j] = 0;
            }
        }
    }

    @Override
    public void addEdge(int v1, int v2) {
        if (v1 < 0 || v2 < 0 || v1 > numVertices || v2 > numVertices) {
            throw new IllegalArgumentException("Vertex number not found:");
        }

        adjacencyMatrix[v1][v2] = 1;
        if (graphType == GraphType.UNDIRECTED) {
            adjacencyMatrix[v2][v1] = 1;
        }
    }

    @Override
    public List<Integer> getAdjacentVertices(int v) {
        if (v < 0 || v > numVertices) {
            throw new IllegalArgumentException("Vertex number not found:");
        }

        List<Integer> adjacentVerticesList = new ArrayList<>();
        for (int i=0; i< numVertices; i++) {
            // Iterate the row of vertex v in N * N matrix to find the nearby neighbours
            if (adjacencyMatrix[v][i] == 1) {
                adjacentVerticesList.add(i);
            }
        }

        // Always return the vertices in ascending order for consistency
        Collections.sort(adjacentVerticesList);

        return adjacentVerticesList;
    }
}
