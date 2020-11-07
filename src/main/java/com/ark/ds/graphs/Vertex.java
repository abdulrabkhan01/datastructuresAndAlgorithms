package com.ark.ds.graphs;

import java.util.Objects;

/**
 * <p> Class representing Graph Vertex. </p>
 * @author AbdulR
 */
public class Vertex {
    private final String label;

    public Vertex(String label) {
        this.label = label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vertex vertex = (Vertex) o;
        return Objects.equals(label, vertex.label);
    }

    public String getLabel() {
        return label;
    }

    @Override
    public int hashCode() {
        return Objects.hash(label);
    }

    @Override
    public String toString() {
        return "Vertex{" +
                "label='" + label + '\'' +
                '}';
    }
}
