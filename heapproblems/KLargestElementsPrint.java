package tuf_a2zdsacourse.heapproblems;

import java.util.PriorityQueue;
import java.util.Scanner;

public class KLargestElementsPrint {
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
        kLargestElements(arr,n,k);
    }

    private static void kLargestElements(int[] arr, int n, int k) {
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(int i=0;i<n;i++){
            pq.add(arr[i]);
            if(pq.size()>k){
                pq.poll();
            }
        }
        System.out.println("K Largest elements are:");
        while(pq.size()>0){
            System.out.print(pq.peek()+" ");
            pq.poll();
        }
    }
}
