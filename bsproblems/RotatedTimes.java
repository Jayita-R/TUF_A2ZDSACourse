package tuf_a2zdsacourse.bsproblems;

import java.util.Scanner;

public class RotatedTimes {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter no.of elements:");
        int n=sc.nextInt();
        int[] arr=new int[n];
        System.out.println("Enter the elements:");
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        int res=rotates(arr,n);
        System.out.println("Rotated "+res +" times");
    }

    private static int rotates(int[] arr, int n) {
        int low=0,high=n-1,ans=Integer.MAX_VALUE,ind=-1;
        while(low<=high){
            int mid=(low+high)/2;
            //If it contains duplicate then add this part as well
            if(arr[low]==arr[mid] && arr[mid]==arr[high]){
                if(arr[low]<ans){
                    ans=arr[low];
                    ind=low;
                }
                low=low+1;
                high=high-1;
                continue;
            }
            /*....*/
            if(arr[low]<=arr[high]){
                if(arr[low]<ans){
                    ans=arr[low];
                    ind=low;
                }
                break;
            }
            if(arr[low]<=arr[mid]){
                if(arr[low]<ans){
                    ans=arr[low];
                    ind=low;
                }
                low=mid+1;
            }else{
                if(arr[mid]<ans){
                    ans=arr[mid];
                    ind=mid;
                }
                high=mid-1;
            }
        }
        return ind;
    }
}
