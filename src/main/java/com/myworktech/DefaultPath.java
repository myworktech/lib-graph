package com.myworktech;

import java.util.*;

public class DefaultPath<V> {

    private final List<DefaultEdge<V>> edgeList;

    public DefaultPath() {
        this.edgeList = new LinkedList<>();
    }

    public List<DefaultEdge<V>> getEdgeList() {
        return edgeList;
    }

    public int getSize() {
        return edgeList.size();
    }

    public void add(DefaultEdge<V> edge) {
        edgeList.add(edge);
    }

    public void addFirst(DefaultEdge<V> edge) {
        edgeList.add(0, edge);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DefaultPath<?> that = (DefaultPath<?>) o;
        return Objects.equals(edgeList, that.edgeList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(edgeList);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("DefaultPath{");
        sb.append("edgeList=").append(Arrays.toString(edgeList.toArray()));
        sb.append('}');
        return sb.toString();
    }
}