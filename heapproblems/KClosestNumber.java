package tuf_a2zdsacourse.heapproblems;

import javafx.util.Pair;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class KClosestNumber {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the no.of elements");
        int n=sc.nextInt();
        int[] arr=new int[n];
        System.out.print("Enter the elements:");
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        System.out.println("Enter the value of k:");
        int k=sc.nextInt();
        System.out.println("Enter the value of x:");
        int x=sc.nextInt();
        kClosestNumbers(arr,n,k,x);
    }

    private static void kClosestNumbers(int[] arr, int n, int k, int x) {
        //Pair<Integer,Integer> p=new Pair<>(0,0);
        PriorityQueue<Pair<Integer,Integer>> pq=new PriorityQueue<>((a, b) -> b.getKey() - a.getKey());
        for(int i=0;i<n;i++){
            pq.add(new Pair<>(Math.abs(arr[i]-x),arr[i]));
            if(pq.size()>k){
                pq.poll();
            }
        }
        while(pq.size()>0){
            System.out.print(pq.peek().getValue()+" ");
            pq.poll();
        }

    }
}
