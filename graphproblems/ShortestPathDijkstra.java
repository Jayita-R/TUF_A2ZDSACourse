package tuf_a2zdsacourse.graphproblems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

class PairSP{
    int first;
    int second;
    public PairSP(int first,int second){
        this.first = first;
        this.second = second;
    }
}
public class ShortestPathDijkstra {
    public static void main(String[] args) {
        int V = 5, E = 6;

        int[][] edges = {{1,2,2},{2,5,5},{2,3,4},{1,4,1},{4,3,3},{3,5,1}};

        ShortestPathDijkstra obj = new ShortestPathDijkstra();
        List< Integer > path = obj.shortestPath(V, E, edges);
        for (int i = 0; i < path.size(); i++) {
            System.out.print(path.get(i) + " ");
        }
        System.out.println();
    }

    private List<Integer> shortestPath(int v, int e, int[][] edges) {
        ArrayList<ArrayList<PairSP>> adj=new ArrayList<>();
        for(int i=0;i<=v;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<e;i++){
            adj.get(edges[i][0]).add(new PairSP(edges[i][1], edges[i][2]));
            adj.get(edges[i][1]).add(new PairSP(edges[i][0], edges[i][2]));
        }
        PriorityQueue<PairSP> pq=new PriorityQueue<>((x,y)->x.first-y.first);
        int[] dist=new int[v+1];
        int[] pa=new int[v+1];
        for(int i = 1;i<=v;i++) {
            dist[i] = (int)(1e9);
            pa[i] = i;
        }
        dist[1]=0;
        pq.add(new PairSP(0,1));
        while(pq.size()!=0){
            PairSP it=pq.peek();
            int node=it.second;
            int d=it.first;
            pq.remove();
            for(PairSP iter:adj.get(node)){
                int adjN=iter.first;
                int eW= iter.second;

                if(d+eW<dist[adjN]){
                    dist[adjN]=d+eW;
                    pq.add(new PairSP(d+eW,adjN));
                    pa[adjN]=node;
                }
            }
        }
        List<Integer> path=new ArrayList<>();
        if(dist[v]==1e9){
            path.add(-1);
            return path;
        }
        int node=v;
        while(pa[node]!=node){
            path.add(node);
            node=pa[node];
        }
        path.add(1);
        Collections.reverse(path);
        return path;
    }
}
