package com.myworktech.edgeProvider;

import com.myworktech.type.GraphType;

public class EdgeFactory {

    public static <V> EdgeProvider<V> getProvider(GraphType graphType) {
        if (graphType.isDirected())
            return new DirectedEdgeProvider<>(graphType.isWeighted());
        else
            return new UndirectedEdgeProvider<>(graphType.isWeighted());
    }
}