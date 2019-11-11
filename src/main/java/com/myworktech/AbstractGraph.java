package com.myworktech;

import com.myworktech.edgeProvider.EdgeFactory;
import com.myworktech.edgeProvider.EdgeProvider;
import com.myworktech.type.GraphType;

import java.util.Objects;
import java.util.Set;

public abstract class AbstractGraph<V> implements Graph<V> {

    private final EdgeProvider<V> edgeProvider;
    private final GraphType graphType;

    public AbstractGraph(GraphType graphType) {
        this.graphType = graphType;
        this.edgeProvider = EdgeFactory.getProvider(graphType);
    }

    @Override
    public boolean containsVertex(V vertex) {
        return edgeProvider.containsVertex(vertex);
    }

    @Override
    public void addVertex(V vertex) {
        edgeProvider.addVertex(vertex);
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
        return edgeProvider.hasEdge(vertex1, vertex2);
    }

    public Set<V> getNeighbours(V vertex) {
        return edgeProvider.getNeighbours(vertex);
    }

    private void checkCycles(V vertex1, V vertex2) {
        if (Objects.equals(vertex1, vertex2))
            throw new IllegalArgumentException("Cycles not allowed!");
    }

    private void assertVertexExists(V vertex) {
        if (!containsVertex(vertex))
            throw new IllegalArgumentException("No such vertex: " + vertex);
    }
}