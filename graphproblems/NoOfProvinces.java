package tuf_a2zdsacourse.graphproblems;

import java.util.ArrayList;

//using disjoint set ds.
public class NoOfProvinces {
    public static void main(String[] args) {
        int v=8;
        int[][] edges=new int[v][v];
        for(int i=0;i<v;i++){
            for(int j=0;j<v;j++){
                edges[i][j]=0;
            }
        }
        edges[1][2]=1;
        //edges[2][1]=1;
        edges[2][3]=1;
        //edges[3][2]=1;
        edges[4][5]=1;
        //edges[5][4]=1;
        edges[6][7]=1;
        //edges[7][6]=1;
        /*
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer> >();
        for(int i=0;i<v;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<v;i++){
            for(int j=0;j<v;j++){
                if(edges[i][j]!=1){
                    adj.get(i).set(j,0);
                }else if(edges[i][j]==1){
                    adj.get(i).set(j,1);
                }
            }
        }*/



        NoOfProvinces ob = new NoOfProvinces();
        System.out.println("Total provinces are: "+ob.noProvince(edges,8));
    }
    public static int noProvince(int[][] adj,int v){
        DisjointSet ds=new DisjointSet(v);
        for(int i=0;i<v;i++){
            for(int j=0;j<v;j++){
                if(adj[i][j]==1){
                    ds.unionBySize(i,j);
                }
            }
        }
        int cnt=0;
        for(int i=0;i<v;i++){
            if(i==0) continue;
            if(ds.par.get(i)==i) ++cnt;
        }
        return cnt;
    }
}
