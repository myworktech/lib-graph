package com.myworktech;

import com.myworktech.edge.DefaultDirectedEdge;
import com.myworktech.edge.Edge;
import com.myworktech.edge.Pair;
import com.myworktech.edgeProvider.EdgeFactory;
import com.myworktech.edgeProvider.EdgeProvider;
import com.myworktech.type.GraphType;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public abstract class AbstractGraph<V> implements Graph<V> {


    private final EdgeProvider<V> edgeProvider;
    private final GraphType graphType;
    private Map<V, Set<Edge<V>>> b;

    public AbstractGraph(GraphType graphType) {
        this.graphType = graphType;
        this.b = new HashMap<>();
        this.edgeProvider = EdgeFactory.getProvider(graphType, b);
    }

    @Override
    public boolean containsVertex(V vertex) {
        return b.containsKey(vertex);
    }

    @Override
    public void addVertex(V vertex) {
        b.putIfAbsent(vertex, new HashSet<>());
    }

    @Override
    public void addEdge(V source, V destination) {
        assertVertexExists(source);
        assertVertexExists(destination);
        checkCycles(source, destination);

        edgeProvider.addEdge(source, destination);
    }

    @Override
    public boolean hasEdge(V vertex1, V vertex2) {

        Set<Edge<V>> edges = b.get(vertex1);
        for (Edge<V> edge : edges) {
            Pair<V, V> v = edge.getVertexes();
                return v.hasElements(vertex1, vertex2);
        }
        return false;

    }

    public Set<V> getNeighbours(V vertex) {
        return b.get(vertex)
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

    private void checkCycles(V vertex1, V vertex2) {
        if (vertex1 == vertex2)
            throw new IllegalArgumentException("Cycles not allowed!");
    }

    private void assertVertexExists(V vertex) {
        if (!containsVertex(vertex))
            throw new IllegalArgumentException("No such vertex: " + vertex);
    }
}