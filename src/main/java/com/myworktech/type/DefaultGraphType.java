/*
 * (C) Copyright 2017-2018, by Dimitrios Michail and Contributors.
 *
 * JGraphT : a free Java graph-theory library
 *
 * See the CONTRIBUTORS.md file distributed with this work for additional
 * information regarding copyright ownership.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0, or the
 * GNU Lesser General Public License v2.1 or later
 * which is available at
 * http://www.gnu.org/licenses/old-licenses/lgpl-2.1-standalone.html.
 *
 * SPDX-License-Identifier: EPL-2.0 OR LGPL-2.1-or-later
 */
package com.myworktech.type;


public class DefaultGraphType implements GraphType {

    private final boolean directed;
    private final boolean weighted;

    private DefaultGraphType(boolean directed, boolean weighted) {
        this.directed = directed;
        this.weighted = weighted;
    }

    @Override
    public boolean isDirected() {
        return directed;
    }

    @Override
    public boolean isWeighted() {
        return weighted;
    }


    public static DefaultGraphType directedAndWeighted() {
        return new Builder()
                .directed().weighted(true).build();
    }

    public static DefaultGraphType directedAndNotWeighted() {
        return new Builder()
                .directed().weighted(false).build();
    }

    public static DefaultGraphType undirectedAndNotWeighted() {
        return new Builder()
                .undirected().weighted(false).build();
    }

    public static DefaultGraphType undirectedAndWeighted() {
        return new Builder()
                .undirected().weighted(true).build();
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("DefaultGraphType{");
        sb.append("directed=").append(directed);
        sb.append(", weighted=").append(weighted);
        sb.append('}');
        return sb.toString();
    }

    public static class Builder {
        private boolean directed;
        private boolean weighted;


        public Builder() {
            this.directed = false;
            this.weighted = false;
        }


        public Builder(GraphType type) {
            this.directed = type.isDirected();
            this.weighted = type.isWeighted();
        }


        public Builder directed() {
            this.directed = true;
            return this;
        }

        public Builder undirected() {
            this.directed = false;
            return this;
        }


        public Builder weighted(boolean value) {
            this.weighted = value;
            return this;
        }


        public DefaultGraphType build() {
            return new DefaultGraphType(directed, weighted);
        }
    }
}