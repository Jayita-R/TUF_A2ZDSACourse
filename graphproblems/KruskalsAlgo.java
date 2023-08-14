package tuf_a2zdsacourse.graphproblems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


class Edge implements Comparable<Edge> {
    int src, dest, weight;
    Edge(int _src, int _dest, int _wt) {
        this.src = _src; this.dest = _dest; this.weight = _wt;
    }
    public int compareTo(Edge compareEdge){
        return this.weight-compareEdge.weight;
    }
}
public class KruskalsAlgo {
    public static void main(String[] args) {
        int V = 5;
        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<ArrayList<ArrayList<Integer>>>();
        int[][] edges =  {{0, 1, 2}, {0, 2, 1}, {1, 2, 1}, {2, 3, 2}, {3, 4, 1}, {4, 2, 2}};

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

        KruskalsAlgo obj = new KruskalsAlgo();
        int mstWt = obj.spanningTree(V, adj);
        System.out.println("The sum of all the edge weights: " + mstWt);
    }

    private int spanningTree(int v, ArrayList<ArrayList<ArrayList<Integer>>> adj) {
        List<Edge> ed=new ArrayList<>();
        for(int i=0;i<v;i++){
            for(int j=0;j<adj.get(i).size();j++){
                int adjN=adj.get(i).get(j).get(0);
                int wt=adj.get(i).get(j).get(1);
                int node=i;
                Edge temp=new Edge(i,adjN,wt);
                ed.add(temp);
            }
        }
        DisjointSet ds = new DisjointSet(v);
        // M log M
        Collections.sort(ed);
        int mstWt = 0;
        for(int i=0;i<ed.size();i++){
            int wt=ed.get(i).weight;
            int u=ed.get(i).src;
            int d=ed.get(i).dest;

            if(ds.findUPar(u)!=ds.findUPar(d)){
                mstWt+=wt;
                ds.unionBySize(u,v);
            }
        }
        return mstWt;
    }
}
