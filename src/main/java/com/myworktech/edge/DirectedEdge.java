package com.myworktech.edge;


import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public interface DirectedEdge<V> extends Edge<V> {
    V getSource();
    V getDestination();

    @Override
     default Set<V> getVertexes() {
        HashSet<V> vertexSet = new HashSet<>();
        vertexSet.add(getSource());
        vertexSet.add(getDestination());
        return vertexSet;
    };
}
