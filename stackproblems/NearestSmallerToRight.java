package tuf_a2zdsacourse.stackproblems;

import java.util.Scanner;
import java.util.Stack;

public class NearestSmallerToRight {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the no.of elements: ");
        int n=sc.nextInt();
        int[] arr=new int[n];
        System.out.print("Enter the elements: ");
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        int[] ans=nextSmallerToRight(arr,n);
        for(int i=0;i<ans.length;i++){
            System.out.print(ans[i]+" ");
        }
    }

    private static int[] nextSmallerToRight(int[] arr, int n) {
        int[] res=new int[n];
        Stack<Integer> st=new Stack<>();
        for(int i=n-1;i>=0;i--){
            if(st.size()==0){
                res[i]=-1;
            }
            else if(st.size()>0 && st.peek()<arr[i]){
                res[i]=st.peek();
            }
            else if(st.size()>0 && st.peek()>=arr[i]){
                while(st.size()>0 && st.peek()>=arr[i]){
                    st.pop();
                }
                if(st.size()==0){
                    res[i]=-1;
                }else{
                    res[i]=st.peek();
                }
            }
            st.push(arr[i]);
        }
        return res;
    }
}
