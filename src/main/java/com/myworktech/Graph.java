package com.myworktech;

import java.util.function.Consumer;

public interface Graph<V> {
    boolean containsVertex(V vertex);

    boolean hasEdge(V vertex1, V vertex2);

    void addVertex(V vertex);

    void addEdge(V vertex1, V vertex2);

    void applyToAllVertexes(Consumer<V> c);

}