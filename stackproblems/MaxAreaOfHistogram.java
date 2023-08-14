package tuf_a2zdsacourse.stackproblems;

import javafx.util.Pair;

import java.util.Scanner;
import java.util.Stack;

public class MaxAreaOfHistogram {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the no.of elements: ");
        int n=sc.nextInt();
        int[] arr=new int[n];
        System.out.print("Enter the elements: ");
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        int[] r=nearestSmallerToRight(arr,n);
        int[] l=nearestSmallerToLeft(arr,n);
        int[] width=new int[n];
        for(int i=0;i<n;i++){
            width[i]=r[i]-l[i]-1;
        }
        int[] area=new int[n];
        int max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            area[i]=arr[i]*width[i];
            max=Math.max(max,area[i]);
        }

        System.out.println("Max. area is: "+max);
    }

    private static int[] nearestSmallerToLeft(int[] arr, int n) {
        int[] res=new int[n];
        Stack<Pair<Integer,Integer>> st=new Stack<>();
        int pI=-1;
        for(int i=0;i<n;i++){
            if(st.size()==0){
                res[i]=pI;
            }
            else if(st.size()>0 && st.peek().getKey()<arr[i]){
                res[i]=st.peek().getValue();
            }
            else if(st.size()>0 && st.peek().getKey()>=arr[i]){
                while(st.size()>0 && st.peek().getKey()>=arr[i]){
                    st.pop();
                }
                if(st.size()==0){
                    res[i]=pI;
                }else{
                    res[i]=st.peek().getValue();
                }
            }
            st.push(new Pair(arr[i],i));
        }
        return res;
    }

    private static int[] nearestSmallerToRight(int[] arr, int n) {
        int[] res=new int[n];
        Stack<Pair<Integer,Integer>> st=new Stack<>();
        int pI=n;
        for(int i=n-1;i>=0;i--){
            if(st.size()==0){
                res[i]=pI;
            }
            else if(st.size()>0 && st.peek().getKey()<arr[i]){
                res[i]=st.peek().getValue();
            }
            else if(st.size()>0 && st.peek().getKey()>=arr[i]){
                while(st.size()>0 && st.peek().getKey()>=arr[i]){
                    st.pop();
                }
                if(st.size()==0){
                    res[i]=pI;
                }else{
                    res[i]=st.peek().getValue();
                }
            }
            st.push(new Pair(arr[i],i));
        }
        return res;
    }

}
