package tuf_a2zdsacourse.arrayproblems;

import java.util.Scanner;

public class MaxProductSubarray {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the no.of elements:");
        int n=sc.nextInt();
        int[] arr=new int[n];
        System.out.println("Enter the elements in array");
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        int cnt=maxProd(arr,n);
        int tCnt=maxProdOptimal(arr,n);
        System.out.print("Max. Product of subarray is: "+tCnt);
    }

    public static int maxProdOptimal(int[] arr, int n) {
        int max= (int) Long.MIN_VALUE;
        int pre=1,suf=1;
        for(int i=0;i<n;i++){

            if(pre==0) pre=1;
            if(suf==0) suf=1;

            pre*=arr[i];
            suf*=arr[n-i-1];

            max=Math.max(max,Math.max(pre,suf));


        }
        return max;
    }

    public static int maxProd(int[] arr, int n) {
        int max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            int prod=1;
            for(int j=i;j<n;j++){
                prod*=arr[j];

                max=Math.max(max,prod);
            }
        }
        return max;
    }
}
