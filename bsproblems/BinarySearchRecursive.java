package tuf_a2zdsacourse.bsproblems;

import java.util.Scanner;

public class BinarySearchRecursive {
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
        int res=bSearch(arr,0,n-1,target);
        System.out.println("Element found at: "+res);
    }

    private static int bSearch(int[] arr, int low,int high, int target) {
        if(low>high){
            return -1;
        }
        int mid=(low+high)/2;
        if(arr[mid]==target) return mid;
        else if(target>arr[mid])
            return bSearch(arr,mid+1,high,target);
        return bSearch(arr,low,mid-1,target);
    }

}
