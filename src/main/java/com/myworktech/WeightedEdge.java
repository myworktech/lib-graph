package com.myworktech;

import java.util.Objects;

public class WeightedEdge<V> {

    private final V source;
    private final V destination;
    private final int weight;

    public WeightedEdge(V source, V destination, int weight) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    public V getSource() {
        return source;
    }

    public V getDestination() {
        return destination;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("WeightedEdge{");
        sb.append("source=").append(source);
        sb.append(", destination=").append(destination);
        sb.append(", weight=").append(weight);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WeightedEdge<?> that = (WeightedEdge<?>) o;
        return weight == that.weight &&
                Objects.equals(source, that.source) &&
                Objects.equals(destination, that.destination);
    }

    @Override
    public int hashCode() {
        return Objects.hash(source, destination, weight);
    }
}