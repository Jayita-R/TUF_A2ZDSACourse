package tuf_a2zdsacourse.bsproblems;

import java.util.Scanner;

public class SplitArray {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the no. of elements: ");
        int n= sc.nextInt();
        int[] arr=new int[n];
        System.out.print("Enter the elements in array: ");
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        System.out.print("Enter the k value: ");
        int k= sc.nextInt();
        //int ans = largestSubarraySumMinimized(arr, n, k);//bruteforce approach using linear search method
        int ans = largestSubarraySumMinimizedBs(arr, n, k);//optimal approach using binary search method
        System.out.println("The answer is: " + ans);
    }

    private static int largestSubarraySumMinimizedBs(int[] a, int n, int k) {
        int low = a[0];
        int high = 0;
        //find maximum and summation:
        for (int i = 0; i < n; i++) {
            low = Math.max(low, a[i]);
            high += a[i];
        }

        while(low<=high){
            int mid=(low+high)/2;
            int partitions=countPartitions(a,mid);
            if(partitions>k){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return low;
    }

    private static int largestSubarraySumMinimized(int[] a, int n, int k) {
        int low = a[0];
        int high = 0;
        //find maximum and summation:
        for (int i = 0; i < n; i++) {
            low = Math.max(low, a[i]);
            high += a[i];
        }

        for (int maxSum = low; maxSum <= high; maxSum++) {
            if (countPartitions(a, maxSum) == k)
                return maxSum;
        }
        return low;
    }

    private static int countPartitions(int[] a, int maxSum) {
        int n = a.length; //size of array.
        int partitions = 1;
        long subarraySum = 0;
        for (int i = 0; i < n; i++) {
            if (subarraySum + a[i] <= maxSum) {
                //insert element to current subarray
                subarraySum += a[i];
            } else {
                //insert element to next subarray
                partitions++;
                subarraySum = a[i];
            }
        }
        return partitions;
    }
}
