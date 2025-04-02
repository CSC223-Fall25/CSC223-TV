package csc223.tv;

import java.util.PriorityQueue;

public class WeightedGraph extends UnweightedGraph implements WeightedGraphInterface{

    private double[][] adjmatrix;
    static final double INFINITY = Double.POSITIVE_INFINITY; 

    public WeightedGraph(int vertices) {
        super(vertices);
        adjmatrix = new double[vertices][vertices];

        //represent the matrix 
        for (int i =0; i < ver_num; i++) {
            for (int j = 0; j < ver_num; j++){
                adjmatrix[i][j] = INFINITY;
            }
        }

    }

    public void addEdge(int v1, int v2, double weight) {
        // assuming vertices are 0-based 
        if (v1 >= 0 && v1< ver_num && v2 >=0 && v2 < ver_num){
            adjmatrix[v1][v2] = weight;
        }

    }

    
    public double getEdgeWeight(int v1, int v2){
        if (v1 >= 0 && v1 < ver_num && v2 >=0 && v2 < ver_num){
            return adjmatrix[v1][v2];
        }
        return INFINITY;

    }

    public String shortestPath(int startVertex, int endVertex){
        
        double[] distance = new double[ver_num];
        int[] predecesor = new int[ver_num];
        boolean[] visited= new boolean[ver_num];

        //initialize the distance
        for (int i = 0; i < ver_num; i++){
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

            for (int i =0; i < ver_num; i++) {
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
}
