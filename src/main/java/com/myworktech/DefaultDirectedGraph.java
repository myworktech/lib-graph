package com.myworktech;

import com.myworktech.type.DefaultGraphType;

public class DefaultDirectedGraph<V> extends AbstractGraph<V> {

    public DefaultDirectedGraph() {
        super(DefaultGraphType.directedAndNotWeighted());
    }
}