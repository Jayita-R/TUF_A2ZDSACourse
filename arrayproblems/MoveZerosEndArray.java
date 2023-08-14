package tuf_a2zdsacourse.arrayproblems;

import java.util.Scanner;

import static tuf_a2zdsacourse.sorting.QuickSort.printArray;

public class MoveZerosEndArray {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the no. of elements:");
        int n=sc.nextInt();
        int[] arr=new int[n];
        System.out.print("Enter the elements:");
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        moveZero(arr,n);
        printArray(arr,n);
    }

    private static void moveZero(int[] arr, int n) {
        int j=-1;
        for(int i=0;i<n;i++){
            if(arr[i]==0){
                j=i;
                break;
            }
        }

        for(int i=j+1;i<n;i++){
            if(arr[i]!=0){
                int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;

                j++;
            }
        }
    }
}
