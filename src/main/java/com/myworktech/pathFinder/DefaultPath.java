package com.myworktech.pathFinder;

import com.myworktech.edge.Edge;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class DefaultPath<V> {

    private final List<Edge<V>> edgeList;

    public DefaultPath() {
        this.edgeList = new LinkedList<>();
    }

    public List<Edge<V>> getEdgeList() {
        return edgeList;
    }

    public int getSize() {
        return edgeList.size();
    }

    public void add(Edge<V> edge) {
        edgeList.add(edge);
    }

    public void addFirst(Edge<V> edge) {
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