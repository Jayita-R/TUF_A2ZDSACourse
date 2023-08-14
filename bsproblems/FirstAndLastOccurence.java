package tuf_a2zdsacourse.bsproblems;

import java.util.Scanner;

//using lower bound and upper bound concept
public class FirstAndLastOccurence {
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
        int first=lb(arr,n,x);
        if(first==n || arr[first]!=x) {
            System.out.print("Element present at (-1,-1)");
            System.exit(1);
        }
        int last=ub(arr,n,x)-1;
        System.out.print("Element present at- "+first+", "+last);
    }

    private static int ub(int[] arr, int n, int x) {
        int low=0,high=n-1,last=n;
        while(low<=high){
            int mid=(low+high)/2;
            if(arr[mid]>x){
                last=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return last;
    }

    private static int lb(int[] arr, int n, int x) {
        int low=0,high=n-1,first=n;
        while(low<=high){
            int mid=(low+high)/2;
            if(arr[mid]>=x){
                first=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return first;
    }
}
