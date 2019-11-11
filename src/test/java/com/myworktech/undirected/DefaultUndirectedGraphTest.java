package com.myworktech.undirected;


import com.myworktech.DefaultUndirectedGraph;
import org.junit.Assert;
import org.junit.Test;

public class DefaultUndirectedGraphTest {

    @Test
    public void checkContainsNotExistentVertex() {
        DefaultUndirectedGraph<Object> graph = new DefaultUndirectedGraph<>();
        Object vertex1 = new Object();

        Assert.assertFalse(graph.containsVertex(vertex1));
    }

    @Test
    public void checkContainsExistentVertex() {
        DefaultUndirectedGraph<Object> graph = new DefaultUndirectedGraph<>();
        Object vertex1 = new Object();
        graph.addVertex(vertex1);

        Assert.assertTrue(graph.containsVertex(vertex1));
    }

    @Test
    public void checkContainsTwoAddedVertexes() {
        DefaultUndirectedGraph<Object> graph = new DefaultUndirectedGraph<>();
        Object vertex1 = new Object();
        Object vertex2 = new Object();
        graph.addVertex(vertex1);
        graph.addVertex(vertex2);

        Assert.assertTrue(graph.containsVertex(vertex1));
        Assert.assertTrue(graph.containsVertex(vertex2));
    }

    @Test(expected = IllegalArgumentException.class)
    public void addEdgeNotExistentVertexes() {
        DefaultUndirectedGraph<Object> graph = new DefaultUndirectedGraph<>();
        Object vertex1 = new Object();
        Object vertex2 = new Object();

        graph.addEdge(vertex1, vertex2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void addEdgePartlyExistentVertexes() {
        DefaultUndirectedGraph<Object> graph = new DefaultUndirectedGraph<>();
        Object vertex1 = new Object();
        Object vertex2 = new Object();
        graph.addVertex(vertex1);

        graph.addEdge(vertex1, vertex2);
    }

    @Test
    public void checkContainsAddedEdge() {
        DefaultUndirectedGraph<Object> graph = new DefaultUndirectedGraph<>();
        Object vertex1 = new Object();
        Object vertex2 = new Object();
        graph.addVertex(vertex1);
        graph.addVertex(vertex2);

        graph.addEdge(vertex1, vertex2);

        Assert.assertTrue(graph.hasEdge(vertex1, vertex2));
    }

    @Test
    public void checkContainsNotAddedEdge() {
        DefaultUndirectedGraph<Object> graph = new DefaultUndirectedGraph<>();
        Object vertex1 = new Object();
        Object vertex2 = new Object();
        graph.addVertex(vertex1);
        graph.addVertex(vertex2);

        Assert.assertFalse(graph.hasEdge(vertex1, vertex2));
    }

    @Test
    public void checkContainsNotAddedEdge_UndirectedGraph() {
        DefaultUndirectedGraph<Object> graph = new DefaultUndirectedGraph<>();
        Object vertex1 = "1";
        Object vertex2 = "2";
        graph.addVertex(vertex1);
        graph.addVertex(vertex2);

        graph.addEdge(vertex1, vertex2);

        Assert.assertTrue(graph.hasEdge(vertex2, vertex1));
    }


    @Test(expected = IllegalArgumentException.class)
    public void selfLoopNotAllowed() {
        DefaultUndirectedGraph<Object> graph = new DefaultUndirectedGraph<>();
        Object vertex1 = new Object();
        graph.addVertex(vertex1);

        graph.addEdge(vertex1, vertex1);
    }
}