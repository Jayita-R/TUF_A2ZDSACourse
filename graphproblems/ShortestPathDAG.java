package tuf_a2zdsacourse.graphproblems;

import java.util.ArrayList;
import java.util.Stack;

/*class Pair {
    int first, second;
    Pair(int _first, int _second) {
        this.first = _first;
        this.second = _second;
    }
}*/
//using topo sort of DFS algo
public class ShortestPathDAG {
    public static void main(String[] args) {
        int n = 6, m = 7;
        int[][] edge = {{0,1,2},{0,4,1},{4,5,4},{4,2,2},{1,2,3},{2,3,6},{5,3,1}};
        ShortestPathDAG obj = new ShortestPathDAG();
        int res[] = obj.shortestPath(n, m, edge);
        for (int i = 0; i < n; i++) {
            System.out.print(res[i] + " ");
        }
        System.out.println();
    }

    private int[] shortestPath(int n, int m, int[][] edge) {
        ArrayList<ArrayList<Pair>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            ArrayList<Pair> temp=new ArrayList<>();
            adj.add(temp);
        }
        //We create a graph first in the form of an adjacency list.
        for(int i=0;i<m;i++){
            int u=edge[i][0];
            int v=edge[i][1];
            int wt=edge[i][2];
            adj.get(u).add(new Pair(v,wt));
        }
        int vis[] = new int[n];
        //Now, we perform topo sort using DFS technique
        //and store the result in the stack st.
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<n;i++){
            if(vis[i]==0){
                topoSort(i,adj,vis,st);
            }
        }
        //Further, we declare a vector ‘dist’ in which we update the value of the nodes’
        //distance from the source vertex after relaxation of a particular node.
        int[] dist=new int[n];
        for(int i=0;i<n;i++){
            dist[i]=(int)(1e9);
        }
        dist[0]=0;
        while(!st.isEmpty()){
            int node=st.peek();
            st.pop();
            for(int i=0;i<adj.get(node).size();i++){
                int v=adj.get(node).get(i).first;
                int wt=adj.get(node).get(i).second;

                if(dist[node]+wt<dist[v]){
                    dist[v]=dist[node]+wt;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (dist[i] == 1e9) dist[i] = -1;
        }
        return dist;
    }

    private void topoSort(int node, ArrayList<ArrayList<Pair>> adj, int[] vis, Stack<Integer> st) {
        vis[node]=1;
        for(int i=0;i<adj.get(node).size();i++){
            int v=adj.get(node).get(i).first;
            if(vis[v]==0){
                topoSort(v,adj,vis,st);
            }
        }
        st.add(node);
    }
}
