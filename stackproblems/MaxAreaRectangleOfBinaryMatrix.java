package tuf_a2zdsacourse.stackproblems;

import javafx.util.Pair;

import java.util.Scanner;
import java.util.Stack;

public class MaxAreaRectangleOfBinaryMatrix {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the n:");
        int n=sc.nextInt();
        System.out.println("Enter the m:");
        int m=sc.nextInt();
        int[][] arr=new int[n][m];
        System.out.println("Enter the elements");
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        System.out.println("Max Area of Rectangle is:"+maxAreaRectangle(arr,n,m));
        
    }

    private static int maxAreaRectangle(int[][] arr, int n, int m) {
        int[] res=new int[m];
        for(int j=0;j<m;j++){
            res[j]=arr[0][j];
        }
        int max=mah(res);
        for(int i=1;i<n;i++){
            for(int j=0;j<m;j++){
                if(arr[i][j]==0)
                    res[j]=0;
                else
                    res[j]=res[j]+arr[i][j];
            }
            max=Math.max(max,mah(res));
        }
        return max;
    }

    private static int mah(int[] res) {
        int n=res.length;
        int[] r=nearestSmallerToRight(res,n);
        int[] l=nearestSmallerToLeft(res,n);
        int[] width=new int[n];
        for(int i=0;i<n;i++){
            width[i]=r[i]-l[i]-1;
        }
        int[] area=new int[n];
        int max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            area[i]=res[i]*width[i];
            max=Math.max(max,area[i]);
        }
        return max;
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
