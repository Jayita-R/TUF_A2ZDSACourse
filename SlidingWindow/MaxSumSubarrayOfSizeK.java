package tuf_a2zdsacourse.SlidingWindow;

import java.util.Scanner;
//Fixed size sliding window problem
public class MaxSumSubarrayOfSizeK {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter no. of elements:");
        int n=sc.nextInt();
        int[] arr=new int[n];
        System.out.println("Enter the elements:");
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        System.out.println("Enter the window size:");
        int k=sc.nextInt();
        int maxSum=slideMaxSum(arr,n,k);
        System.out.println("Maximum sum is: "+maxSum);
    }

    private static int slideMaxSum(int[] arr, int n, int k) {
        int i=0,j=0;
        int sum=0;
        int max=Integer.MIN_VALUE;
        while(j<n){
            sum+=arr[j];
            if(j-i+1<k){
                ++j;
            }
            else if(j-i+1==k){
                max=Math.max(max,sum);
                sum=sum-arr[i];
                ++i;
                ++j;
            }
        }
        return max;
    }
}
