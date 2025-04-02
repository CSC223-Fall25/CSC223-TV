package csc223.tv;

/**
 * Class implementing an unweighted graph using an adjacency matrix.
 */
public class UnweightedGraph implements Graph {
    // Implement all methods from the Graph interface
    // Use BFS for the shortestPath method

    private int[][] matrix;
    public int ver_num;

    public UnweightedGraph(int ver_num) {
        this.ver_num = ver_num;
        matrix = new int[ver_num][ver_num];
    }


    public void addEdge(int v1, int v2) {
        matrix[v1][v2] = 1;
        matrix[v2][v1] = 1;
    }

    public void removeEdge(int v1, int v2){
        matrix[v1][v2] = 0;
        matrix[v2][v1] = 0;

    }

    public boolean hasEdge(int v1, int v2){
        return matrix[v1][v2] == 1;
    }


    public int[] getNeighbors(int vertex){
        int n = 0;

        //count neighbors
        for (int i= 0;i<ver_num; i++){
            if (matrix[vertex][i]==1){
                n = n+1;
            }
        }

            //store them
            int[] neighbors = new int[n];
            int ind=0;

            for (int i=0; i<ver_num; i++){
                if (matrix[vertex][i]==1){
                    neighbors[ind] = i;
                    ind = ind+1;}
            }

            return neighbors;
        }



    public int getNumVertices(){ 
        return ver_num;
    }

    public void printGraph(){
        for(int i=0; i <ver_num; i++){
            for(int j=0; j<ver_num; j++){
                System.out.print(matrix[i][j] + " ");}

            System.out.println();
        }

    }


     public String shortestPath(int startVertex, int endVertex){
        
        ArrayQueue q = new ArrayQueue(ver_num*ver_num);
        boolean[] visited = new boolean[ver_num];
        int[] predecessor = new int[ver_num];
    
        q.enqueue(startVertex);
        visited[startVertex] = true;

        while (q.isEmpty()== false) {
            int curr = q.dequeue();

            if (curr==endVertex){
                break;
            }

            for (int i =0; i <ver_num; i++) {

            if (matrix[curr][i]==1 && !visited[i]){
                q.enqueue(i);
                visited[i] = true;
                 predecessor[i] = curr;}
                }}

            
                if (!visited[endVertex]) {
                    return null;
                }

    
                String path = "";
                int current = endVertex;

                while (current != startVertex){
                    path = current + " " + path;
                    current = predecessor[current];
                }
                path = startVertex + " " + path;
                return path;

     }

}
