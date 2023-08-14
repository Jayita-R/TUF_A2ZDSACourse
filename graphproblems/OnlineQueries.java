package tuf_a2zdsacourse.graphproblems;

import java.util.ArrayList;
import java.util.List;

public class OnlineQueries {
    public static void main(String[] args) {
        int n=4,m=5;
        int[][] op={{0, 0}, {0, 0}, {1, 1}, {1, 0}, {0, 1},
                {0, 3}, {1, 3}, {0, 4}, {3, 2}, {2, 2}, {1, 2}, {0, 2}};
        OnlineQueries ob=new OnlineQueries();
        List<Integer> ans=ob.numIslands(n,m,op);

        int sz = ans.size();
        for (int i = 0; i < sz; i++) {
            System.out.print(ans.get(i) + " ");
        }
        System.out.println("");

    }

    private List<Integer> numIslands(int n, int m, int[][] op) {
        DisjointSet ds=new DisjointSet(n*m);
        int[][] vis=new int[n][m];
        int cnt=0;
        List<Integer> ans=new ArrayList<>();
        int len=op.length;
        for(int i=0;i<len;i++){
            int row=op[i][0];
            int col=op[i][1];
            if(vis[row][col]==1){
                ans.add(cnt);
                continue;
            }
            vis[row][col]=1;
            cnt++;
            int[] dr={-1,0,1,0};
            int[] dc={0,1,0,-1};
            for(int ind=0;ind<4;ind++){
                int adjr=row+dr[ind];
                int adjc=col+dc[ind];
                if(isValid(adjr,adjc,n,m)){
                    if(vis[adjr][adjc]==1){
                        int nodeNo=row*m+col;
                        int adjNodeNo = adjr * m + adjc;
                        if (ds.findUPar(nodeNo) != ds.findUPar(adjNodeNo)) {
                            cnt--;
                            ds.unionBySize(nodeNo, adjNodeNo);
                        }
                    }
                }
            }
            ans.add(cnt);
        }
        return ans;
    }

    private boolean isValid(int adjr, int adjc, int n, int m) {
        return adjr >= 0 && adjr < n && adjc >= 0 && adjc < m;
    }
}
