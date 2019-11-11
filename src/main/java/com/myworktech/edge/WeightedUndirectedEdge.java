package com.myworktech.edge;

import java.util.Objects;
import java.util.Set;

public class WeightedUndirectedEdge<V> extends DefaultUndirectedEdge<V> implements Weight {

    private final long weight;

    public WeightedUndirectedEdge(V first, V second, long weight) {
        super(first, second);
        this.weight = weight;
    }

    @Override
    public long getWeight() {
        return weight;
    }
}