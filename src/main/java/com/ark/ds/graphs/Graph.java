package com.ark.ds.graphs;
import java.util.*;
/**
 * <p> Adjacency list representation of Graph. </p>
 * @author AbdulR
 */
public class Graph implements IGraph {

    private final Map<Vertex, List<Edge>> verticesMap = new HashMap<>();

    public void addVertex(String label) {
        Vertex vertex = new Vertex(label);
        verticesMap.put(vertex, new ArrayList<>());
    }

    public void addEdge(String label1, String label2, int cost) {
        Vertex v1 = new Vertex(label1);
        Vertex v2 = new Vertex(label2);
        verticesMap.get(v1).add(new Edge(v1, v2, cost));
    }

    @Override
    public Set<Vertex> getAllVertices() {
        return verticesMap.keySet();
    }

    @Override
    public List<Edge> getEdges(Vertex vertex) {
        return verticesMap.get(vertex);
    }

    @Override
    public boolean isEmpty() {
        return verticesMap.isEmpty();
    }

}
