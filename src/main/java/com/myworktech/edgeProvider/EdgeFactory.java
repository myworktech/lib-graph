package com.myworktech.edgeProvider;

import com.myworktech.edge.Edge;
import com.myworktech.type.GraphType;

import java.util.Map;
import java.util.Set;

public class EdgeFactory {

    public static <V> EdgeProvider<V> getProvider(GraphType graphType, Map<V, Set<Edge<V>>> map) {

        if (graphType.isDirected())
            if (graphType.isWeighted())
                return new WeightedDirectedEdgeProvider<V>(map);
            else
                return new DirectedEdgeProvider<V>(map);
        else
            if (graphType.isWeighted())
            return new WeightedUndirectedEdgeProvider<V>(map);

        else
            return new UndirectedEdgeProvider<V>(map);
    }
}