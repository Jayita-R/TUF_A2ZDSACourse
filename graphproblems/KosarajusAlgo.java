package tuf_a2zdsacourse.graphproblems;

import java.util.ArrayList;
import java.util.Stack;

public class KosarajusAlgo {
    public static void main(String[] args) {
        int n=5;
        int[][] edges={{1,0},{0,2},{2,1},{0,3},{3,4}};
        //int[][] edges={{0,1},{1,2},{2,0},{2,3},{3,4},{4,5},{4,7},{5,6},{6,4},{6,7}};
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            adj.get(edges[i][0]).add(edges[i][1]);
        }
        KosarajusAlgo ob=new KosarajusAlgo();
        int ans=ob.kosaraju(n,adj);
        System.out.println("The number of strongly connected components is: " + ans);

    }

    private int kosaraju(int v, ArrayList<ArrayList<Integer>> adj) {
        int[] vis=new int[v];
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<v;i++){
            if(vis[i]==0){
                dfs(i,vis,adj,st);
            }
        }
        ArrayList<ArrayList<Integer>> adjT=new ArrayList<>();
        for(int i=0;i<v;i++){
            adjT.add(new ArrayList<>());
        }
        for(int i=0;i<v;i++){
            vis[i]=0;
            for(Integer it:adj.get(i)){
                adjT.get(it).add(i);
            }
        }
        int scc=0;
        while(!st.isEmpty()){
            int node=st.peek();
            st.pop();
            if(vis[node]==0){
                scc++;
                dfs3(node,adjT,vis);
            }
        }
        return scc;
    }

    private void dfs3(int node, ArrayList<ArrayList<Integer>> adjT, int[] vis) {
        vis[node]=1;
        for(Integer it:adjT.get(node)){
            if(vis[it]==0){
                dfs3(it,adjT,vis);
            }
        }
    }

    private void dfs(int node, int[] vis, ArrayList<ArrayList<Integer>> adj, Stack<Integer> st) {
        vis[node]=1;
        for(Integer it:adj.get(node)){
            if(vis[it]==0){
                dfs(it,vis,adj,st);
            }
        }
        st.push(node);
    }
}
