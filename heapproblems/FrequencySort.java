package tuf_a2zdsacourse.heapproblems;

import java.util.*;

public class FrequencySort {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the no.of elements");
        int n=sc.nextInt();
        int[] arr=new int[n];
        System.out.print("Enter the elements:");
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        frequencySort(arr,n);
    }

    private static void frequencySort(int[] arr, int n) {
        Map<Integer,Integer> mpp=new HashMap<>();
        for(int i=0;i<n;i++){
            mpp.put(arr[i],mpp.getOrDefault(arr[i],0)+1);
        }
        PriorityQueue<Map.Entry<Integer,Integer>> maxH=new PriorityQueue<>(new Compare());

        for(Map.Entry<Integer,Integer> m:mpp.entrySet()){
            maxH.add(m);
        }

        while(maxH.size()>0){
            int freq=maxH.peek().getValue();
            int ele=maxH.peek().getKey();
            for(int i=1;i<=freq;i++){
                System.out.print(ele+" ");
            }
            maxH.poll();
        }

    }
}
