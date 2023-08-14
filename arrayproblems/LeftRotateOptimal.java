package tuf_a2zdsacourse.arrayproblems;

import java.util.Scanner;

import static tuf_a2zdsacourse.sorting.QuickSort.printArray;

public class LeftRotateOptimal {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the no. of elements:");
        int n=sc.nextInt();
        int[] arr=new int[n];
        System.out.print("Enter the elements:");
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        System.out.print("Enter d value:");
        int d= sc.nextInt();
        rotate(arr,n,d);
        printArray(arr,n);
    }

    public static void rotate(int[] arr, int n, int d) {
        d=d%n;
        reverse(arr,0,d-1);
        reverse(arr,d,n-1);
        reverse(arr,0,n-1);
    }
    public static void reverse(int[] arr,int start,int end){
         while(start<end){
             int temp=arr[start];
             arr[start]=arr[end];
             arr[end]=temp;
             start++;
             end--;
         }
    }
}
