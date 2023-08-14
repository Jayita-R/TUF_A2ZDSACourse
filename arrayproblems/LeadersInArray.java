package tuf_a2zdsacourse.arrayproblems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class LeadersInArray {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter no. of elements:");
        int n=sc.nextInt();
        int[] arr=new int[n];
        System.out.print("Enter the elements:");
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        //ArrayList<Integer> ans=printLeadersBruteForce(arr,n);
        ArrayList<Integer> fres=printLeadersOptimal(arr,n);
        System.out.println("Leaders of the array is:");
        for(int i=0;i<fres.size();i++){
            System.out.print(fres.get(i)+" ");
        }

    }

    public static ArrayList<Integer> printLeadersOptimal(int[] arr, int n) {
        ArrayList<Integer> res=new ArrayList<>();
        int max=arr[n-1];
        res.add(arr[n-1]);

        for(int i=n-2;i>=0;i--){
            if(arr[i]>max){
                res.add(arr[i]);
                max=arr[i];
            }
        }
        Collections.reverse(res);  //If in problem mentioned that maintain the orser of the elements then we need to reverse it.
                                   //Or we may need to sort it according to the problem statement.
        return res;
    }

    public static ArrayList<Integer> printLeadersBruteForce(int[] arr, int n) {
        ArrayList<Integer> ans=new ArrayList<>();
        for(int i=0;i<n;i++){
            boolean leader=true;
            for(int j=i+1;j<n;j++){
                if(arr[j]>arr[i]){
                    leader=false;
                    break;
                }
            }
            if(leader==true) ans.add(arr[i]);
        }
        return ans;
    }
}
