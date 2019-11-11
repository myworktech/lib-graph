package com.myworktech.edgeProvider;

import java.util.Set;

public interface EdgeProvider<V> {

    void addEdge(V source, V destination);

    void addEdge(V source, V destination, long weight);

    boolean containsVertex(V vertex);

    void addVertex(V vertex);

    boolean hasEdge(V vertex1, V vertex2);

    Set<V> getNeighbours(V vertex);
}