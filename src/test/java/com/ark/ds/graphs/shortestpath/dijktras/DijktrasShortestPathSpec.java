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
    public void dijktrasShortestPathEmptyGraph() {
        IGraph graph = new Graph();
        IShortestPath dijktrasShortestPath = new DijktrasShortestPath();
        assertThrows(IllegalArgumentException.class, ()->  {dijktrasShortestPath.findShortestPath(graph,"A","B");});
    }

    @Test
    public void dijktrasShortestPathSpec1() {
        IGraph graph = new Graph();
        initializeGraph(graph);
        IShortestPath dijktrasShortestPath = new DijktrasShortestPath();
        List<Vertex> shortestPath = dijktrasShortestPath.findShortestPath(graph, "A", "C");
        StringBuilder path = new StringBuilder(shortestPath.size());
        for(Vertex v : shortestPath) {
            path.append(v.getLabel());
        }
        assertEquals("ABC",path.toString());
    }

    @Test
    public void dijktrasShortestPathSpec2() {
        IGraph graph = new Graph();
        initializeGraph(graph);
        IShortestPath dijktrasShortestPath = new DijktrasShortestPath();
        List<Vertex> shortestPath = dijktrasShortestPath.findShortestPath(graph, "A", "B");
        StringBuilder path = new StringBuilder(shortestPath.size());
        for(Vertex v : shortestPath) {
            path.append(v.getLabel());
        }
        assertEquals("AB",path.toString());
    }

    @Test
    public void dijktrasShortestPathSpec3() {
        IGraph graph = new Graph();
        initializeGraph(graph);
        IShortestPath dijktrasShortestPath = new DijktrasShortestPath();
        List<Vertex> shortestPath = dijktrasShortestPath.findShortestPath(graph, "B", "C");
        StringBuilder path = new StringBuilder(shortestPath.size());
        for(Vertex v : shortestPath) {
            path.append(v.getLabel());
        }
        assertEquals("BC",path.toString());
    }

    private void initializeGraph(IGraph graph) {
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addEdge("A", "B", 1);
        graph.addEdge("B", "C", 2);
        graph.addEdge("A", "C", 5);
    }


}
