package tuf_a2zdsacourse.graphproblems;

import java.util.PriorityQueue;

class MEff{
    int distance;
    int row;
    int col;
    public MEff(int distance,int row, int col){
        this.row = row;
        this.distance = distance;
        this.col = col;
    }
}
public class PathMinEffort {
    public static void main(String[] args) {
        int[][] heights={{1, 2, 2}, {3, 8, 2}, {5, 3, 5}};

        PathMinEffort obj = new PathMinEffort();
        int ans = obj.minimumEffort(heights);

        System.out.print("Path Minimum effort is:"+ans);
        System.out.println();
    }

    private int minimumEffort(int[][] heights) {
        PriorityQueue<MEff> pq=new PriorityQueue<MEff>((x,y)->x.distance-y.distance);
        int n= heights.length;
        int m=heights[0].length;
        int[][] dist=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                dist[i][j]=(int)(1e9);
            }
        }
        dist[0][0]=0;
        pq.add(new MEff(0,0,0));

        int dr[] = {-1, 0, 1, 0};
        int dc[] = {0, 1, 0, -1};

        while(pq.size()!=0){
            MEff it=pq.peek();
            pq.remove();
            int diff=it.distance;
            int r=it.row;
            int c=it.col;

            if(r==n-1 && c==m-1) return diff;

            for(int i=0;i<4;i++){
                int nr=r+dr[i];
                int nc=c+dc[i];

                if(nr>=0 && nr<n && nc>=0 && nc<m ){
                    int nEff=Math.max(Math.abs(heights[r][c] - heights[nr][nc]),diff);

                    if(nEff < dist[nr][nc]) {
                        dist[nr][nc] = nEff;
                        pq.add(new MEff(nEff, nr, nc));
                    }
                }
            }
        }
        return 0;

    }
}
