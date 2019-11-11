package com.myworktech.edgeProvider;

import com.myworktech.edge.DefaultDirectedEdge;
import com.myworktech.edge.Edge;
import com.myworktech.edge.WeightedDirectedEdge;

import java.util.*;
import java.util.stream.Collectors;

public class DirectedEdgeProvider<V> implements EdgeProvider<V> {

    private final Map<V, Set<Edge<V>>> map = new HashMap<>();
    private final boolean weighted;

    public DirectedEdgeProvider(boolean weighted) {
        this.weighted = weighted;
    }

    @Override
    public void addEdge(V source, V destination) {
        this.addEdge(source, destination, 0L);
    }

    @Override
    public void addEdge(V source, V destination, long weight) {
        if (weighted)
            map.get(source).add(new WeightedDirectedEdge<>(source, destination, weight));
        else
            map.get(source).add(new DefaultDirectedEdge<>(source, destination));
    }

    @Override
    public boolean containsVertex(V vertex) {
        return map.containsKey(vertex);
    }

    @Override
    public void addVertex(V vertex) {
        map.putIfAbsent(vertex, new HashSet<>());
    }

    @Override
    public boolean hasEdge(V source, V destination) {
        Set<Edge<V>> edges = map.get(source);
        for (Edge<V> edge : edges) {
            DefaultDirectedEdge<V> dde = (DefaultDirectedEdge<V>) edge;
            return dde.getDestination().equals(destination);
        }
        return false;
    }

    @Override
    public Set<V> getNeighbours(V vertex) {
        Set<Edge<V>> s = map.get(vertex);

        if (s == null)
            return Collections.emptySet();

        return s.stream()
                .map(e -> {
                    DefaultDirectedEdge<V> dde = (DefaultDirectedEdge<V>) e;
                    return dde.getDestination();
                })
                .collect(Collectors.toSet());
    }
}