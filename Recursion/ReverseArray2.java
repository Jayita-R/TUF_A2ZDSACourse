package tuf_a2zdsacourse.Recursion;

import java.util.Scanner;


public class ReverseArray2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the no.of elements");
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        arrayReverse2(arr,0);
        System.out.println("Reversed Array :");
        for(int i=0;i<n;i++){
            System.out.print(arr[i]+" ");
        }
    }

    private static void arrayReverse2(int[] arr, int i) {
        if(i>=arr.length/2)
            return;

        swapFunc(arr,i,arr.length-i-1);
        arrayReverse2(arr,i+1);
    }

    private static void swapFunc(int[] arr, int i, int i1) {
        int temp=arr[i];
        arr[i]=arr[i1];
        arr[i1]=temp;
    }
}
