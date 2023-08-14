package tuf_a2zdsacourse.bsproblems;

import java.util.Scanner;

public class MinimumWithDuplicatesRotatedArray {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter no.of elements:");
        int n=sc.nextInt();
        int[] arr=new int[n];
        System.out.println("Enter the elements:");
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        int res=minInRotatedArrayWithDup(arr,n);
        System.out.println("Minimum Element is: "+res);
    }

    private static int minInRotatedArrayWithDup(int[] arr, int n) {
        int low=0,high=n-1,ans=Integer.MAX_VALUE;
        while(low<=high){
            int mid=(low+high)/2;
            if(arr[low]==arr[mid] && arr[mid]==arr[high]){
                if(arr[low]<ans){
                    ans=arr[low];
                }
                low=low+1;
                high=high-1;
                continue;
            }
            if(arr[low]<=arr[high]){
                if(arr[low]<ans){
                    ans=arr[low];
                }
                break;
            }
            if(arr[low]<=arr[mid]){
                if(arr[low]<ans){
                    ans=arr[low];
                }
                low=mid+1;
            }else{
                if(arr[mid]<ans){
                    ans=arr[mid];
                }
                high=mid-1;
            }
        }
        return ans;
    }
}
