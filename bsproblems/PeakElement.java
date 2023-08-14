package tuf_a2zdsacourse.bsproblems;

import java.util.Scanner;

public class PeakElement {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the no. of elements:");
        int n=sc.nextInt();
        int[] arr=new int[n];
        System.out.println("Enter the elements:");
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        //int ans=findPeakElement(arr,n);  //using linear search method...bruteforce approach
        int ans=findPeakEle(arr,n);  //using binary search algo...optimal approach
        System.out.print("The peak is at index: "+ans);

    }

    private static int findPeakEle(int[] arr, int n) {
       if(n==1) return 0;
       if(arr[0]>arr[1]) return 0;
       if(arr[n-1]>arr[n-2]) return n-1;

       int low=1,high=n-2;
       while(low<=high){
           int mid=(low+high)/2;
           if(arr[mid-1]<arr[mid] && arr[mid]>arr[mid+1]){
               return mid;
           }else if(arr[mid]>arr[mid-1]){
               low=mid+1;
           }else{
               high=mid-1;
           }
       }
       return -1;
    }
    /*
    private static int findPeakElement(int[] arr, int n) {
        for(int i=0;i<n;i++){
            if((i==0 || arr[i-1]<arr[i]) && (i==n-1 || arr[i]>arr[i+1])){
                return i;
            }
        }
        return -1;
    }*/
}
