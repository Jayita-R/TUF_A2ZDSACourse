package tuf_a2zdsacourse.stackproblems;

import javafx.util.Pair;

import java.util.Scanner;
import java.util.Stack;

public class StockSpanProblem {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the no.of elements: ");
        int n=sc.nextInt();
        int[] arr=new int[n];
        System.out.print("Enter the elements: ");
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        int[] ans=stockSpanProblem(arr,n);
        for(int i=0;i<ans.length;i++){
            System.out.print((i-ans[i])+" ");
        }
    }

    private static int[] stockSpanProblem(int[] arr, int n) {
        int[] res=new int[n];
        Stack<Pair<Integer,Integer>> st=new Stack<>();
        for(int i=0;i<n;i++){
            if(st.size()==0){
                res[i]=-1;
            }
            else if(st.size()>0 && st.peek().getKey()>arr[i]){
                res[i]=st.peek().getValue();
            }
            else if(st.size()>0 && st.peek().getKey()<=arr[i]){
                while(st.size()>0 && st.peek().getKey()<=arr[i]){
                    st.pop();
                }
                if(st.size()==0){
                    res[i]=-1;
                }else{
                    res[i]=st.peek().getValue();
                }
            }
            st.push(new Pair(arr[i],i));
        }
        return res;
    }
}
