package tuf_a2zdsacourse.bsproblems;

import java.util.Scanner;

public class KthMissingPositiveNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the no. of elements:");
        int n=sc.nextInt();
        int[] arr=new int[n];
        System.out.print("Enter the elements:");
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        System.out.print("Enter the value of k:");
        int k= sc.nextInt();
        //int ans=missingK(arr,n,k);  //bruteforce approach using linear search
        int ans=missingKBs(arr,n,k);  //optimal approach using binary search
        System.out.println("The missing number is: " + ans);
    }

    private static int missingKBs(int[] arr, int n, int k) {
        int low=0,high=n-1;
        while(low<=high){
            int mid=(low+high)/2;
            int missing=arr[mid]-(mid+1);
            if(missing<k){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return k+high+1;
    }

    private static int missingK(int[] arr, int n, int k) {
        for(int i=0;i<n;i++){
            if(arr[i]<=k) k++;
            else break;
        }
        return k;
    }
}
