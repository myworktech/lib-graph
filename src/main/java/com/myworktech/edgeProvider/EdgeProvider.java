package com.myworktech.edgeProvider;

public interface EdgeProvider<V> {

    void addEdge(V source, V destination);

    void addEdge(V source, V destination, long weight);
}