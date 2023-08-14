package tuf_a2zdsacourse.arrayproblems;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SpiralMatrix {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter no. of row:");
        int n=sc.nextInt();
        System.out.println("Enter no. of col:");
        int m=sc.nextInt();
        int[][] arr=new int[n][m];

        System.out.println("Enter elements in the matrix:");
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                arr[i][j]=sc.nextInt();
            }
        }
        List<Integer> ans=printSpiral(arr,n,m);
        System.out.println("The final list in spiral order is:");
        for(int i=0;i<ans.size();i++){
            System.out.print(ans.get(i)+" ");
        }
    }

    public static List<Integer> printSpiral(int[][] arr, int n, int m) {
        List<Integer> res=new ArrayList<>();
        int top=0,bottom=n-1;
        int left=0, right=m-1;

        while(top<=bottom && left<=right){
            for(int i=left;i<=right;i++){
                res.add(arr[top][i]);
            }
            top++;
            for(int i=top;i<=bottom;i++){
                res.add(arr[i][right]);
            }
            right--;
            if(top<=bottom) {
                for (int i = right; i >= left; i--) {
                    res.add(arr[bottom][i]);
                }
                bottom--;
            }
            if(left<=right) {
                for (int i = bottom; i >= top; i--) {
                    res.add(arr[i][left]);
                }
                left++;
            }
        }
        return res;
    }
}
