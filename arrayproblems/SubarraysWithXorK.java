package tuf_a2zdsacourse.arrayproblems;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SubarraysWithXorK {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the no.of elements:");
        int n=sc.nextInt();
        int [] arr=new int[n];
        System.out.print("Enter the elements in the array");
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        System.out.println("Enter the value of K: ");
        int k= sc.nextInt();
        //int res=subarraysWithXorKBrute(arr,n,k);
        //int ans=subarraysWithXorKBetter(arr,n,k);
        int fres=subarraysWithXorKOptimal(arr,n,k);
        System.out.println("The no.of subarrays with xor k is: "+fres);
    }

    public static int subarraysWithXorKOptimal(int[] arr, int n, int k) {
        Map<Integer,Integer> mpp=new HashMap<>();
        mpp.put(0,1);
        int xor=0;
        int cnt=0;
        for(int i=0;i<n;i++){
            xor=xor^arr[i];

            int x=xor^k;

            // add the occurrence of xr^k
            // to the count:
            if (mpp.containsKey(x)) {
                cnt += mpp.get(x);
            }

            // Insert the prefix xor till index i
            // into the map:
            if (mpp.containsKey(xor)) {
                mpp.put(xor, mpp.get(xor) + 1);
            } else {
                mpp.put(xor, 1);
            }

        }
        return cnt;
    }

    public static int subarraysWithXorKBetter(int[] arr, int n, int k) {
        int cnt=0;
        for(int i=0;i<n;i++){
            int xor=0;
            for(int j=i;j<n;j++){
                xor = xor ^ arr[j];

                if(xor==k) cnt++;
            }
        }
        return cnt;
    }

    public static int subarraysWithXorKBrute(int[] arr, int n, int k) {
        int cnt=0;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                int xor=0;
                for(int l=i;l<=j;l++) {
                    xor = xor ^ arr[l];
                }

                if(xor==k) cnt++;
            }
        }
        return cnt;
    }
}
