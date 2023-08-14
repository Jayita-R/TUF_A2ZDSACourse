package tuf_a2zdsacourse.SlidingWindow;

import java.util.Scanner;

//variable size sliding window problem
public class LongestSubarrayOfSumK {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter no. of elements:");
        int n=sc.nextInt();
        int[] arr=new int[n];
        System.out.println("Enter the elements:");
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        System.out.println("Enter the required sum value:");
        int k=sc.nextInt();
        int len=longestSubArraySum(arr,n,k);
        System.out.println("Longest subarray length is: "+len);
    }

    private static int longestSubArraySum(int[] arr, int n, int k) {
        int i=0,j=0,sum=0,max=0;
        while(j<n){
            sum=sum+arr[j];
            if(sum<k){
                ++j;
            }else if(sum==k){
                if(j-i+1>max){
                    max=j-i+1;
                }
                ++j;
            }else if(sum>k){
                while(sum>k){
                    sum=sum-arr[i];
                    ++i;
                }
                ++j;
            }
        }
        return max;
    }
}
