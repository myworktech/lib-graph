package com.myworktech.type;

public interface GraphType {
    /**
     * @return true if all edges of the graph are directed
     */
    boolean isDirected();

    /**
     * @return true if the graph supports edge weights
     */
    boolean isWeighted();

}
