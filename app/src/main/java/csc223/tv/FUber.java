package csc223.tv;

public class FUber {

    public static float euclidean(float x1, float y1, float x2, float y2) {
        // Implement the method here
        return (float) Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow(y2 - y1, 2));
    }

    public static float manhattan(float x1, float y1, float x2, float y2) {
        // Implement the method here
        return (float) Math.abs(x2- x1) - Math.abs(y2-y1);
    }
}