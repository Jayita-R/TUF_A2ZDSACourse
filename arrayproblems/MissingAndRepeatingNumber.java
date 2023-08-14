package tuf_a2zdsacourse.arrayproblems;

import java.util.ArrayList;
import java.util.Scanner;

public class MissingAndRepeatingNumber {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the no.of elements:");
        int n=sc.nextInt();
        int[] arr=new int[n];
        System.out.println("Enter the elements in the array");
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        //ArrayList<Integer> list=find_missing_repeating(arr);
        ArrayList<Integer> list=find_missing_repeatingOptimal(arr);
        System.out.println("Missing and repeating numbers :");
        for(int i=0;i<list.size();i++){
            System.out.print(list.get(i)+" ");
        }

    }

    public static ArrayList<Integer> find_missing_repeatingOptimal(int[] arr) {
        long n=arr.length;
        long s=(n*(n+1))/2;
        long p=(n*(n+1)*(2*n+1))/6;
        long s1=0,p1=0;
        for(int i=0;i<n;i++){
            s1+=(long)arr[i];
            p1+=(long)arr[i]*(long)arr[i];
        }
        long val1=s1-s;
        long val2=p1-p;
        val2=val2/val1;
        long x=(val1+val2)/2;
        long y=val2-x;

        ArrayList<Integer> ans = new ArrayList<>();

        ans.add((int)x);
        ans.add((int)y);

        return ans;

    }

    public static ArrayList<Integer> find_missing_repeating(int[] arr) {
        ArrayList<Integer> ans=new ArrayList<>();
        int n=arr.length+1;
        int[] sub=new int[n];
        for(int i=0;i< arr.length;i++){
            sub[arr[i]]++;
        }
        for(int i=1;i<=arr.length;i++){
            if(sub[i]==0 || sub[i]>1){
                ans.add(i);
            }
        }
        return ans;
    }
}
