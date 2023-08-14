package tuf_a2zdsacourse;

import java.util.Scanner;

public class SecondLargestAndSmallest {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the no.of elements");
        int n=sc.nextInt();
        int[] arr=new int[n];
        System.out.println("Enter the array elements:");
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        int slargest=sLargest(arr,n);
        int ssmallest=sSmallest(arr,n);

        System.out.println("Second Largest element in the array is: "+slargest);
        System.out.println("Second Smallest element in the array is: "+ssmallest);

    }

    private static int sSmallest(int[] arr, int n) {
        int s=arr[0];
        int ss=Integer.MAX_VALUE;
        for(int i=1;i<n;i++){
            if(arr[i]<s){
                ss=s;
                s=arr[i];
            }
            else if(arr[i]>s && arr[i]< ss){
                ss=arr[i];
            }
        }
        return ss;
    }

    private static int sLargest(int[] arr, int n) {
        int l=arr[0];
        int sl=Integer.MIN_VALUE;
        for(int i=1;i<n;i++){
            if(arr[i]>l){
                sl=l;
                l=arr[i];
            }
            else if(arr[i]<l && arr[i]> sl){
                sl=arr[i];
            }
        }
        return sl;
    }
}
