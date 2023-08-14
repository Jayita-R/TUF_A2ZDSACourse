package tuf_a2zdsacourse.graphproblems;

import java.util.ArrayList;
import java.util.PriorityQueue;

class CityPair{
    int first;
    int second;
    CityPair(int f,int s){
        this.first=f;
        this.second=s;
    }
}
public class CityInThresholdDistance {
    public static void main(String[] args) {
        /*
        int n = 4;
        int m = 4;
        int[][] edges =  {{0, 1, 3}, {1, 2, 1}, {1, 3, 4}, {2, 3, 1}};
        int distanceThreshold = 4;
        */

        int n = 3;
        int m = 2;
        int[][] edges =  {{0, 1, 3}, {1, 2, 1}};
        int distanceThreshold = 2;


        CityInThresholdDistance obj = new CityInThresholdDistance();
        int cityNo = obj.findTheCity(n, m, edges, distanceThreshold);
        System.out.println("The answer is node: " + cityNo);
    }

    private int findTheCity(int n, int m, int[][] edges, int distanceThreshold) {
        ArrayList<ArrayList<CityPair>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0;i<m;i++){
            adj.get(edges[i][0]).add(new CityPair(edges[i][1],edges[i][2]));
            adj.get(edges[i][1]).add(new CityPair(edges[i][0],edges[i][2]));
        }
        int[][] dist=new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                dist[i][j]=Integer.MAX_VALUE;
            }
        }
        for(int i=0;i<n;i++){
            PriorityQueue<CityPair> pq=new PriorityQueue<>((x,y)->x.first-y.first);
            pq.add(new CityPair(0,i));
            while(pq.size()!=0){
                CityPair it=pq.peek();
                int d=it.first;
                int node=it.second;
                pq.remove();
                for(CityPair iter:adj.get(node)){
                    int adjDis=iter.second;
                    int adjN=iter.first;

                    if(adjDis+d<dist[i][adjN]){
                        dist[i][adjN]=adjDis+d;
                        pq.add(new CityPair(dist[i][adjN],adjN));
                    }
                }

            }
        }
        for(int i=0;i<n;i++){
            dist[i][i] = 0;
        }
        int maxcnt = n;
        int city = -1;
        for(int i=0;i<n;i++){
            int cnt = 0;
            for(int j=0;j<n;j++){
                if(i!=j && dist[i][j] <= distanceThreshold){
                    cnt++;
                }
            }
            if(cnt>0 && cnt <= maxcnt){
                maxcnt = cnt;
                city = i;
            }
        }
        return city;
    }
}
