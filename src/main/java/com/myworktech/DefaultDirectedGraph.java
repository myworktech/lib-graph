package com.myworktech;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class DefaultDirectedGraph<V> implements Graph<V> {

    public Map<V, Set<DefaultEdge<V>>> b = new HashMap<>();

    public boolean containsVertex(V vertex) {
        return b.containsKey(vertex);
    }

    public boolean containsEdge(V source, V destination) {
        Set<DefaultEdge<V>> neighbours = b.get(source);
        for (DefaultEdge<V> neighbour : neighbours) {
            if (neighbour.getDestination().equals(destination))
                return true;
        }
        return false;
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

        DefaultEdge<V> edge = new DefaultEdge<>(source, destination);

        b.get(source).add(edge);
    }

    private void checkCycles(V source, V destination) {
        if (source == destination)
            throw new IllegalArgumentException("Cycles not allowed!");
    }

    @Override
    public Set<DefaultPath<V>> getPath(V source, V destination) {
        assertVertexExists(source);
        assertVertexExists(destination);
        return new DefaultDirectedPathsFinder<>(this).findAllPaths(source, destination);
    }

    public Set<DefaultEdge<V>> getEdges(V vertex) {
        return b.get(vertex);
    }

    public Set<V> getNeighbours(V vertex) {
        return b.get(vertex)
                .stream()
                .map(DefaultEdge::getDestination)
                .collect(Collectors.toSet());
    }


    private void assertVertexExists(V vertex) {
        if (!containsVertex(vertex))
            throw new IllegalArgumentException("No such vertex: " + vertex);
    }

}