package com.myworktech.edge;

import java.util.Objects;

public class DefaultDirectedEdge<V> implements DirectedEdge<V> {

    private final V source;
    private final V destination;

    public DefaultDirectedEdge(V source, V destination) {
        this.source = source;
        this.destination = destination;
    }

    @Override
    public V getSource() {
        return source;
    }

    @Override
    public V getDestination() {
        return destination;
    }

    @Override
    public String toString() {
        return "DefaultDirectedEdge{" + "source=" + source +
                ", destination=" + destination +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DefaultDirectedEdge<?> edge = (DefaultDirectedEdge<?>) o;
        return Objects.equals(source, edge.source) &&
                Objects.equals(destination, edge.destination);
    }

    @Override
    public int hashCode() {
        return Objects.hash(source, destination);
    }
}