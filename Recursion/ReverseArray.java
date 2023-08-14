package tuf_a2zdsacourse.Recursion;

import java.util.Scanner;
//Using Two pointers tech.
public class ReverseArray {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the no.of elements");
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        arrayReverse(arr,0,n-1);
        System.out.println("Reversed Array :");
        for(int i=0;i<n;i++){
            System.out.print(arr[i]+" ");
        }
    }

    private static void arrayReverse(int[] arr,int l, int r) {
        if(l>=r)
            return;

        swap(arr,l,r);
        arrayReverse(arr,l+1,r-1);
    }

    private static void swap(int[] arr, int l, int r) {
        int temp=arr[l];
        arr[l]=arr[r];
        arr[r]=temp;
    }
}
