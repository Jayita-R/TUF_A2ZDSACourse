package tuf_a2zdsacourse.bsproblems;

import java.util.Arrays;
import java.util.Scanner;

public class AggressiveCows {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the no. of elements: ");
        int n=sc.nextInt();
        int[] stalls=new int[n];
        System.out.print("Enter the elements: ");
        for(int i=0;i<n;i++){
            stalls[i]=sc.nextInt();
        }
        System.out.print("Enter the value of K: ");
        int k= sc.nextInt();
        //int ans=aggressiveCows(stalls,n,k); ////bruteforce approach using linear search
        int ans=aggressiveCowsBs(stalls,n,k); ////bruteforce approach using linear search
        System.out.println("The maximum possible minimum distance is: " + ans);
    }

    private static int aggressiveCowsBs(int[] stalls, int n, int k) {
        Arrays.sort(stalls);
        int low=1,high=stalls[n-1]-stalls[0];
        while(low<=high){
            int mid=(low+high)/2;
            if(canWePlace(stalls,mid,k)==true){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return high;
    }

    private static int aggressiveCows(int[] stalls, int n, int k) {
        Arrays.sort(stalls);
        int limit=stalls[n-1]-stalls[0];
        for(int i=1;i<=limit;i++){
            if(canWePlace(stalls,i,k)==false){
                return (i-1);
            }
        }
        return limit;
    }

    private static boolean canWePlace(int[] stalls, int dist, int cows) {
        int n=stalls.length;
        int cntCows=1;
        int last=stalls[0];
        for(int i=1;i<n;i++){
            if(stalls[i]-last>=dist){
                ++cntCows;
                last=stalls[i];
            }
            if(cntCows>=cows) return true;
        }
        return false;
    }
}
