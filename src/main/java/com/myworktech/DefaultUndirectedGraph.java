package com.myworktech;

import com.myworktech.type.DefaultGraphType;

public class DefaultUndirectedGraph<V> extends AbstractGraph<V> {

    public DefaultUndirectedGraph() {
        super(new DefaultGraphType.Builder().undirected().build());
    }
}