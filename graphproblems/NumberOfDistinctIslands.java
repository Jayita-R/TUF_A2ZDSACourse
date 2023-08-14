package tuf_a2zdsacourse.graphproblems;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class NumberOfDistinctIslands {
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
        NumberOfDistinctIslands ob = new NumberOfDistinctIslands();
        int ans = ob.numberOfDistinctIsland(grid);
        System.out.println("No. of distinct island is: "+ans);
    }

    private int numberOfDistinctIsland(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int[][] vis=new int[n][m];
        HashSet<ArrayList<String>> st=new HashSet<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(vis[i][j]==0 && grid[i][j]==1){
                    ArrayList<String> ls=new ArrayList<>();
                    dfs(i,j,vis,grid,ls,i,j);
                    st.add(ls);
                }
            }
        }
        return st.size();
    }

    private void dfs(int row, int col, int[][] vis, int[][] grid, ArrayList<String> ls, int r0, int c0) {
        vis[row][col]=1;
        ls.add(toString(row-r0,col-c0));
        int n=grid.length;
        int m=grid[0].length;

        int[] delr={-1,0,1,0};
        int[] delc={0,1,0,-1};
        for(int i=0;i<4;i++){
            int nrow=row+delr[i];
            int ncol=col+delc[i];

            // check for valid coordinates and for land cell
            if(nrow >=0 && nrow <n && ncol >=0 && ncol < m
                    && vis[nrow][ncol] == 0 && grid[nrow][ncol] == 1) {
                dfs(nrow,ncol,vis,grid,ls,r0,c0);
            }
        }
    }

    private String toString(int r, int c) {
        return Integer.toString(r) +" "+ Integer.toString(c);
    }
}
