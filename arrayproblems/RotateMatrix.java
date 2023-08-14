package tuf_a2zdsacourse.arrayproblems;

import java.util.Scanner;

public class RotateMatrix {
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
        //int[][] res = rotateMatrix(arr, n, m);
        rotateMatrixOptimal(arr, n, m);
        System.out.println("The final matrix is:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void rotateMatrixOptimal(int[][] arr, int n, int m) {
        for(int i=0;i<n;i++){
            for(int j=i;j<m;j++){
                int temp = 0;
                temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m/ 2; j++) {
                int temp = 0;
                temp = arr[i][j];
                arr[i][j] = arr[i][arr.length - 1 - j];
                arr[i][arr.length - 1 - j] = temp;
            }
        }

    }

    public static int[][] rotateMatrix(int[][] arr, int n, int m) {
        int f[][]=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                f[j][n-i-1]=arr[i][j];
            }

        }
        return f;

    }
}
