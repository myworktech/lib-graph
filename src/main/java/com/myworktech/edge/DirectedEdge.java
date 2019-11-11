package com.myworktech.edge;

public interface DirectedEdge<V> extends Edge<V> {

    V getSource();

    V getDestination();

    @Override
    default Pair<V, V> getVertexes() {
        return new Pair<>(getSource(), getDestination());
    }
}