package tuf_a2zdsacourse.sorting;

import java.util.Scanner;

public class CountSort {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the no.of elements:");
        int n=sc.nextInt();
        int[] arr=new int[n];
        System.out.println("Enter the elements in the array");
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }

        int[] res=countSort(arr,n);
        System.out.println("After sorting:");
        for(int i=0;i<n;i++){
            System.out.print(res[i]+" ");
        }
    }

    public static int[] countSort(int[] arr, int n) {
        int k=arr[0];
        for(int i=0;i<n;i++){
            k=Math.max(k,arr[i]);
        }
        int[] count=new int[n];
        for(int i=0;i<n;i++){
            count[arr[i]]++;
        }
        for(int i=1;i<=k;i++){
            count[i]+=count[i-1];
        }
        int []out=new int[n];
        for(int i=n-1;i>=0;i--){
            out[count[arr[i]]-1]=arr[i];
            --count[arr[i]];
        }
        for(int i=0;i<n;i++){
            arr[i]=out[i];
        }
        return arr;
    }
}
