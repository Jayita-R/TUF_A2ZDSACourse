package tuf_a2zdsacourse.graphproblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BridgesInGraph {
    public static void main(String[] args) {
        int n = 4;
        int[][] edges = {
                {0, 1}, {1, 2},
                {2, 0}, {1, 3}
        };
        List<List<Integer>> connections = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            connections.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < n; i++) {
            connections.get(i).add(edges[i][0]);
            connections.get(i).add(edges[i][1]);
        }

        BridgesInGraph obj = new BridgesInGraph();
        List<List<Integer>> bridges = obj.criticalConnections(n, connections);

        int size = bridges.size();
        for (int i = 0; i < size; i++) {
            int u = bridges.get(i).get(0);
            int v = bridges.get(i).get(1);
            System.out.print("[" + u + ", " + v + "] ");
        }
        System.out.println("");
    }

    private List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(List<Integer> it:connections){
            int u=it.get(0);
            int v=it.get(1);
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        int[] vis=new int[n];
        int[] tin=new int[n];
        int[] low=new int[n];
        List<List<Integer>> brid=new ArrayList<>();
        dfs(0,-1,vis,adj,tin,low,brid);
        return brid;
    }
    private int timer=1;
    private void dfs(int node, int par, int[] vis, ArrayList<ArrayList<Integer>> adj, int[] tin,
                     int[] low, List<List<Integer>> brid) {
        vis[node]=1;
        tin[node]=low[node]=timer;
        timer++;
        for(Integer it:adj.get(node)){
            if(it==par) continue;
            if(vis[it]==0){
                dfs(it,node,vis,adj,tin,low,brid);
                low[node]=Math.min(low[node],low[it]);

                // node --- it
                if (low[it] > tin[node]) {
                    brid.add(Arrays.asList(it, node));
                }
            }else {
                low[node] = Math.min(low[node], low[it]);
            }
        }
    }
}
