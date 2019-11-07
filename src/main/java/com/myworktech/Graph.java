package com.myworktech;

import java.util.Set;

public interface Graph<V> {
    void addVertex(V vertex);

    void addEdge(V source, V destination);

    Set<DefaultPath<V>> getPath(V source, V destination);
}