package tuf_a2zdsacourse.arrayproblems;

import java.util.Scanner;

import static tuf_a2zdsacourse.sorting.QuickSort.printArray;

public class RightRotateBrute {
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
        rightRotate(arr,n,d);
        printArray(arr,n);
    }

    private static void rightRotate(int[] arr, int n, int d) {
        d=d%n;
        int[] temp=new int[d];
        for(int i=n-d;i<n;i++){
            temp[i-(n-d)]=arr[i];
        }
        for(int i=n-d-1;i>=0;i--){
            arr[i+d]=arr[i];
        }
        for(int i=0;i<d;i++){
            arr[i]=temp[i];
        }
    }
}
