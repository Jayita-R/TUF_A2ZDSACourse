package tuf_a2zdsacourse.graphproblems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BipartiteGraphCheck {
    public static void main(String[] args) {
        ArrayList < ArrayList < Integer >> adj = new ArrayList < > ();
        for (int i = 0; i < 9; i++) {
            adj.add(new ArrayList < > ());
        }
        /*
        adj.get(1).add(2);
        adj.get(2).add(1);
        adj.get(2).add(3);
        adj.get(2).add(5);
        adj.get(3).add(2);
        adj.get(3).add(4);
        adj.get(4).add(3);
        adj.get(4).add(5);
        adj.get(4).add(6);
        adj.get(5).add(2);
        adj.get(5).add(4);
        adj.get(6).add(4);
        */


        adj.get(1).add(2);
        adj.get(2).add(1);
        adj.get(2).add(3);
        adj.get(2).add(6);
        adj.get(3).add(2);
        adj.get(3).add(4);
        adj.get(4).add(3);
        adj.get(4).add(7);
        adj.get(4).add(5);
        adj.get(5).add(4);
        adj.get(5).add(6);
        adj.get(6).add(2);
        adj.get(6).add(5);
        adj.get(7).add(4);
        adj.get(7).add(8);
        adj.get(8).add(7);

        BipartiteGraphCheck obj = new BipartiteGraphCheck();
        boolean ans = obj.isBipartite(9, adj);
        if(ans)
            System.out.println("1");
        else System.out.println("0");
    }

    private boolean isBipartite(int v, ArrayList<ArrayList<Integer>> adj) {
        int color[] = new int[v];
        for (int i = 0; i < v; i++) color[i] = -1;
        for(int i=0;i<v;i++){
            if(color[i]==-1){
                if(check(i,v,adj,color)==false){
                    return false;
                }
            }
        }
        return true;
    }

    private boolean check(int st, int v, ArrayList<ArrayList<Integer>> adj, int[] color) {
        Queue<Integer> q=new LinkedList<>();
        q.add(st);
        color[st]=0;
        while(!q.isEmpty()){
            int node=q.peek();
            q.remove();
            for(int it:adj.get(node)){
                if(color[it]==-1){
                    color[it]=1-color[node];
                    q.add(it);
                }
                else if(color[it]==color[node]){
                    return false;
                }
            }
        }
        return true;

    }

}
