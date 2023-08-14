package tuf_a2zdsacourse.sorting;

import java.util.Scanner;

public class SelectionSort {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the no.of elements");
        int n=sc.nextInt();
        int[] arr=new int[n];
        System.out.println("Enter the array elements:");
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        selectionSort(arr,n);
        printArray(arr,n);
    }

    public static void printArray(int[] arr, int n) {
        for(int i=0;i<n;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    public static void selectionSort(int[] arr, int n) {
        for(int i=0;i<=n-2;i++){
            int min=i;
            for(int j=i;j<=n-1;j++){
                if(arr[j]<arr[min]){
                    min=j;
                }
            }
            swap(arr,min,i);
        }
    }

    public static void swap(int[] arr, int min, int i) {
        int temp=arr[min];
        arr[min]=arr[i];
        arr[i]=temp;
    }
}
