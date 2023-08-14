package tuf_a2zdsacourse.bsproblems;

import java.util.Scanner;

public class FirstAndLastOccurenceUsingBS {
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
        int first=firstOccurence(arr,n,x);
        if(first==-1){
            System.out.println("Element present at (-1,-1)");
            System.exit(1);
        }
        int last=lastOccurence(arr,n,x);
        System.out.println("Element first and last occurence is ("+first+", "+last+")");

    }

    private static int lastOccurence(int[] arr, int n, int x) {
        int low=0,high=n-1,l=-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(arr[mid]==x) {l=mid;low=mid+1;}
            else if(x>arr[mid]){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return l;
    }

    private static int firstOccurence(int[] arr, int n, int x) {
        int low=0,high=n-1,f=-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(arr[mid]==x) {f=mid;high=mid-1;}
            else if(x>arr[mid]){
                low=mid+1;
            }else{
               high=mid-1;
            }
        }
        return f;

    }
}
