package csc223.tv;

import java.util.PriorityQueue;

public class WeightedGraph implements WeightedGraphInterface{

    private double[][] adjmatrix;
    int numVertices;
    static final double INFINITY = Double.POSITIVE_INFINITY; 

    public WeightedGraph(int vertices) {
        numVertices = vertices;
        adjmatrix = new double[vertices][vertices];

        //represent the matrix 
        for (int i =0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++){
                adjmatrix[i][j] = INFINITY;
            }
        }

    }

    public void addEdge(int v1, int v2, double weight) {
        // assuming vertices are 0-based 
        if (v1 >= 0 && v1< numVertices && v2 >=0 && v2 < numVertices){
            adjmatrix[v1][v2] = weight;
        }

    }

    
    public double getEdgeWeight(int v1, int v2){
        if (v1 >= 0 && v1 < numVertices && v2 >=0 && v2 < numVertices){
            return adjmatrix[v1][v2];
        }
        return INFINITY;

    }

    public String shortestPath(int startVertex, int endVertex){
        
        double[] distance = new double[numVertices];
        int[] predecesor = new int[numVertices];
        boolean[] visited= new boolean[numVertices];

        //initialize the distance
        for (int i = 0; i < numVertices; i++){
            distance[i] = INFINITY;
            predecesor[i] = -1;
            visited[i] = false;
        }
        distance[startVertex] = 0;

        PriorityQueue<VertexDistance> pq = new PriorityQueue<>();
        pq.offer(new VertexDistance(startVertex, 0));

        while (pq.isEmpty() == false) {
            VertexDistance current = pq.poll();
            int vertex = current.vertex;

            if (visited[vertex]) {
                continue;
            }
            visited[vertex] = true;

            if (vertex == endVertex) {
                break;
            }

            for (int i =0; i < numVertices; i++) {
                if (visited[i] || adjmatrix[vertex][i] == INFINITY ) {
                    continue;
                }

                double newDist = distance[vertex] + adjmatrix[vertex][i];
                if (newDist < distance[i]) {
                    distance[i] = newDist;
                    predecesor[i] = vertex;
                    pq.offer(new VertexDistance(i, newDist));
                }

                
            }

        }

        if (distance[endVertex] == INFINITY){
            return "No path";
        }

        StringBuilder path = new StringBuilder();
        int current = endVertex;
        while (current != -1) {
            path.insert(0, current + " ");
            current = predecesor[current];
        }

        return "Shortest path: " + path.toString().trim();
    }

    public static void main(String[] args) {
        WeightedGraph graph = new WeightedGraph(4);
        graph.addEdge(0, 1, 4.0);
        graph.addEdge(0, 2, 1.0);
        graph.addEdge(2, 1, 2.0);
        graph.addEdge(1, 3, 5.0);
        System.out.println(graph.shortestPath(0, 3));  // Should print "Shortest path: 0 2 1 3"
    }
}
