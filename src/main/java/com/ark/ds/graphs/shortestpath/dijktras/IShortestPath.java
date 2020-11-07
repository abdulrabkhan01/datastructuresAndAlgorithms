package com.ark.ds.graphs.shortestpath.dijktras;
import com.ark.ds.graphs.*;
import java.util.List;

public interface IShortestPath {
    List<Vertex> findShortestPath(IGraph graph, String source, String destination);
}
