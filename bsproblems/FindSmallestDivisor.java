package tuf_a2zdsacourse.bsproblems;

import java.util.Scanner;

public class FindSmallestDivisor {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the no. of elements: ");
        int n=sc.nextInt();
        int[] arr=new int[n];
        System.out.print("Enter the elements: ");
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        System.out.print("Enter the limit: ");
        int limit=sc.nextInt();
        //int ans=smallestDivisor(arr,n,limit);// bruteforce approach using linear search method
        int ans=smallestDivisorBs(arr,n,limit); // optimal approach using binary search method
        System.out.print("The minimum Divisor is: "+ans);

    }

    private static int smallestDivisorBs(int[] arr, int n, int limit) {
        if(n>limit) return -1;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            max=Math.max(max,arr[i]);
        }
        int low=1,high=max;
        while(low<=high){
            int mid=(low+high)/2;
            if(sumByD(arr,mid)<=limit){
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return low;
    }

    private static int sumByD(int[] arr, int div) {
        int n=arr.length;
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=Math.ceil((double) arr[i]/(double) div);
        }
        return sum;

    }

    private static int smallestDivisor(int[] arr, int n, int limit) {
        int max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            max=Math.max(max,arr[i]);
        }
        for(int d=1;d<=max;d++){
            int sum=0;
            for(int i=0;i<n;i++){
                sum+=Math.ceil((double) arr[i]/(double) d);
            }
            if(sum<=limit){
                return d;
            }
        }
        return -1;
    }
}
