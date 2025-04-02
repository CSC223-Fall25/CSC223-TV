package csc223.tv;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.junit.jupiter.api.Assertions.assertFalse;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;

 

public class GraphTest {

   

    private UnweightedGraph unweightedGraph;

    private WeightedGraph weightedGraph;

 

    @BeforeEach

    public void setup() {

        unweightedGraph = new UnweightedGraph(4);

        weightedGraph = new WeightedGraph(4);

 

        // Unweighted Graph

        //   A  B  C  D

        // A 0  1  1  0

        // B 1  0  1  0

        // C 1  1  0  1

        // D 0  0  1  0

 

        unweightedGraph.addEdge(0, 1);

        unweightedGraph.addEdge(0, 2);

        unweightedGraph.addEdge(1, 0);

        unweightedGraph.addEdge(1, 2);

        unweightedGraph.addEdge(2, 0);

        unweightedGraph.addEdge(2, 1);

        unweightedGraph.addEdge(2, 3);

        unweightedGraph.addEdge(3, 2);

       

        // Weighted Graph

        //   A  B  C  D

        // A 0  2  5  0

        // B 2  0  1  0

        // C 5  1  0  3

        // D 0  0  3  0

        weightedGraph.addEdge(0, 1, 2);

        weightedGraph.addEdge(0, 2, 5);

        weightedGraph.addEdge(1, 0, 2);

        weightedGraph.addEdge(1, 2, 1);

        weightedGraph.addEdge(2, 0, 5);

        weightedGraph.addEdge(2, 1, 1);

        weightedGraph.addEdge(2, 3, 3);

        weightedGraph.addEdge(3, 2, 3);

    }

 

    @Test

    public void testAddEdge(){

        assertTrue(unweightedGraph.hasEdge(0, 1));

        assertTrue(unweightedGraph.hasEdge(0, 2));

        assertTrue(unweightedGraph.hasEdge(1, 2));

        assertTrue(unweightedGraph.hasEdge(2, 3));

 

        assertFalse(unweightedGraph.hasEdge(0, 0));

 

        assertTrue(weightedGraph.hasEdge(0, 1));

        assertTrue(weightedGraph.hasEdge(0, 2));

        assertTrue(weightedGraph.hasEdge(1, 2));

        assertTrue(weightedGraph.hasEdge(2, 3));

 

        assertFalse(weightedGraph.hasEdge(0, 0));

    }

 

    @Test

    public void testRemoveEdge(){

        unweightedGraph.removeEdge(0,1);

        assertFalse(unweightedGraph.hasEdge(0,1));

        weightedGraph.removeEdge(2,3);

        assertFalse(unweightedGraph.hasEdge(2,3));

    }

 

    @Test

    public void testGetNeighbors(){

        int[] expected0 = {1, 2};

        assertEquals(expected0, unweightedGraph.getNeighbors(0));

       

        int[] expected1 = {0, 2};

        assertEquals(expected1, unweightedGraph.getNeighbors(1));

       

        int[] expected2 = {0, 1, 3};

        assertEquals(expected2, unweightedGraph.getNeighbors(2));

 

        int[] expected3 = {0, 1, 3};

        assertArrayEquals(expected3, weightedGraph.getNeighbors(2));

    }

 

    @Test

    public void testGetNumVertices(){

        assertEquals(4, unweightedGraph.getNumVertices());

        assertEquals(4, weightedGraph.getNumVertices());

    }

 

    @Test

    public void testGetEdgeWeight(){

        assertEquals(2, weightedGraph.getEdgeWeight(0, 1));

        assertEquals(5, weightedGraph.getEdgeWeight(0, 2));

        assertEquals(1, weightedGraph.getEdgeWeight(1, 2));

        assertEquals(3, weightedGraph.getEdgeWeight(2, 3));

    }

 

}