package tuf_a2zdsacourse.graphproblems;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Pair {
    int first;
    int second;
    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}
public class NumberOfEnclaves {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the no.of rows:");
        int n=sc.nextInt();
        System.out.print("Enter the no.of cols:");
        int m=sc.nextInt();
        int[][] grid=new int[n][m];
        System.out.println("Enter the elements in the array:");
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                grid[i][j]=sc.nextInt();
            }
        }
        NumberOfEnclaves ob = new NumberOfEnclaves();
        int ans = ob.numberOfEnclaves(grid);
        System.out.println("No. of enclaves is: "+ans);
    }

    private int numberOfEnclaves(int[][] grid) {
        Queue<Pair> q=new LinkedList<>();
        int n=grid.length;
        int m=grid[0].length;
        int[][] vis=new int[n][m];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i==0 || j==0 || i==n-1 || j==m-1){
                    if(grid[i][j]==1){
                        q.add(new Pair(i,j));
                        vis[i][j]=1;
                    }
                }
            }
        }
        int[] delr={-1,0,1,0};
        int[] delc={0,1,0,-1};

        while(!q.isEmpty()){
            int row=q.peek().first;
            int col=q.peek().second;
            q.remove();
            for(int i=0;i<4;i++){
                int nrow=row+delr[i];
                int ncol=col+delc[i];

                // check for valid coordinates and for land cell
                if(nrow >=0 && nrow <n && ncol >=0 && ncol < m
                        && vis[nrow][ncol] == 0 && grid[nrow][ncol] == 1) {
                    q.add(new Pair(nrow, ncol));
                    vis[nrow][ncol] = 1;
                }

            }
        }

        int cnt=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(vis[i][j]==0 && grid[i][j]==1){
                    ++cnt;
                }
            }
        }
        return cnt;

    }
}
