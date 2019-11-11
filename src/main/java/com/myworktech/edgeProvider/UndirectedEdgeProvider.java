package com.myworktech.edgeProvider;

import com.myworktech.edge.DefaultUndirectedEdge;
import com.myworktech.edge.Edge;
import com.myworktech.edge.Pair;
import com.myworktech.edge.WeightedUndirectedEdge;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class UndirectedEdgeProvider<V> implements EdgeProvider<V> {

    private final Map<V, Set<Edge<V>>> map = new HashMap<>();
    private final boolean weighted;

    public UndirectedEdgeProvider(boolean weighted) {
        this.weighted = weighted;
    }

    @Override
    public void addEdge(V source, V destination) {
        this.addEdge(source, destination, 0L);
    }

    @Override
    public void addEdge(V source, V destination, long weight) {
        if (weighted) {
            map.get(source).add(new WeightedUndirectedEdge<>(source, destination, weight));
            map.get(destination).add(new WeightedUndirectedEdge<>(source, destination, weight));
        } else {
            map.get(source).add(new DefaultUndirectedEdge<>(source, destination));
            map.get(destination).add(new DefaultUndirectedEdge<>(source, destination));
        }
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
    public boolean hasEdge(V vertex1, V vertex2) {
        Set<Edge<V>> edges = map.get(vertex1);
        for (Edge<V> edge : edges) {
            Pair<V, V> v = edge.getVertexes();
            return v.hasElements(vertex1, vertex2);
        }
        return false;
    }

    @Override
    public Set<V> getNeighbours(V vertex) {
        return map.get(vertex)
                .stream()
                .map(e -> {
                    Pair<V, V> v = e.getVertexes();
                    if (v.getFirst() != vertex)
                        return v.getFirst();
                    else
                        return v.getSecond();
                })
                .collect(Collectors.toSet());
    }
}