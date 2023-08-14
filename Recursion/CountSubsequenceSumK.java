package tuf_a2zdsacourse.Recursion;

import java.util.ArrayList;
import java.util.Scanner;

public class CountSubsequenceSumK {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the no.of elements:");
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        System.out.print("Enter the target sum value:");
        int k=sc.nextInt();
        int cnt=countSubsequenceSumK(0,arr,n,k,0);
        System.out.println("Count of total subsequence is: "+cnt);
    }
    private static int countSubsequenceSumK(int i, int[] arr, int n,int k,int sum) {
        if(i==n){
            if(sum==k) {
                return 1;
            }
            return 0;
        }

        sum+=arr[i];
        int l=countSubsequenceSumK(i+1,arr,n,k,sum);


        sum-=arr[i];
        int r=countSubsequenceSumK(i+1,arr,n,k,sum);
        return l+r;
    }
}
