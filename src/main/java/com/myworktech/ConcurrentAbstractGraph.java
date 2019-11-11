package com.myworktech;

import com.myworktech.edgeProvider.EdgeFactory;
import com.myworktech.edgeProvider.EdgeProvider;
import com.myworktech.type.GraphType;

import java.util.Objects;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.function.Consumer;

/**
 * Thread-safe
 */
public abstract class ConcurrentAbstractGraph<V> implements Graph<V> {

    private final EdgeProvider<V> edgeProvider;
    private final GraphType graphType;

    private final ReadWriteLock lock = new ReentrantReadWriteLock();
    private final Lock readLock = lock.readLock();
    private final Lock writeLock = lock.writeLock();


    public ConcurrentAbstractGraph(GraphType graphType) {
        this.graphType = graphType;
        this.edgeProvider = EdgeFactory.getProvider(graphType);
    }

    @Override
    public boolean containsVertex(V vertex) {
        try {
            readLock.lock();
            return edgeProvider.containsVertex(vertex);
        } finally {
            readLock.unlock();
        }
    }

    @Override
    public void addVertex(V vertex) {
        try {
            writeLock.lock();
            edgeProvider.addVertex(vertex);
        } finally {
            writeLock.unlock();
        }
    }

    @Override
    public void addEdge(V source, V destination) {
        try {
            writeLock.lock();
            assertVertexExists(source);
            assertVertexExists(destination);
            checkSelfLoop(source, destination);

            edgeProvider.addEdge(source, destination);
        } finally {
            writeLock.unlock();
        }
    }

    /**
     * You are no need to synchronize consumer function execution here, because vertexesSet() returns a new Set every time.
     * But you must use the readLock to call vertexesSet(), because it is not thread-safe inside.
     *
     * @param consumer consumer function
     */
    @Override
    public void applyToAllVertexes(Consumer<V> consumer) {
        Set<V> ps;
        try {
            readLock.lock();
            ps = edgeProvider.vertexesSet();
        } finally {
            readLock.unlock();
        }
        ps.forEach(consumer);
    }

    @Override
    public boolean hasEdge(V vertex1, V vertex2) {
        try {
            readLock.lock();
            return edgeProvider.hasEdge(vertex1, vertex2);
        } finally {
            readLock.unlock();
        }
    }

    public Set<V> getNeighbours(V vertex) {
        try {
            readLock.lock();
            return edgeProvider.getNeighbours(vertex);
        } finally {
            readLock.unlock();
        }
    }

    private void checkSelfLoop(V vertex1, V vertex2) {
        if (Objects.equals(vertex1, vertex2))
            throw new IllegalArgumentException("Cycles not allowed!");
    }

    private void assertVertexExists(V vertex) {
        if (!containsVertex(vertex))
            throw new IllegalArgumentException("No such vertex: " + vertex);
    }
}