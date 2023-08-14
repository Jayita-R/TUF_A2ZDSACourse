package tuf_a2zdsacourse.bsproblems;

import java.util.Scanner;

//optimal approach-Using Binary Search Algo. Not doing the bruteforce approach as
// it will might give you TLE in online code editor so it's not recommended to do.
public class KokoEatingBananas {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter no.of elements:");
        int n= sc.nextInt();
        int[] arr=new int[n];
        System.out.print("Enter the elements:");
        for(int i=0;i<n;i++){
            arr[i]= sc.nextInt();
        }
        System.out.print("Enter the value of h:");
        int h= sc.nextInt();
        int ans=minRateToEatBananas(arr,n,h);
        System.out.println("Koko should eat at least " + ans + " bananas/hr.");
    }

    private static int minRateToEatBananas(int[] arr, int n, int h) {
        int low=1,high=findMax(arr,n);
        while(low<=high){
            int mid=(low+high)/2;
            int totalH=calculateTotalHours(arr,n,mid);
            if(totalH<=h){
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return low;
    }

    private static int calculateTotalHours(int[] arr, int n, int hourly) {
        int totalH=0;
        for(int i=0;i<n;i++){
            totalH+=Math.ceil((double) arr[i]/(double) hourly);
        }
        return totalH;
    }

    private static int findMax(int[] arr, int n) {
        int maxi=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            maxi=Math.max(maxi,arr[i]);
        }
        return maxi;
    }
}
