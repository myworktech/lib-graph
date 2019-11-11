package com.myworktech.edge;

public class WeightedDirectedEdge<V> extends DefaultDirectedEdge<V> implements Weight {

    private final long weight;

    public WeightedDirectedEdge(V source, V destination, long weight) {
        super(source, destination);
        this.weight = weight;
    }

    @Override
    public long getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("WeightedDirectedEdge{");
        sb.append("weight=").append(weight);
        sb.append(", source=").append(getSource());
        sb.append(", destination=").append(getDestination());
        sb.append('}');
        return sb.toString();
    }
}