package tuf_a2zdsacourse.graphproblems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class CFPair{
    int first;
    int second;
    public CFPair(int first,int second){
        this.first = first;
        this.second = second;
    }
}
class CFTup {
    int first, second, third;
    CFTup(int first, int second, int third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }
}
public class CheapestFlights {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the no. of nodes: ");
        int n=sc.nextInt();
        System.out.print("Enter src: ");
        int src=sc.nextInt();
        System.out.print("Enter dest.: ");
        int dst=sc.nextInt();
        System.out.print("Enter stops allowed: ");
        int k=sc.nextInt();
        System.out.print("Enter the row val: ");
        int m=sc.nextInt();
        int[][] fli=new int[m][3];
        for(int i=0;i<m;i++){
            for(int j=0;j<3;j++){
                fli[i][j]=sc.nextInt();
            }
        }
        CheapestFlights obj = new CheapestFlights();
        int ans = obj.cheapestFlight(n,fli,src,dst,k);

        System.out.print("Cheapest Flight cost: "+ans);
        System.out.println();


    }

    private int cheapestFlight(int n, int[][] fli, int src, int dst, int k) {
        ArrayList<ArrayList<CFPair>> adj=new ArrayList<>();

        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        int m=fli.length;
        for(int i=0;i<m;i++){
            adj.get(fli[i][0]).add(new CFPair(fli[i][1], fli[i][2]));
        }
        Queue<CFTup> q=new LinkedList<>();
        q.add(new CFTup(0,src,0));

        int[] dist = new int[n];
        for(int i = 0;i<n;i++) {
            dist[i] = (int)(1e9);
        }
        dist[src] = 0;
        while(!q.isEmpty()){
            CFTup it=q.peek();
            q.remove();
            int stops=it.first;
            int node=it.second;
            int cost=it.third;

            if(stops>k) continue;
            for(CFPair iter:adj.get(node)){
                int adjN=iter.first;
                int eW=iter.second;

                if(cost+eW<dist[adjN] && stops<=k){
                    dist[adjN]=cost+eW;
                    q.add(new CFTup(stops+1,adjN,cost+eW));
                }
            }
        }
        // If the destination node is unreachable return ‘-1’
        // else return the calculated dist from src to dst.
        if(dist[dst] == (int)(1e9)) return -1;
        return dist[dst];
    }
}
