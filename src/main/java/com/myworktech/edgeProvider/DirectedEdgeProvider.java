package com.myworktech.edgeProvider;

import com.myworktech.edge.DefaultDirectedEdge;
import com.myworktech.edge.Edge;

import java.util.Map;
import java.util.Set;

public class DirectedEdgeProvider<V> implements EdgeProvider<V> {

    private final Map<V, Set<Edge<V>>> map;

    public DirectedEdgeProvider(Map<V, Set<Edge<V>>> map) {
        this.map = map;
    }

    @Override
    public void addEdge(V source, V destination) {
        this.addEdge(source, destination, 0L);
    }

    @Override
    public void addEdge(V source, V destination, long weight) {
        map.get(source).add(new DefaultDirectedEdge<>(source, destination));
    }
}