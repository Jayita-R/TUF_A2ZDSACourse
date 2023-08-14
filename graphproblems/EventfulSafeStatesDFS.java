package tuf_a2zdsacourse.graphproblems;

import java.util.ArrayList;
import java.util.List;

public class EventfulSafeStatesDFS {
    public static void main(String[] args) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(0).add(1);
        adj.get(1).add(2);
        adj.get(2).add(3);
        adj.get(2).add(4);
        adj.get(3).add(4);
        adj.get(3).add(5);
        adj.get(4).add(6);
        adj.get(5).add(6);
        adj.get(6).add(7);
        adj.get(8).add(1);
        adj.get(8).add(9);
        adj.get(9).add(10);
        adj.get(10).add(8);
        adj.get(11).add(9);

        EventfulSafeStatesDFS obj = new EventfulSafeStatesDFS();
        List<Integer> safeNodes = obj.eventualSafeNodes(12, adj);

        for (int node : safeNodes) {
            System.out.print(node + " ");
        }
        System.out.println("");
    }

    private List<Integer> eventualSafeNodes(int v, List<List<Integer>> adj) {
        int vis[]=new int[v];
        int pathVis[]=new int[v];
        int check[]=new int[v];
        for(int i=0;i<v;i++){
            if(vis[i]==0){
                dfsCheck(i,adj,vis,pathVis,check);
            }
        }
        List<Integer> ls=new ArrayList<>();
        for(int i=0;i<v;i++){
            if(check[i]==1) ls.add(i);
        }
        return ls;
    }

    private boolean dfsCheck(int node, List<List<Integer>> adj, int[] vis, int[] pathVis, int[] check) {
        vis[node]=1;
        pathVis[node]=1;
        check[node]=0;
        for(int it:adj.get(node)){
            if(vis[it]==0){
                if(dfsCheck(it,adj,vis,pathVis,check)==true) return true;
            }else if(pathVis[it]==1) return true;
        }
        check[node]=1;
        pathVis[node]=0;
        return false;
    }
}
