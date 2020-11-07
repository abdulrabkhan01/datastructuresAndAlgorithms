package com.ark.ds.graphs;

import java.util.*;

/**
 * <p> Interface to represent Graph Data structure to provide more abstraction
 * over implementation</p>
 */
public interface IGraph {
    void addVertex(String label);
    void addEdge(String label1, String label2, int cost);
    Set<Vertex> getAllVertices();
    List<Edge> getEdges(Vertex vertex);
}
