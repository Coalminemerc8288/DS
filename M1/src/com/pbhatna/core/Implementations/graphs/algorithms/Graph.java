package com.pbhatna.core.Implementations.graphs.algorithms;

import java.util.List;

public interface Graph {

    enum GraphType{
        DIRECTED,
        UNDIRECTED
    }

    GraphType TypeofGraph();

    int getWeightedEdge(int v1, int v2);

    int getNumVertices();

    int getIndegree(int v);

    void addEdge(int v1, int v2);

    void addEdge(int v1, int v2, int weight);

    List<Integer> getAdjacentVertices(int v);
}
