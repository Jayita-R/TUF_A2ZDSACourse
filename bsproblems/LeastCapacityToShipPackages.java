package tuf_a2zdsacourse.bsproblems;

import java.util.Scanner;

public class LeastCapacityToShipPackages {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the no. of elements: ");
        int n=sc.nextInt();
        int[] arr=new int[n];
        System.out.print("Enter the weights: ");
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        System.out.print("Enter the days we have to ship it(d): ");
        int d=sc.nextInt();
        //int ans=leastWeightCapacity(arr,n,d);// bruteforce approach using linear search method
        int ans=leastWeightCapacityBs(arr,n,d); // optimal approach using binary search method
        System.out.print("The minimum capacity should be: "+ans);
    }

    private static int leastWeightCapacityBs(int[] arr, int n, int d) {
        int low=Integer.MIN_VALUE,high=0;
        for(int i=0;i<n;i++){
            high+=arr[i];
            low=Math.max(low,arr[i]);

        }
        while(low<=high){
            int mid=(low+high)/2;
            int noOfD=findDays(arr,mid);
            if(noOfD<=d){
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return low;
    }

    private static int leastWeightCapacity(int[] arr, int n, int d) {
        int max=Integer.MIN_VALUE,sum=0;
        for(int i=0;i<n;i++){
            sum+=arr[i];
            max=Math.max(max,arr[i]);
        }
        for(int i=max;i<=sum;i++){
            if(findDays(arr,i)<=d){
                return i;
            }
        }
        return -1;
    }

    private static int findDays(int[] arr, int cap) {
        int days=1;
        int load=0;
        int n=arr.length;
        for(int i=0;i<n;i++){
            if(load+arr[i]>cap){
                days+=1;
                load=arr[i];
            }else{
                load+=arr[i];
            }
        }
        return days;
    }
}
