package tuf_a2zdsacourse.Recursion;

import java.util.ArrayList;
import java.util.Scanner;

public class PrintSubsequences {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the no.of elements:");
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        ArrayList<Integer> ds=new ArrayList<>();
        printSubsequences(0,ds,arr,n);
    }

    private static void printSubsequences(int i, ArrayList<Integer> ds, int[] arr, int n) {
        if(i==n){
            for(int j:ds){
                System.out.print(j+" ");
            }
            if(ds.size()==0){
                System.out.print("[]");
            }
            System.out.println();
            return;
        }
        ds.add(arr[i]);
        printSubsequences(i+1,ds,arr,n);
        ds.remove(ds.size()-1);
        printSubsequences(i+1,ds,arr,n);
    }
}
