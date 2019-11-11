package com.myworktech.edge;

import java.util.HashSet;
import java.util.Set;

public interface DirectedEdge<V> extends Edge<V> {

    V getSource();

    V getDestination();

    @Override
    default Pair<V,V> getVertexes() {
//        HashSet<V> vertexSet = new HashSet<>();
//        vertexSet.add(getSource());
//        vertexSet.add(getDestination());
        return new Pair<>(getSource(), getDestination());
    }
}