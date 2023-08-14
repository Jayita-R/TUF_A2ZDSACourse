package tuf_a2zdsacourse;

import java.util.Arrays;
import java.util.Scanner;

public class FrequencyArrayEle {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter no of elements");
        int n=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        //precompute
        int[] hash=new int[13];
        Arrays.fill(hash,0);
        for(int i=0;i<n;i++){
            hash[arr[i]]+=1;
        }

        System.out.print("Enter the no.of queries");
        int q=sc.nextInt();
        int i=0;
        while(i<q){
            int no=sc.nextInt();
            i++;
            //fetch
            System.out.print(hash[no]+" ");
        }
    }
}
