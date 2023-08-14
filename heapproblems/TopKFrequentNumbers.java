package tuf_a2zdsacourse.heapproblems;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

public class TopKFrequentNumbers {
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
        int[] res=topKFrequentNumbers(arr,n,k);
        System.out.println("k Frequent Numbers are:");
        for(int i=0;i<res.length;i++){
            System.out.print(res[i]+" ");
        }
    }

    private static int[] topKFrequentNumbers(int[] arr, int n, int k) {
        Map<Integer,Integer> mpp=new HashMap<>();
        for(int i=0;i<n;i++){
            mpp.put(arr[i],mpp.getOrDefault(arr[i],0)+1);
        }
        PriorityQueue<Integer> pq=new PriorityQueue<>((num1,num2)->mpp.get(num1)-mpp.get(num2));
        for(int num:mpp.keySet()){
            pq.add(num);
            if(pq.size()>k){
                pq.poll();
            }
        }
        int[] ans=new int[k];
        for(int i=k-1;i>=0;i--){
            ans[i]=pq.poll();
        }
        return ans;
    }
}
