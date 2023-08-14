package tuf_a2zdsacourse.bsproblems;

import java.util.Scanner;

public class NthRootOfNumber {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the value of n: ");
        int n= sc.nextInt();
        System.out.print("Enter any number:");
        int m= sc.nextInt();
        //int ans=nthRoot(n,m);// bruteforce approach using linear search method
        int ans=nthRootBS(n,m);// Optimal approach using binary search

        System.out.println("The answer is:" +ans);
    }

    private static int nthRootBS(int n, int m) {
        int low=1,high=m;
        while(low<=high){
            int mid=(low+high)/2;
            int midN=nFunc(mid,n,m);
            if(midN==1){
                return mid;
            }else if(midN==0){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return -1;
    }

    private static int nFunc(int mid, int n, int m) {
        long ans=1;
        for(int i=1;i<=n;i++){
            ans=ans*mid;
            if(ans>m) return 2;
        }
        if(ans==m) return 1;
        return 0;
    }

    private static int nthRoot(int n, int m) {
        for(int i=1;i<=m;i++){
            long val=newFunc(i,n);
            if(val==(long)m) return i;
            else if(val>(long)m) break;
        }
        return -1;
    }

    private static long newFunc(int b, int exp) {
        long ans=1;
        long base=b;
        while(exp>0){
            if(exp%2==1){
                exp--;
                ans=ans*base;
            }else{
                exp/=2;
                base=base*base;
            }
        }
        return ans;
    }
}
