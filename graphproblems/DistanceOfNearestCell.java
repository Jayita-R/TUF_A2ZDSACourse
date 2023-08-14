package tuf_a2zdsacourse.graphproblems;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Node {
    int first;
    int second;
    int third;
    Node(int _first, int _second, int _third) {
        this.first = _first;
        this.second = _second;
        this.third = _third;
    }
}
public class DistanceOfNearestCell {
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
        DistanceOfNearestCell obj = new DistanceOfNearestCell();
        int[][] ans = obj.nearest(grid);
        System.out.println("Distance matrix is:");
        for(int i = 0; i < ans.length; i++){
            for(int j = 0; j < ans[i].length; j++){
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }

    }

    private int[][] nearest(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        // visited and distance matrix
        int vis[][] = new int[n][m];
        int dist[][] = new int[n][m];

        Queue<Node> q=new LinkedList<>();
        //traverse the matrix
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                //start BFS if the cell is having 1
                if(grid[i][j]==1){
                    q.add(new Node(i,j,0));
                    vis[i][j]=1;
                }else{
                    //mark unvisited
                    vis[i][j]=0;
                }
            }
        }
        int delr[]={-1,0,1,0};
        int delc[]={0,1,0,-1};

        while(!q.isEmpty()){
            int row=q.peek().first;
            int col=q.peek().second;
            int steps=q.peek().third;
            q.remove();
            dist[row][col]=steps;
            //for all 4 neighbours
            for(int i=0;i<4;i++){
                int nrow=row+delr[i];
                int ncol=col+delc[i];
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && vis[nrow][ncol]==0){
                    vis[nrow][ncol]=1;
                    q.add(new Node(nrow, ncol, steps+1));
                }
            }
        }
        return dist;

    }
}
