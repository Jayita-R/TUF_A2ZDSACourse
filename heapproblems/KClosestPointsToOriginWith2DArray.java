package tuf_a2zdsacourse.heapproblems;

import javafx.util.Pair;

import java.util.PriorityQueue;
import java.util.Scanner;

public class KClosestPointsToOriginWith2DArray {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the row:");
        int n=sc.nextInt();
        System.out.println("Enter the elements in array:");
        int[][] arr=new int[n][2];
        for(int i=0;i<n;i++){
            for(int j=0;j<2;j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        System.out.println("Enter the value of k:");
        int k=sc.nextInt();
        int[][] ans=kClosestPoints(arr, n, k);
        for(int i=0;i<ans.length;i++){
            for(int j=0;j<2;j++){
                System.out.print(ans[i][j]+" ");
            }
            System.out.println();
        }
    }

    private static int[][] kClosestPoints(int[][] arr, int n, int k) {
        PriorityQueue<int[]> maxH=new PriorityQueue<>((a,b)->dist(b)-dist(a));
        for(int[] point:arr){
           maxH.add(point) ;
           if(maxH.size()>k){
               maxH.poll();
           }
        }
        int[][] res=new int[k][2];
        int i=0;
        while(maxH.isEmpty()==false){
            res[i++]=maxH.poll();
        }
        return res;
    }

    private static int dist(int[] points) {
        int x=points[0];
        int y=points[1];
        return x*x+y*y;
    }


}
