package tuf_a2zdsacourse.arrayproblems;

import java.util.Arrays;
import java.util.Scanner;

public class MergeTwoSortedArrays {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the value of n:");
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        System.out.print("Enter the value of m:");
        int m=sc.nextInt();
        int[] arr1=new int[m];
        for(int i=0;i<m;i++){
            arr1[i]=sc.nextInt();
        }
        //merge(arr,arr1,n,m);
        //mergeOptimalOne(arr,arr1,n,m);
        mergeOptimalGapMethod(arr,arr1,n,m);  //It's the another optimal sol. of this problem by using Gap method and in the gap
                                              // method technique which is used based on Shell sort.
        System.out.println("After merge:");
        for (int i=0;i<n;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
        for (int i=0;i<m;i++){
            System.out.print(arr1[i]+" ");
        }
    }

    private static void mergeOptimalGapMethod(int[] arr, int[] arr1, int n, int m) {
        int len=n+m;
        int gap=(len/2)+(len%2);
        while(gap>0){
            int left=0;
            int right=left+gap;
            while(right<len){
                //arr1 and arr2
                if(left<n && right>=n){
                    swapIfGreater(arr,arr1,left,right-n);
                }
                //arr2 and arr2
                else if(left>=n){
                    swapIfGreater(arr1,arr1,left-n,right-n);
                }
                //arr1 and arr1
                else{
                    swapIfGreater(arr,arr,left,right);
                }
                left++;
                right++;
            }
            if(gap==1) break;
            gap=(gap/2)+(gap%2);
        }
    }

    private static void swapIfGreater(int[] arr, int[] arr1, int ind1, int ind2) {
        if(arr[ind1]>arr1[ind2]){
            int temp=arr[ind1];
            arr[ind1]=arr1[ind2];
            arr1[ind2]=temp;
        }
    }

    public static void mergeOptimalOne(int[] arr, int[] arr1, int n, int m) {
        int left=n-1;
        int right=0;
        while(left>=0 && right<m){
            if(arr[left]>arr1[right]){
                int temp=arr[left];
                arr[left]=arr1[right];
                arr1[right]=temp;

                left--;
                right++;
            }else{
                break;
            }
        }
        Arrays.sort(arr);
        Arrays.sort(arr1);
    }

    public static void merge(int[] arr, int[] arr1, int n, int m) {
        int[] arr2=new int[n+m];
        int f=0;
        int s=0;
        int k=0;
        while(f<n && s<m){
            if(arr[f]<=arr1[s]){
                arr2[k++]=arr[f++];
            }else{
                arr2[k++]=arr1[s++];
            }
        }
        while(f<n){
            arr2[k++]=arr[f++];
        }
        while(s<m){
            arr2[k++]=arr1[s++];
        }

        for(int i=0;i<n+m;i++){
            if(i<n) arr[i]=arr2[i];
            else arr1[i-n]=arr2[i];
        }
    }
}
