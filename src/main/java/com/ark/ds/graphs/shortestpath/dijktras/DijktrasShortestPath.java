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
        Vertex source = new Vertex(sourceStr);
        Vertex destination = new Vertex(destinationStr);
        Set<Vertex> vertices = graph.getAllVertices();
        Map<Vertex, Integer> distanceMap = new HashMap<>();
        Map<Vertex, Vertex> prevVertexMap = new HashMap<>();
        initializeDistanceMap(distanceMap, vertices, source);
        Queue<Vertex> queue = new LinkedList<>();
        queue.add(source);
        while (!queue.isEmpty()) {
            Vertex vertex = queue.poll();
            List<Edge> edges = graph.getEdges(vertex);
            if (edges != null) {
                for (Edge edge : edges) {
                    int dist = distanceMap.get(vertex) + edge.getCost();
                    if (dist < distanceMap.get(edge.getEnd())) {
                        distanceMap.put(edge.getEnd(), dist);
                        prevVertexMap.put(edge.getEnd(), vertex);
                    }
                    queue.add(edge.getEnd());
                }
            }
        }
        return identifyShortestPath(destination, prevVertexMap);
    }

    private List<Vertex> identifyShortestPath( Vertex destination, Map<Vertex, Vertex> prevVertexMap) {
        List<Vertex> shortestPath = new ArrayList<>(prevVertexMap.size());
        Vertex temp = destination;
        while(temp !=null) {
            shortestPath.add(temp);
            temp = prevVertexMap.get(temp);
        }
        Collections.reverse(shortestPath);
        return shortestPath;
    }

    private void initializeDistanceMap(Map<Vertex, Integer> distanceMap, Set<Vertex> vertices, Vertex source) {
        for (Vertex vertex : vertices) {
            if (vertex.equals(source)) {
                distanceMap.put(source, 0);
            } else {
                distanceMap.put(vertex, Integer.MAX_VALUE);
            }
        }
    }
}
