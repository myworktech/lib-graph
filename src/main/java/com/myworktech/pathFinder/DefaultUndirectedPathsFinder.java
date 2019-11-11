package com.myworktech.pathFinder;

import com.myworktech.DefaultUndirectedGraph;
import com.myworktech.edge.DefaultDirectedEdge;

import java.util.HashSet;
import java.util.Set;

public class DefaultUndirectedPathsFinder<V> {

    private final DefaultUndirectedGraph<V> defaultUndirectedGraph;

    public DefaultUndirectedPathsFinder(DefaultUndirectedGraph<V> defaultUndirectedGraph) {
        this.defaultUndirectedGraph = defaultUndirectedGraph;
    }

    public Set<DefaultPath<V>> findAllPaths(V source, V destination) {
        return findRecursive(new HashSet<>(), source, destination);
    }

    private Set<DefaultPath<V>> findRecursive(Set<V> seen, V source, V destination) {
        seen.add(source);

        if (source == destination) {
            if (seen.size() == 1)
                return new HashSet<>();
            HashSet<DefaultPath<V>> defaultPaths = new HashSet<>();
            defaultPaths.add(new DefaultPath<>());
            return defaultPaths;
        }

        Set<DefaultPath<V>> allPaths = new HashSet<>();
        for (V neighbour : defaultUndirectedGraph.getNeighbours(source)) {
            if (!seen.contains(neighbour)) {
                Set<DefaultPath<V>> results = findRecursive(new HashSet<>(seen), neighbour, destination);

                if (!results.isEmpty()) {
                    for (DefaultPath<V> result : results) {
                        result.addFirst(new DefaultDirectedEdge<>(source, neighbour));
                        if (!allPaths.isEmpty())
                            allPaths.add(result);
                    }
                    if (allPaths.isEmpty())
                        allPaths = results;
                }

            }
        }
        return allPaths;

    }
}