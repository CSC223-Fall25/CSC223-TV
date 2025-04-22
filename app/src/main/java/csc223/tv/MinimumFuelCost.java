package csc223.tv;
/**
 * 2477. Minimum Fuel Cost to Report to the Capital
 * https://leetcode.com/problems/minimum-fuel-cost-to-report-to-the-capital/description/?envType=problem-list-v2&envId=tree
 */
import java.util.*;

 class Solution {
    // store total fuel cost
    public long ans = 0;

    public long minimumFuelCost(int[][] roads, int seats) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        

        //building graph 
        for (int[] road : roads){
            int u = road[0];
            int v = road[1];

            if (!graph.containsKey(u)){
                graph.put(u, new ArrayList<>());
            }
            graph.get(u).add(v);

            if (!graph.containsKey(v)){
                graph.put(v, new ArrayList<>());
            }
            graph.get(v).add(u);
    
        }

        // call dfs on first node (with no parents)
        dfs(graph, 0, -1, seats);
        return ans;

    }

    public int dfs(Map<Integer, List<Integer>> graph,  int u, int prev, int seats){

        // initialize the people to 1
        int people = 1;

        //Traversal to all neighbor of node u
        for (int v : graph.getOrDefault(u, new ArrayList<>())) {
            if (v == prev) {
                continue;}
            people += dfs(graph, v, u, seats);
        }
        if (u >0){
            // calculate car need for this node to parent using celi
            ans += (people + seats - 1) / seats;
        }
        return people;
    }
}