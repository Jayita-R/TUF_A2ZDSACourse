package tuf_a2zdsacourse.heapproblems;

import java.util.PriorityQueue;
import java.util.Scanner;

public class ConnectRopesToMinimiseCost {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the no.of elements: ");
        int n=sc.nextInt();
        int[] arr=new int[n];
        System.out.print("Enter the elements:");
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        System.out.print("Min. Cost is:"+minCostOfRopes(arr,n));
    }

    private static int minCostOfRopes(int[] arr, int n) {
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        int cost=0;
        for(int i=0;i<n;i++){
            pq.add(arr[i]);
        }
        while(pq.size()>=2){
            int f=pq.peek();
            pq.poll();
            int s=pq.peek();
            pq.poll();
            int sum=f+s;
            cost+=sum;
            pq.add(sum);
        }
        return cost;

    }
}
