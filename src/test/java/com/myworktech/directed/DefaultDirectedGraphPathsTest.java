package com.myworktech.directed;


import com.myworktech.DefaultDirectedGraph;
import com.myworktech.edge.DefaultDirectedEdge;
import com.myworktech.pathFinder.DefaultPath;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class DefaultDirectedGraphPathsTest {
/*
    @Test(expected = IllegalArgumentException.class)
    public void vertexesNotExist() {
        DefaultDirectedGraph<Object> graph = new DefaultDirectedGraph<>();
        Object vertex1 = new Object();
        Object vertex2 = new Object();

        graph.getPath(vertex1, vertex2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void oneVertexNotExist() {
        DefaultDirectedGraph<Object> graph = new DefaultDirectedGraph<>();
        Object vertex1 = new Object();
        Object vertex2 = new Object();
        graph.addVertex(vertex1);

        graph.getPath(vertex1, vertex2);
    }

    @Test
    public void noEdgesExist() {
        DefaultDirectedGraph<Object> graph = new DefaultDirectedGraph<>();
        Object vertex1 = new Object();
        graph.addVertex(vertex1);

        Set<DefaultPath<Object>> paths = graph.getPath(vertex1, vertex1);
        Assert.assertEquals(0, paths.size());
    }

    @Test
    public void noEdgesExist3() {
        DefaultDirectedGraph<Object> graph = new DefaultDirectedGraph<>();
        Object vertex1 = new Object();
        Object vertex2 = new Object();
        graph.addVertex(vertex1);
        graph.addVertex(vertex2);

        Set<DefaultPath<Object>> paths = graph.getPath(vertex1, vertex2);
        Assert.assertEquals(0, paths.size());
    }

    @Test
    public void noEdgesExist2() {
        DefaultDirectedGraph<Object> graph = new DefaultDirectedGraph<>();
        Object vertex1 = new Object();
        Object vertex2 = new Object();
        Object vertex3 = new Object();
        Object vertex4 = new Object();
        graph.addVertex(vertex1);
        graph.addVertex(vertex2);
        graph.addVertex(vertex3);
        graph.addVertex(vertex4);

        graph.addEdge(vertex1, vertex2);
        graph.addEdge(vertex3, vertex4);


        Set<DefaultPath<Object>> paths = graph.getPath(vertex1, vertex4);
        Assert.assertEquals(0, paths.size());
    }

    @Test
    public void getPathOneTwo() {
        DefaultDirectedGraph<Object> graph = new DefaultDirectedGraph<>();
        Object vertex1 = new Object();
        Object vertex2 = new Object();
        graph.addVertex(vertex1);
        graph.addVertex(vertex2);

        graph.addEdge(vertex1, vertex2);


        Set<DefaultPath<Object>> expectedPaths = new HashSet<>();

        DefaultPath<Object> path1 = new DefaultPath<>();
        path1.add(new DefaultDirectedEdge<>(vertex1, vertex2));
        expectedPaths.add(path1);

        Set<DefaultPath<Object>> actualPaths = graph.getPath(vertex1, vertex2);

        Assert.assertEquals(expectedPaths, actualPaths);
    }

    @Test
    public void checkGraphIsDirected() {
        DefaultDirectedGraph<Object> graph = new DefaultDirectedGraph<>();
        Object vertex1 = new Object();
        Object vertex2 = new Object();
        graph.addVertex(vertex1);
        graph.addVertex(vertex2);

        graph.addEdge(vertex1, vertex2);

        Set<DefaultPath<Object>> paths = graph.getPath(vertex2, vertex1);
        Assert.assertTrue(paths.isEmpty());
    }

    @Test
    public void getPathOneTwoThree() {
        DefaultDirectedGraph<Object> graph = new DefaultDirectedGraph<>();
        Object vertex1 = new Object();
        Object vertex2 = new Object();
        Object vertex3 = new Object();
        graph.addVertex(vertex1);
        graph.addVertex(vertex2);
        graph.addVertex(vertex3);

        graph.addEdge(vertex1, vertex2);
        graph.addEdge(vertex2, vertex3);

        Set<DefaultPath<Object>> expectedPaths = new HashSet<>();

        DefaultPath<Object> path1 = new DefaultPath<>();
        path1.add(new DefaultDirectedEdge<>(vertex1, vertex2));
        path1.add(new DefaultDirectedEdge<>(vertex2, vertex3));
        expectedPaths.add(path1);

        Set<DefaultPath<Object>> actualPaths = graph.getPath(vertex1, vertex3);

        Assert.assertEquals(expectedPaths, actualPaths);
    }

    @Test
    public void getTwoPathsOneTwoThree() {
        DefaultDirectedGraph<Object> graph = new DefaultDirectedGraph<>();
        Object vertex1 = "1";
        Object vertex2 = "2";
        Object vertex3 = "3";
        graph.addVertex(vertex1);
        graph.addVertex(vertex2);
        graph.addVertex(vertex3);

        graph.addEdge(vertex1, vertex2);
        graph.addEdge(vertex2, vertex3);
        graph.addEdge(vertex1, vertex3);

        Set<DefaultPath<Object>> expectedPaths = new HashSet<>();

        DefaultPath<Object> path1 = new DefaultPath<>();
        path1.add(new DefaultDirectedEdge<>(vertex1, vertex2));
        path1.add(new DefaultDirectedEdge<>(vertex2, vertex3));
        expectedPaths.add(path1);

        DefaultPath<Object> path2 = new DefaultPath<>();
        path2.add(new DefaultDirectedEdge<>(vertex1, vertex3));
        expectedPaths.add(path2);

        Set<DefaultPath<Object>> actualPaths = graph.getPath(vertex1, vertex3);

        Assert.assertEquals(expectedPaths, actualPaths);
    }


    @Test
    public void getPath4() throws Throwable {
        DefaultDirectedGraph<String> graph = new DefaultDirectedGraph<>();
        String vertex1 = "1";
        String vertex2 = "2";
        String vertex3 = "3";
        String vertex4 = "4";
        String vertex5 = "5";
        String vertex6 = "6";
        String vertex7 = "7";
        String vertex8 = "8";
        graph.addVertex(vertex1);
        graph.addVertex(vertex2);
        graph.addVertex(vertex3);
        graph.addVertex(vertex4);
        graph.addVertex(vertex5);
        graph.addVertex(vertex6);
        graph.addVertex(vertex7);
        graph.addVertex(vertex8);

        graph.addEdge(vertex1, vertex2);
        graph.addEdge(vertex1, vertex4);
        graph.addEdge(vertex4, vertex7);
        graph.addEdge(vertex2, vertex7);
        graph.addEdge(vertex7, vertex8);
        graph.addEdge(vertex8, vertex5);

        Set<DefaultPath<String>> expectedPaths = new HashSet<>();

        DefaultPath<String> path1 = new DefaultPath<>();
        path1.add(new DefaultDirectedEdge<>("1", "2"));
        path1.add(new DefaultDirectedEdge<>("2", "7"));
        path1.add(new DefaultDirectedEdge<>("7", "8"));
        expectedPaths.add(path1);

        DefaultPath<String> path2 = new DefaultPath<>();
        path2.add(new DefaultDirectedEdge<>("1", "4"));
        path2.add(new DefaultDirectedEdge<>("4", "7"));
        path2.add(new DefaultDirectedEdge<>("7", "8"));
        expectedPaths.add(path2);

        Set<DefaultPath<String>> actualPaths = graph.getPath(vertex1, vertex8);

        Assert.assertEquals(expectedPaths, actualPaths);
    }

    @Test
    public void getPath44() throws Throwable {
        DefaultDirectedGraph<String> graph = new DefaultDirectedGraph<>();
        String vertex1 = "1";
        String vertex2 = "2";
        String vertex3 = "3";
        String vertex4 = "4";
        String vertex5 = "5";
        String vertex6 = "6";
        String vertex7 = "7";
        String vertex8 = "8";
        graph.addVertex(vertex1);
        graph.addVertex(vertex2);
        graph.addVertex(vertex3);
        graph.addVertex(vertex4);
        graph.addVertex(vertex5);
        graph.addVertex(vertex6);
        graph.addVertex(vertex7);
        graph.addVertex(vertex8);

        graph.addEdge(vertex1, vertex2);
        graph.addEdge(vertex1, vertex4);
        graph.addEdge(vertex4, vertex7);
        graph.addEdge(vertex2, vertex3);
        graph.addEdge(vertex2, vertex7);
        graph.addEdge(vertex7, vertex8);
        graph.addEdge(vertex8, vertex5);

        Set<DefaultPath<String>> expectedPaths = new HashSet<>();

        DefaultPath<String> path1 = new DefaultPath<>();
        path1.add(new DefaultDirectedEdge<>("1", "2"));
        path1.add(new DefaultDirectedEdge<>("2", "7"));
        path1.add(new DefaultDirectedEdge<>("7", "8"));
        path1.add(new DefaultDirectedEdge<>("8", "5"));
        expectedPaths.add(path1);

        DefaultPath<String> path2 = new DefaultPath<>();
        path2.add(new DefaultDirectedEdge<>("1", "4"));
        path2.add(new DefaultDirectedEdge<>("4", "7"));
        path2.add(new DefaultDirectedEdge<>("7", "8"));
        path2.add(new DefaultDirectedEdge<>("8", "5"));
        expectedPaths.add(path2);

        Set<DefaultPath<String>> actualPaths = graph.getPath(vertex1, vertex5);

        Assert.assertEquals(expectedPaths, actualPaths);
    }

    @Test
    public void getPath444() throws Throwable {
        DefaultDirectedGraph<String> graph = new DefaultDirectedGraph<>();
        String vertex1 = "1";
        String vertex2 = "2";
        String vertex3 = "3";
        String vertex4 = "4";
        String vertex5 = "5";
        String vertex6 = "6";
        String vertex7 = "7";
        String vertex8 = "8";
        graph.addVertex(vertex1);
        graph.addVertex(vertex2);
        graph.addVertex(vertex3);
        graph.addVertex(vertex4);
        graph.addVertex(vertex5);
        graph.addVertex(vertex6);
        graph.addVertex(vertex7);
        graph.addVertex(vertex8);

        graph.addEdge(vertex1, vertex2);
        graph.addEdge(vertex1, vertex4);
        graph.addEdge(vertex4, vertex7);
        graph.addEdge(vertex2, vertex5);
        graph.addEdge(vertex2, vertex3);
        graph.addEdge(vertex2, vertex7);
        graph.addEdge(vertex7, vertex8);
        graph.addEdge(vertex8, vertex5);
        graph.addEdge(vertex3, vertex7);

        Set<DefaultPath<String>> expectedPaths = new HashSet<>();

        DefaultPath<String> path1 = new DefaultPath<>();
        path1.add(new DefaultDirectedEdge<>("1", "2"));
        path1.add(new DefaultDirectedEdge<>("2", "7"));
        path1.add(new DefaultDirectedEdge<>("7", "8"));
        path1.add(new DefaultDirectedEdge<>("8", "5"));
        expectedPaths.add(path1);

        DefaultPath<String> path2 = new DefaultPath<>();
        path2.add(new DefaultDirectedEdge<>("1", "4"));
        path2.add(new DefaultDirectedEdge<>("4", "7"));
        path2.add(new DefaultDirectedEdge<>("7", "8"));
        path2.add(new DefaultDirectedEdge<>("8", "5"));
        expectedPaths.add(path2);

        DefaultPath<String> path3 = new DefaultPath<>();
        path3.add(new DefaultDirectedEdge<>("1", "2"));
        path3.add(new DefaultDirectedEdge<>("2", "5"));
        expectedPaths.add(path3);

        DefaultPath<String> path4 = new DefaultPath<>();
        path4.add(new DefaultDirectedEdge<>("1", "2"));
        path4.add(new DefaultDirectedEdge<>("2", "3"));
        path4.add(new DefaultDirectedEdge<>("3", "7"));
        path4.add(new DefaultDirectedEdge<>("7", "8"));
        path4.add(new DefaultDirectedEdge<>("8", "5"));
        expectedPaths.add(path4);

        Set<DefaultPath<String>> actualPaths = graph.getPath(vertex1, vertex5);

        Assert.assertEquals(expectedPaths, actualPaths);
    }

 */
}