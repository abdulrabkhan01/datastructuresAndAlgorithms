package com.ark.ds.graphs.shortestpath.dijktras;

import com.ark.ds.graphs.Graph;
import com.ark.ds.graphs.IGraph;
import com.ark.ds.graphs.Vertex;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

/**
 * <p> Dijktras shortest path spec using TDD.</p>
 *
 * @author AbdulR
 * @since 7-Nov-2020
 */
public class DijktrasShortestPathSpec {

    @Test
    public void dijktrasShortestPathSpec1() {
        IGraph graph = new Graph();
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addEdge("A", "B", 1);
        graph.addEdge("B", "C", 2);
        graph.addEdge("A", "C", 5);
        IShortestPath dijktrasShortestPath = new DijktrasShortestPath();
        List<Vertex> shortestPath = dijktrasShortestPath.findShortestPath(graph, new Vertex("A"), new Vertex("C"));
        StringBuilder path = new StringBuilder(shortestPath.size());
        for(Vertex v : shortestPath) {
            path.append(v.getLabel());
        }
        assertEquals("ABC",path.toString());
    }
}
