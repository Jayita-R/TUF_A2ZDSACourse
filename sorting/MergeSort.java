package tuf_a2zdsacourse.sorting;

import java.util.ArrayList;
import java.util.Scanner;

public class MergeSort {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the no.of elements");
        int n=sc.nextInt();
        int[] arr=new int[n];
        System.out.println("Enter the array elements:");
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        mergeSort(arr,0,arr.length-1);
        printArray(arr,n);
    }

    public static void printArray(int[] arr, int n) {
        for(int i=0;i<n;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    public static void mergeSort(int[] arr, int low, int high) {
        if(low>=high)
            return;
        int mid=(low+high)/2;
        mergeSort(arr,low,mid);
        mergeSort(arr,mid+1,high);


        merge(arr,low,mid,high);

    }

    public static void merge(int[] arr, int low, int mid, int high) {
        int[] temp = new int[high-low+1];
        int left=low;
        int right=mid+1;
        int j=0;

        while(left<=mid && right<=high){
            if(arr[left]<=arr[right]){
                temp[j++]=arr[left++];
            }else{
                temp[j++]=arr[right++];
            }
        }
        //it may be possible that one of the arrays is not complete
        //copy the remaining elements
        while(left<= mid) {
            temp[j++]=arr[left++];
        }
        while(right<=high) {
            temp[j++]=arr[right++];
        }
        for(int i=low,p=0;i<=high;i++,p++){
            arr[i]=temp[p];
        }
    }
}
