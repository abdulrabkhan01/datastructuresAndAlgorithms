package com.ark.ds.graphs;

import java.util.Objects;

/**
 * <p> Class representing Graph Edge.</p>
 * @author AbdulR
 */
public class Edge {
    private final Vertex start;
    private final Vertex end;
    private final int cost;

    public Edge(Vertex start, Vertex end, int cost) {
        this.start = start;
        this.end = end;
        this.cost = cost;
    }

    public Vertex getEnd() {
        return end;
    }

    public int getCost() {
        return cost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Edge edge = (Edge) o;
        return cost == edge.cost &&
                Objects.equals(start, edge.start) &&
                Objects.equals(end, edge.end);
    }

    @Override
    public int hashCode() {
        return Objects.hash(start, end, cost);
    }

    @Override
    public String toString() {
        return "Edge{" +
                "start=" + start +
                ", end=" + end +
                ", cost=" + cost +
                '}';
    }
}
