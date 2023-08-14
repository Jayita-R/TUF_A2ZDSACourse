package tuf_a2zdsacourse.stackproblems;

import java.util.Scanner;

public class RainWaterTrapping {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the no. of elements:");
        int n=sc.nextInt();
        int[] arr=new int[n];
        System.out.println("Enter the elements");
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        System.out.println("Total rain water trapped is: "+rainWaterTrapping(arr,n));
    }

    private static int rainWaterTrapping(int[] arr, int n) {
        int[] maxl=new int[n];
        int[] maxr=new int[n];
        maxl[0]=arr[0];
        for(int i=1;i<n;i++){
            maxl[i]=Math.max(maxl[i-1],arr[i]);
        }
        maxr[n-1]=arr[n-1];
        for(int i=n-2;i>=0;i--){
            maxr[i]=Math.max(maxr[i+1],arr[i]);
        }
        int[] w=new int[n];
        for(int i=0;i<n;i++){
            w[i]=Math.min(maxl[i],maxr[i])-arr[i];
        }
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=w[i];
        }
        return sum;
    }
}
