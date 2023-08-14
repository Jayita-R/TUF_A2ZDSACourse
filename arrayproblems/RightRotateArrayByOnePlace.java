package tuf_a2zdsacourse.arrayproblems;

import java.util.Scanner;

import static tuf_a2zdsacourse.sorting.QuickSort.printArray;

public class RightRotateArrayByOnePlace {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the no. of elements:");
        int n=sc.nextInt();
        int[] arr=new int[n];
        System.out.print("Enter the elements:");
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        rotateRightByOne(arr,n);
        printArray(arr,n);
    }

    public static void rotateRightByOne(int[] arr, int n) {
        int temp=arr[n-1];
        for(int i=n-2;i>=0;i--){
            arr[i+1]=arr[i];
        }
        arr[0]=temp;
    }
}
