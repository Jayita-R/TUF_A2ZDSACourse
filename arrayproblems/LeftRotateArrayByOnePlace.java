package tuf_a2zdsacourse.arrayproblems;

import java.util.Scanner;

import static tuf_a2zdsacourse.sorting.QuickSort.printArray;

public class LeftRotateArrayByOnePlace{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the no. of elements:");
        int n=sc.nextInt();
        int[] arr=new int[n];
        System.out.print("Enter the elements:");
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        rotateByOne(arr,n);
        printArray(arr,n);
    }

    private static void rotateByOne(int[] arr, int n) {
        int temp=arr[0];
        for(int i=1;i<n;i++){
            arr[i-1]=arr[i];
        }
        arr[n-1]=temp;
    }

}
