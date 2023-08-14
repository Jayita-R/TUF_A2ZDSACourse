package tuf_a2zdsacourse.heapproblems;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class SumOfElementsBetK1AndK2Smallest {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the no.of elements");
        int n=sc.nextInt();
        int[] arr=new int[n];
        System.out.print("Enter the elements:");
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        System.out.println("Enter the value of k1:");
        int k1=sc.nextInt();
        System.out.println("Enter the value of k2:");
        int k2=sc.nextInt();
        int first=k1thSmallest(arr,n,k1);
        int last=k2thSmallest(arr,n,k2);

        System.out.println("Sum between k1 & k2 smallest numbers is: "+sumBetk1Andk2Smallest(arr,n,first,last));

    }

    private static int sumBetk1Andk2Smallest(int[] arr, int n, int first, int last) {
        int sum=0;
        for(int i=0;i<n;i++){
            if(arr[i]>first && arr[i]<last){
                sum+=arr[i];
            }
        }
        return sum;
    }

    private static int k2thSmallest(int[] arr, int n, int k2) {
        PriorityQueue<Integer> pq=new PriorityQueue<>(Comparator.reverseOrder());
        for(int i=0;i<n;i++){
            pq.add(arr[i]);
            if(pq.size()>k2){
                pq.poll();
            }
        }
        return pq.peek();

    }

    private static int k1thSmallest(int[] arr, int n, int k1) {
        PriorityQueue<Integer> pq=new PriorityQueue<>(Comparator.reverseOrder());
        for(int i=0;i<n;i++){
            pq.add(arr[i]);
            if(pq.size()>k1){
                pq.poll();
            }
        }
        return pq.peek();
    }
}
