package com.ark.ds.graphs.shortestpath.dijktras;

import com.ark.ds.graphs.*;

import java.util.*;

/**
 * <p> Dijktras Shortest Path Implementation. </p>
 *
 * @author AbdulR
 */
public class DijktrasShortestPath implements IShortestPath {
    @Override
    public List<Vertex> findShortestPath(IGraph graph, String sourceStr, String destinationStr) {
        validateEmptyGraph(graph);
        Vertex source = new Vertex(sourceStr);
        Vertex destination = new Vertex(destinationStr);
        Set<Vertex> vertices = graph.getAllVertices();
        Map<Vertex, Integer> distanceMap = new HashMap<>();
        Map<Vertex, Vertex> prevVertexMap = new HashMap<>();
        initializeDistanceMap(distanceMap, vertices, source);
        Queue<VertexWithPriority> queue = new PriorityQueue<>();
        findShortestPath(graph, source, distanceMap, prevVertexMap, queue);
        return identifyShortestPath(destination, prevVertexMap);
    }

    private void findShortestPath(IGraph graph, Vertex source, Map<Vertex, Integer> distanceMap, Map<Vertex, Vertex> prevVertexMap, Queue<VertexWithPriority> queue) {
        queue.add(new VertexWithPriority(source, 0));
        while (!queue.isEmpty()) {
            VertexWithPriority vertex = queue.poll();
            List<Edge> edges = graph.getEdges(vertex.getVertex());
            calculateMinDistance(distanceMap, prevVertexMap, queue, vertex.getVertex(), edges);
        }
    }

    private void calculateMinDistance(Map<Vertex, Integer> distanceMap, Map<Vertex, Vertex> prevVertexMap, Queue<VertexWithPriority> queue, Vertex vertex, List<Edge> edges) {
        if (edges != null) {
            for (Edge edge : edges) {
                int dist = distanceMap.get(vertex) + edge.getCost();
                if (dist < distanceMap.get(edge.getEnd())) {
                    distanceMap.put(edge.getEnd(), dist);
                    prevVertexMap.put(edge.getEnd(), vertex);
                    queue.add(new VertexWithPriority(edge.getEnd(), dist));
                }
            }
        }
    }

    private void validateEmptyGraph(IGraph graph) {
        if (graph.isEmpty()) {
            throw new IllegalArgumentException("Shortest path cannot be found as Graph is Empty");
        }
    }

    private List<Vertex> identifyShortestPath(Vertex destination, Map<Vertex, Vertex> prevVertexMap) {
        List<Vertex> shortestPath = new ArrayList<>(prevVertexMap.size());
        Vertex temp = destination;
        while (temp != null) {
            shortestPath.add(temp);
            temp = prevVertexMap.get(temp);
        }
        Collections.reverse(shortestPath);
        return shortestPath;
    }

    private void initializeDistanceMap(Map<Vertex, Integer> distanceMap, Set<Vertex> vertices, Vertex source) {
        for (Vertex vertex : vertices) {
            distanceMap.put(vertex, Integer.MAX_VALUE);
        }
        distanceMap.put(source, 0);
    }
}
