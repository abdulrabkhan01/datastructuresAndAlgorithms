package com.ark.ds.graphs.shortestpath.dijktras;

import com.ark.ds.graphs.Vertex;

public class VertexWithPriority implements  Comparable<VertexWithPriority>{
    private final Vertex vertex;
    private Integer priority =0;

    public VertexWithPriority(Vertex vertex, Integer priority) {
        this.vertex = vertex;
        this.priority = priority;
    }

    @Override
    public int compareTo(VertexWithPriority o) {
        return this.priority.compareTo(o.priority);
    }

    public Vertex getVertex() {
        return vertex;
    }

    public Integer getPriority() {
        return priority;
    }
}
