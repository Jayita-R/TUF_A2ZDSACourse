package tuf_a2zdsacourse;

import java.util.Scanner;

public class FreqOfArrayElements {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the no.of elements:");
        int n=sc.nextInt();
        int[] arr=new int[n];
        System.out.print("Enter elements:");
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        countFreq(arr,n);
    }

    public static void countFreq(int[] arr, int n) {
        boolean[] visited=new boolean[n];
        for(int i=0;i<n;i++){
            // Skip this element if already processed
            if (visited[i] == true)
                continue;
            // Count frequency
            int count = 1;
            for (int j = i + 1; j < n; j++) {
                if (arr[i] == arr[j]) {
                    visited[j] = true;
                    count++;
                }
            }
            System.out.println(arr[i] + " " + count);
        }
    }
}
