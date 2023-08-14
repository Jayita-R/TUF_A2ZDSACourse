package tuf_a2zdsacourse.bsproblems;

import java.util.Scanner;

public class MinDaysToMakeBouquets {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the no.of elements: ");
        int n= sc.nextInt();
        int[] arr=new int[n];
        System.out.print("Enter the elements: ");
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        System.out.print("Enter the no. of bouquets(m): ");
        int m= sc.nextInt();
        System.out.print("Enter the no. of adjacent(k): ");
        int k= sc.nextInt();
        //int ans=makeBouquets(arr,n,m,k); // bruteforce approach using linear search method
        int ans=makeBouquetsBs(arr,n,m,k); // optimal approach using binary search method
        if (ans == -1)
            System.out.println("We cannot make m bouquets.");
        else
            System.out.println("We can make bouquets on day " + ans);

    }

    private static int makeBouquetsBs(int[] arr, int n, int m, int k) {
        long val=(long)m*k;
        if(val>n) return -1;
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            min=Math.min(min,arr[i]);
            max=Math.max(max,arr[i]);
        }
        int low=min,high=max;
        while(low<=high){
            int mid=(low+high)/2;
            if(possible(arr,mid,m,k)){
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return low;
    }

    private static int makeBouquets(int[] arr, int n, int m, int k) {
        long val=(long)m*k;
        if(val>n) return -1;
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            min=Math.min(min,arr[i]);
            max=Math.max(max,arr[i]);
        }
        for(int i=min;i<=max;i++){
            if(possible(arr,i,m,k))
                return i;
        }
        return -1;
    }

    private static boolean possible(int[] arr, int day, int m, int k) {
        int n=arr.length;
        int cnt=0,noOfB=0;
        for(int i=0;i<n;i++){
            if(arr[i]<=day){
                ++cnt;
            }else{
                noOfB+=(cnt/k);
                cnt=0;
            }
        }
        noOfB+=(cnt/k);
        return noOfB>=m;
    }
}
