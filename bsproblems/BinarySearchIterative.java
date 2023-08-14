package tuf_a2zdsacourse.bsproblems;

import java.util.Scanner;

public class BinarySearchIterative {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter no.of elements:");
        int n=sc.nextInt();
        int[] arr=new int[n];
        System.out.println("Enter the elements:");
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        System.out.println("Enter any element that you want to search:");
        int target=sc.nextInt();
        int res=binarSearch(arr,n,target);
        System.out.println("Element found at: "+res);
    }

    private static int binarSearch(int[] arr, int n, int target) {
        int low=0,high=n-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(arr[mid]==target) return mid;
            else if(target>arr[mid]){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return -1;
    }
}
