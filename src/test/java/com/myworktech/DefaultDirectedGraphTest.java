package com.myworktech;


import org.junit.Assert;
import org.junit.Test;

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

        Assert.assertTrue(graph.containsEdge(vertex1, vertex2));
    }

    @Test
    public void checkContainsNotAddedEdge() {
        DefaultDirectedGraph<Object> graph = new DefaultDirectedGraph<>();
        Object vertex1 = new Object();
        Object vertex2 = new Object();
        graph.addVertex(vertex1);
        graph.addVertex(vertex2);

        Assert.assertFalse(graph.containsEdge(vertex1, vertex2));
    }

    @Test
    public void checkContainsNotAddedEdge_DirectedGraph() {
        DefaultDirectedGraph<Object> graph = new DefaultDirectedGraph<>();
        Object vertex1 = new Object();
        Object vertex2 = new Object();
        graph.addVertex(vertex1);
        graph.addVertex(vertex2);

        graph.addEdge(vertex1, vertex2);

        Assert.assertFalse(graph.containsEdge(vertex2, vertex1));
    }


    @Test(expected = IllegalArgumentException.class)
    public void cyclesNotAllowed() {
        DefaultDirectedGraph<Object> graph = new DefaultDirectedGraph<>();
        Object vertex1 = new Object();
        graph.addVertex(vertex1);

        graph.addEdge(vertex1, vertex1);
    }
}