package tuf_a2zdsacourse.graphproblems;

import java.util.ArrayList;
import java.util.PriorityQueue;

class PQPair{
    int first;
    int second;
    PQPair(int first,int second){
        this.first=first;
        this.second=second;
    }
}
//using priority queue ds here we will solve dijkstra algo.
public class DijkstraAlgoPQ {
    public static void main(String[] args) {
        int V = 6, E=8,S=0;
        ArrayList<Integer> node1 = new ArrayList<Integer>() {{add(2);add(4);}};
        ArrayList<Integer> node2 = new ArrayList<Integer>() {{add(1);add(4);}};
        ArrayList<Integer> node3 = new ArrayList<Integer>() {{add(0);add(4);}};
        ArrayList<Integer> node4 = new ArrayList<Integer>() {{add(2);add(2);}};
        ArrayList<Integer> node5 = new ArrayList<Integer>() {{add(0);add(4);}};
        ArrayList<Integer> node6 = new ArrayList<Integer>() {{add(1);add(2);}};
        ArrayList<Integer> node7 = new ArrayList<Integer>() {{add(3);add(3);}};
        ArrayList<Integer> node8 = new ArrayList<Integer>() {{add(4);add(1);}};
        ArrayList<Integer> node9 = new ArrayList<Integer>() {{add(5);add(6);}};
        ArrayList<Integer> node10 = new ArrayList<Integer>() {{add(2);add(3);}};
        ArrayList<Integer> node11 = new ArrayList<Integer>() {{add(5);add(2);}};
        ArrayList<Integer> node12 = new ArrayList<Integer>() {{add(2);add(1);}};
        ArrayList<Integer> node13 = new ArrayList<Integer>() {{add(5);add(3);}};
        ArrayList<Integer> node14 = new ArrayList<Integer>() {{add(2);add(6);}};
        ArrayList<Integer> node15 = new ArrayList<Integer>() {{add(3);add(2);}};
        ArrayList<Integer> node16 = new ArrayList<Integer>() {{add(4);add(3);}};

        ArrayList<ArrayList<Integer>> inter1 = new ArrayList<ArrayList<Integer>>(){
            {
                add(node1);
                add(node2);
            }
        };
        ArrayList<ArrayList<Integer>> inter2 = new ArrayList<ArrayList<Integer>>(){
            {
                add(node3);
                add(node4);
            }
        };
        ArrayList<ArrayList<Integer>> inter3 = new ArrayList<ArrayList<Integer>>(){
            {
                add(node5);
                add(node6);
                add(node7);
                add(node8);
                add(node9);
            }
        };

        ArrayList<ArrayList<Integer>> inter4 = new ArrayList<ArrayList<Integer>>(){
            {
                add(node10);
                add(node11);
            }
        };
        ArrayList<ArrayList<Integer>> inter5 = new ArrayList<ArrayList<Integer>>(){
            {
                add(node12);
                add(node13);
            }
        };
        ArrayList<ArrayList<Integer>> inter6 = new ArrayList<ArrayList<Integer>>(){
            {
                add(node14);
                add(node15);
                add(node16);
            }
        };
        ArrayList<ArrayList<ArrayList<Integer>>> adj= new ArrayList<ArrayList<ArrayList<Integer>>>(){
            {
                add(inter1); // for 1st node
                add(inter2); // for 2nd node
                add(inter3); // for 3rd node
                add(inter4);
                add(inter5);
                add(inter6);
            }
        };
        //add final values of adj here.
        DijkstraAlgoPQ obj = new DijkstraAlgoPQ();
        int[] res= obj.dijkstra(V,adj,S);

        for(int i=0;i<V;i++){
            System.out.print(res[i]+" ");
        }
        System.out.println();

    }

    private int[] dijkstra(int v, ArrayList<ArrayList<ArrayList<Integer>>> adj, int s) {
        PriorityQueue<PQPair> pq=new PriorityQueue<PQPair>((x,y)->x.first-y.first);
        int[] dist=new int[v];
        for(int i=0;i<v;i++){
            dist[i]=(int)(1e9);
        }
        dist[s]=0;
        pq.add(new PQPair(0,s));
        while(pq.size()!=0){
            int dis=pq.peek().first;
            int n=pq.peek().second;
            pq.remove();
            for(int i=0;i<adj.get(n).size();i++){
                int eWgt=adj.get(n).get(i).get(1);
                int adjN=adj.get(n).get(i).get(0);

                if(dis+eWgt<dist[adjN]){
                    dist[adjN]=dis+eWgt;
                    pq.add(new PQPair(dist[adjN],adjN));
                }
            }
        }
        return dist;

    }
}
