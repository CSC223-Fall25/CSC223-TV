package csc223.tv;

public class VertexDistance implements Comparable<VertexDistance> {
    int vertex;
    double distance;

    VertexDistance(int vertex, double distance) {
        this.vertex = vertex;
        this.distance = distance;
    }
    
    @Override
    public int compareTo(VertexDistance other) {
        if (this.distance < other.distance) {
            return -1;}
        if (this.distance > other.distance){
            return 1;}

        return 0;
    }
}