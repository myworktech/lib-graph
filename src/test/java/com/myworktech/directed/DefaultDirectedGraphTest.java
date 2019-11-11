package com.myworktech.directed;


import com.myworktech.DefaultDirectedGraph;
import org.junit.Assert;
import org.junit.Test;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;

public class DefaultDirectedGraphTest {

    @Test
    public void checkContainsNotExistentVertex() {
        DefaultDirectedGraph<Object> graph = new DefaultDirectedGraph<>();
        Object vertex1 = new Object();

        Assert.assertFalse(graph.containsVertex(vertex1));
    }

    @Test
    public void checkContainsExistentVertex() {
        DefaultDirectedGraph<Object> graph = new DefaultDirectedGraph<>();
        Object vertex1 = new Object();
        graph.addVertex(vertex1);

        Assert.assertTrue(graph.containsVertex(vertex1));
    }

    @Test
    public void checkContainsTwoAddedVertexes() {
        DefaultDirectedGraph<Object> graph = new DefaultDirectedGraph<>();
        Object vertex1 = new Object();
        Object vertex2 = new Object();
        graph.addVertex(vertex1);
        graph.addVertex(vertex2);

        Assert.assertTrue(graph.containsVertex(vertex1));
        Assert.assertTrue(graph.containsVertex(vertex2));
    }

    @Test(expected = IllegalArgumentException.class)
    public void addEdgeNotExistentVertexes() {
        DefaultDirectedGraph<Object> graph = new DefaultDirectedGraph<>();
        Object vertex1 = new Object();
        Object vertex2 = new Object();

        graph.addEdge(vertex1, vertex2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void addEdgePartlyExistentVertexes() {
        DefaultDirectedGraph<Object> graph = new DefaultDirectedGraph<>();
        Object vertex1 = new Object();
        Object vertex2 = new Object();
        graph.addVertex(vertex1);

        graph.addEdge(vertex1, vertex2);
    }

    @Test
    public void checkContainsAddedEdge() {
        DefaultDirectedGraph<Object> graph = new DefaultDirectedGraph<>();
        Object vertex1 = new Object();
        Object vertex2 = new Object();
        graph.addVertex(vertex1);
        graph.addVertex(vertex2);

        graph.addEdge(vertex1, vertex2);

        Assert.assertTrue(graph.hasEdge(vertex1, vertex2));
    }

    @Test
    public void checkContainsNotAddedEdge() {
        DefaultDirectedGraph<Object> graph = new DefaultDirectedGraph<>();
        Object vertex1 = new Object();
        Object vertex2 = new Object();
        graph.addVertex(vertex1);
        graph.addVertex(vertex2);

        Assert.assertFalse(graph.hasEdge(vertex1, vertex2));
    }

    @Test
    public void checkDirectedEdge() {
        DefaultDirectedGraph<Object> graph = new DefaultDirectedGraph<>();
        Object vertex1 = new Object();
        Object vertex2 = new Object();
        graph.addVertex(vertex1);
        graph.addVertex(vertex2);

        graph.addEdge(vertex1, vertex2);

        Assert.assertFalse(graph.hasEdge(vertex2, vertex1));
        Assert.assertTrue(graph.hasEdge(vertex1, vertex2));
    }


    @Test(expected = IllegalArgumentException.class)
    public void selfLoopNotAllowed() {
        DefaultDirectedGraph<Object> graph = new DefaultDirectedGraph<>();
        Object vertex1 = new Object();
        graph.addVertex(vertex1);

        graph.addEdge(vertex1, vertex1);
    }

    @Test
    public void traverse() {
        DefaultDirectedGraph<Integer> graph = new DefaultDirectedGraph<>();
        Integer vertex1 = 1;
        Integer vertex2 = 2;
        Integer vertex3 = 3;

        graph.addVertex(vertex1);
        graph.addVertex(vertex2);
        graph.addVertex(vertex3);

        AtomicInteger intAdder = new AtomicInteger(0);
        graph.applyToAllVertexes(integer -> intAdder.addAndGet(integer));

        Assert.assertEquals(6, intAdder.get());
    }
}