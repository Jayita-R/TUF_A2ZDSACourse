package tuf_a2zdsacourse.arrayproblems;

import java.util.Scanner;

public class SetMatrixZerosOptimal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the row: ");
        int n = sc.nextInt();
        System.out.print("Enter the col: ");
        int m = sc.nextInt();

        int[][] arr = new int[n][m];
        System.out.println("Enter the elements in matrix:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        int[][] res = zeroMatrixOptimal(arr, n, m);
        System.out.println("The final matrix is:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(res[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[][] zeroMatrixOptimal(int[][] arr, int n, int m) {
        // int[] row = new int[n]; --> arr[..][0]
        // int[] col = new int[m]; --> arr[0][..]
        int col0 = 1;
        // step 1: Traverse the matrix and
        // mark 1st row & col accordingly:
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 0) {
                    arr[i][0] = 0;

                    if (j != 0)
                        arr[0][j] = 0;
                    else
                        col0 = 0;
                }
            }
        }

        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                if(arr[i][j]!=0){
                    if(arr[0][j]==0 || arr[i][0]==0){
                        arr[i][j]=0;
                    }
                }
            }
        }

        if(arr[0][0]==0){
            for(int j=0;j<m;j++) arr[0][j]=0;
        }

        if(col0==0){
            for(int i=0;i<n;i++){
                arr[i][0]=0;
            }
        }
       return arr;
    }
}
