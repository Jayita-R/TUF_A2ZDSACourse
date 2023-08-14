package tuf_a2zdsacourse.graphproblems;

import java.util.Scanner;

public class SurroundedRegions {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the no.of rows:");
        int n=sc.nextInt();
        System.out.print("Enter the no.of cols:");
        int m=sc.nextInt();
        char[][] grid=new char[n][m];
        System.out.println("Enter the elements in the array:");
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                grid[i][j]=sc.next().charAt(0);
            }
        }
        SurroundedRegions ob = new SurroundedRegions();
        char[][] ans = ob.fill(n, m, grid);
        System.out.println("Resultant matrix is:");
        for(int i = 0;i < n;i++) {
            for(int j = 0;j < m;j++) {
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }
    }

    private char[][] fill(int n, int m, char[][] grid) {
        int[] delr={-1,0,1,0};
        int[] delc={0,1,0,-1};
        int vis[][] = new int[n][m];
        // traverse first row and last row
        for(int j=0;j<m;j++){
            // check for unvisited Os in the boundary rows
            // first row
            if(vis[0][j]==0 && grid[0][j]=='O'){
                dfs(0,j,vis,grid,delr,delc);
            }

            //last row
            if(vis[n-1][j]==0 && grid[n-1][j]=='O'){
                dfs(n-1,j,vis,grid,delr,delc);
            }
        }

        // traverse first col and last col
        for(int i=0;i<n;i++){
            // check for unvisited Os in the boundary cols
            // first col
            if(vis[i][0]==0 && grid[i][0]=='O'){
                dfs(i,0,vis,grid,delr,delc);
            }

            //last col
            if(vis[i][m-1]==0 && grid[i][m-1]=='O'){
                dfs(i,m-1,vis,grid,delr,delc);
            }
        }
        // if unvisited O then convert to X
        for(int i = 0;i<n;i++) {
            for(int j= 0 ;j<m;j++) {
                if(vis[i][j] == 0 && grid[i][j] == 'O')
                    grid[i][j] = 'X';
            }
        }

        return grid;

    }

    private void dfs(int row, int col, int[][] vis, char[][] grid, int[] delr, int[] delc) {
        vis[row][col] = 1;
        int n = grid.length;
        int m = grid[0].length;

        // check for top, right, bottom, left
        for(int i = 0;i<4;i++) {
            int nrow = row + delr[i];
            int ncol = col + delc[i];
            // check for valid coordinates and unvisited Os
            if(nrow >=0 && nrow <n && ncol >= 0 && ncol < m
                    && vis[nrow][ncol] == 0 && grid[nrow][ncol] == 'O') {
                dfs(nrow, ncol, vis, grid, delr, delc);
            }
        }
    }
}
