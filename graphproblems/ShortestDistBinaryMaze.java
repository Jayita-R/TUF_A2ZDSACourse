package tuf_a2zdsacourse.graphproblems;

import java.util.LinkedList;
import java.util.Queue;

class tuple {
    int first, second, third;
    tuple(int _first, int _second, int _third) {
        this.first = _first;
        this.second = _second;
        this.third = _third;
    }
}
public class ShortestDistBinaryMaze {
    public static void main(String[] args) {
        int[] source={0,1};
        int[] destination={2,2};

        int[][] grid={{1, 1, 1, 1},
                {1, 1, 0, 1},
                {1, 1, 1, 1},
                {1, 1, 0, 0},
                {1, 0, 0, 1}};

        ShortestDistBinaryMaze obj = new ShortestDistBinaryMaze();
        int res = obj.shortestDist(grid, source, destination);

        System.out.print(res);
        System.out.println();
    }

    private int shortestDist(int[][] grid, int[] src, int[] dest) {
        // Edge Case: if the source is only the destination.
        if(src[0] == dest[0] &&
                src[1] == dest[1]) return 0;

        Queue<tuple> q = new LinkedList<>();
        int n = grid.length;
        int m = grid[0].length;

        // Create a distance matrix with initially all the cells marked as
        // unvisited and the source cell as 0.
        int[][] dist = new int[n][m];
        for(int i = 0;i<n;i++) {
            for(int j =0;j<m;j++) {
                dist[i][j] = (int)(1e9);
            }
        }
        dist[src[0]][src[1]]=0;
        q.add(new tuple(0,src[0],src[1]));

        int[] dr={-1,0,1,0};
        int[] dc={0, 1, 0, -1};
        while(!q.isEmpty()){
           tuple it=q.peek();
           q.remove();
           int dis=it.first;
           int r=it.second;
           int c=it.third;

           for(int i=0;i<4;i++){
               int nr=r+dr[i];
               int nc=c+dc[i];

               if(nr>=0 && nr<n && nc>=0 && nc<m && grid[nr][nc]==1 && dis+1<dist[nr][nc]){
                   dist[nr][nc]=1+dis;

                   // Return the distance until the point when
                   // we encounter the destination cell.
                   if(nr == dest[0] &&
                           nc == dest[1]) return dis + 1;
                   q.add(new tuple(1+dis, nr, nc));
               }
           }
        }
        return -1;

    }
}
