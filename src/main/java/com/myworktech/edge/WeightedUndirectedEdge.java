package com.myworktech.edge;

import java.util.Objects;
import java.util.Set;

public class WeightedUndirectedEdge<V> extends DefaultUndirectedEdge<V> implements Weight {

    private final int weight;

    public WeightedUndirectedEdge(V first, V second, int weight) {
        super(first, second);
        this.weight = weight;
    }

    @Override
    public long getWeight() {
        return weight;
    }
}