package tuf_a2zdsacourse.arrayproblems;

import java.util.Scanner;

public class SetMatrixZerosBetterApproach {
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

        int[][] res = zeroMatrixBetterApproach(arr, n, m);
        System.out.println("The final matrix is:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(res[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[][] zeroMatrixBetterApproach(int[][] arr, int n, int m) {
        int[] row=new int[n];
        int[] col=new int[m];
        for(int i=0;i<n;i++){
            for (int j = 0; j < m; j++) {
                if(arr[i][j]==0){
                    row[i]=1;
                    col[j]=1;
                }
            }
        }
        for(int i=0;i<n;i++) {
            for (int j = 0; j < m; j++) {
                if (row[i] == 1 || col[j] == 1) {
                    arr[i][j]=0;
                }
            }
        }
        return arr;
    }
}
