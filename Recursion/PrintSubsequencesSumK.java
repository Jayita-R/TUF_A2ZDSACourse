package tuf_a2zdsacourse.Recursion;

import java.util.ArrayList;
import java.util.Scanner;

public class PrintSubsequencesSumK {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the no.of elements:");
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        System.out.print("Enter the target sum value:");
        int k=sc.nextInt();
        ArrayList<Integer> ds=new ArrayList<>();
        printSubsequencesSumK(0,ds,arr,n,k,0);
    }

    private static void printSubsequencesSumK(int i, ArrayList<Integer> ds, int[] arr, int n,int k,int sum) {
        if(i==n){
            if(sum==k) {
                for (int j : ds) System.out.print(j + " ");
                System.out.println();
            }
            return;
        }
        ds.add(arr[i]);
        sum+=arr[i];
        printSubsequencesSumK(i+1,ds,arr,n,k,sum);
        ds.remove(ds.size()-1);
        sum-=arr[i];
        printSubsequencesSumK(i+1,ds,arr,n,k,sum);
    }
}
