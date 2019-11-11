package com.myworktech.edge;

import java.util.Objects;

public class DefaultUndirectedEdge<V> implements Edge<V> {

    private final V first;
    private final V second;

    public DefaultUndirectedEdge(V first, V second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("DefaultUndirectedEdge{");
        sb.append("first=").append(first);
        sb.append(", second=").append(second);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DefaultUndirectedEdge<?> edge = (DefaultUndirectedEdge<?>) o;
        return (Objects.equals(first, edge.first) && Objects.equals(second, edge.second))
                || (Objects.equals(first, edge.second) && Objects.equals(first, edge.second));
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, second);
    }

    @Override
    public Pair<V, V> getVertexes() {

        return new Pair<>(first, second);
    }
}