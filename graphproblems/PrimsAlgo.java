package tuf_a2zdsacourse.graphproblems;

import java.util.ArrayList;
import java.util.PriorityQueue;

class PAPair{
    int node;
    int distance;
    public PAPair(int distance, int node) {
        this.node = node;
        this.distance = distance;
    }
}
public class PrimsAlgo {
    public static void main(String[] args) {
        int V = 5;
        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<ArrayList<ArrayList<Integer>>>();
        //int[][] edges =  {{0, 1, 2}, {0, 2, 1}, {1, 2, 1}, {2, 3, 2}, {3, 4, 1}, {4, 2, 2}};
        int[][] edges={{0, 1, 2}, {0, 3, 6}, {1, 2, 3}, {1, 3, 8}, {1, 4, 5}, {4, 2, 7}};

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<ArrayList<Integer>>());
        }

        for (int i = 0; i < 6; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int w = edges[i][2];

            ArrayList<Integer> tmp1 = new ArrayList<Integer>();
            ArrayList<Integer> tmp2 = new ArrayList<Integer>();
            tmp1.add(v);
            tmp1.add(w);

            tmp2.add(u);
            tmp2.add(w);

            adj.get(u).add(tmp1);
            adj.get(v).add(tmp2);
        }

        PrimsAlgo obj = new PrimsAlgo();
        int sum = obj.spanningTree(V, adj);
        System.out.println("The sum of all the edge weights: " + sum);
    }

    private int spanningTree(int v, ArrayList<ArrayList<ArrayList<Integer>>> adj) {
        PriorityQueue<PAPair> pq=new PriorityQueue<>((x,y)->x.distance- y.distance);
        int[] vis=new int[v];
        pq.add(new PAPair(0,0));
        int sum=0;
        while(pq.size()!=0){
            int wt=pq.peek().distance;
            int node=pq.peek().node;
            pq.remove();
            if(vis[node]==1) continue;

            vis[node]=1;
            sum+=wt;

            for(int i=0;i<adj.get(node).size();i++){
                int edW=adj.get(node).get(i).get(1);
                int adjN=adj.get(node).get(i).get(0);
                if(vis[adjN]==0){
                    pq.add(new PAPair(edW,adjN));
                }
            }
        }
        return sum;
    }
}
