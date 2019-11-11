package com.myworktech.edgeProvider;

import com.myworktech.edge.Edge;
import com.myworktech.edge.WeightedDirectedEdge;

import java.util.Map;
import java.util.Set;

public class WeightedUndirectedEdgeProvider<V> implements EdgeProvider<V> {

    private final Map<V, Set<Edge<V>>> map;

    public WeightedUndirectedEdgeProvider(Map<V, Set<Edge<V>>> map) {
        this.map = map;
    }


    @Override
    public void addEdge(V source, V destination) {
        this.addEdge(source, destination, 0L);
    }

    @Override
    public void addEdge(V source, V destination, long weight) {
        map.get(source).add(new WeightedDirectedEdge<>(source, destination, weight));
        map.get(destination).add(new WeightedDirectedEdge<>(source, destination, weight));
    }
}
