package tuf_a2zdsacourse.arrayproblems;

import java.util.Scanner;

public class SetMatrixZeros {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the row: ");
        int n=sc.nextInt();
        System.out.print("Enter the col: ");
        int m=sc.nextInt();

        int[][] arr=new int[n][m];
        System.out.println("Enter the elements in matrix:");
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                arr[i][j]=sc.nextInt();
            }
        }

        int[][] res=zeroMatrix(arr,n,m);
        System.out.println("The final matrix is:");
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                System.out.print(res[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static int[][] zeroMatrix(int[][] arr, int n, int m) {
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(arr[i][j]==0){
                    markRow(arr,n,m,i);
                    markCol(arr,n,m,j);
                }
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(arr[i][j]==-1){
                    arr[i][j]=0;
                }
            }
        }
        return arr;
    }

    public static void markCol(int[][] arr, int n, int m, int j) {
        for(int i=0;i<n;i++){
            if(arr[i][j]!=0)
                arr[i][j]=-1;
        }
    }

    public static void markRow(int[][] arr, int n, int m, int i) {
        for(int j=0;j<m;j++){
            if(arr[i][j]!=0)
                arr[i][j]=-1;
        }
    }
}
