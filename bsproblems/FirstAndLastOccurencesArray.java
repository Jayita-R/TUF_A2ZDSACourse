package tuf_a2zdsacourse.bsproblems;

import java.util.Scanner;

//using linear search
public class FirstAndLastOccurencesArray {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter no.of elements:");
        int n=sc.nextInt();
        int[] arr=new int[n];
        System.out.println("Enter the elements:");
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        System.out.println("Enter any element:");
        int x=sc.nextInt();
        int first=-1,last=-1;
        for(int i=0;i<n;i++){
            if(arr[i]==x){
                if(first==-1){
                    first=i;
                }
                last=i;
            }
        }
        System.out.println("First and Last occurence is ("+first+", "+last+")");
    }
}
