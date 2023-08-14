package tuf_a2zdsacourse.graphproblems;

public class NoOperGraphConnect {
    public static void main(String[] args) {
        int V = 9;
        int[][] edge = {{0, 1}, {0, 2}, {0, 3}, {1, 2}, {2, 3}, {4, 5}, {5, 6}, {7, 8}};

        NoOperGraphConnect obj = new NoOperGraphConnect();
        int ans = obj.solve(V, edge);
        System.out.println("The number of operations needed: " + ans);
    }

    private int solve(int v, int[][] edge) {
        DisjointSet ds=new DisjointSet(v);
        int extras=0;
        int m=edge.length;
        for(int i=0;i<m;i++){
            int u=edge[i][0];
            int d=edge[i][1];
            if(ds.findUPar(u)==ds.findUPar(d)){
                ++extras;
            }else{
                ds.unionBySize(u,d);
            }
        }
        int cntc=0;
        for(int i=0;i<v;i++){
            if(ds.par.get(i)==i) cntc++;
        }
        int ans=cntc-1;
        if(extras>=ans) return ans;
        return -1;
    }
}
