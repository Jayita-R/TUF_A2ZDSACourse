package tuf_a2zdsacourse.bsproblems;

import java.util.Scanner;

public class FloorOfElement {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter no.of elements:");
        int n=sc.nextInt();
        int[] arr=new int[n];
        System.out.println("Enter the elements:");
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        System.out.println("Enter any element:");
        int x=sc.nextInt();
        int res=floorOfElement(arr,n,x);
        System.out.println("Floor of the element is: "+res);
    }

    private static int floorOfElement(int[] arr, int n, int x) {
        int low=0,high=n-1;
        int ans=-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(arr[mid]<=x){
                ans=arr[mid];
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return ans;
    }
}
