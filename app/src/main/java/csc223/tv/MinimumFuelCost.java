package csc223.tv;
/**
 * 2477. Minimum Fuel Cost to Report to the Capital
 * https://leetcode.com/problems/minimum-fuel-cost-to-report-to-the-capital/description/?envType=problem-list-v2&envId=tree
 */


class Solution {
    // store total fuel cost
    public long ans = 0;

    public long minimumFuelCost(int[][] roads, int seats) {
        int[][] graph = new int[roads.length + 1][roads.length + 1];
        int[] degree = new int[roads.length + 1];

        //building graph 
        for (int[] road : roads){
            int u = road[0];
            int v = road[1];

            // add u to v's neighbor list and increment degree
            graph[u][degree[u]++] = v;
            // add v to u's neighbor list and increment degree
            graph[v][degree[v]++] = u;
        }

        // call dfs on first node (with no parents)
        dfs(graph, degree, 0, -1, seats);
        return ans;

    }

    public int dfs(int[][] graph, int[] degree, int u, int prev, int seats){

        // initialize the people to 1
        int people = 1;

        //Traversal to all neighbor of node u
        for (int i = 0; i < degree[u]; i ++) {
            int v = graph[u][i];
            if (v == prev){
                continue;
            }
            // add the subtree to the people
            people += dfs(graph, degree, v, u, seats);

        }
        if (u >0){
            // calculate car need for this node to parent using celi
            ans += (people + seats - 1) / seats;
        }
        return people;
    }
}