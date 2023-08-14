package tuf_a2zdsacourse.arrayproblems;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SubarrayWithGivenSum {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the no. of elements:");
        int n= sc.nextInt();
        int[] arr=new int[n];
        System.out.print("Enter the elements: ");
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        System.out.print("Enter the target sum value:");
        int k= sc.nextInt();
        //int res=numberOfSubarraysWithGivenSum(arr,n,k);
        //int ans=numberOfSubarraysWithGivenSumBetterApproach(arr,n,k);
        int fres=numberOfSubarraysWithGivenSumOptimal(arr,n,k);
        System.out.println("The total no. of subarray is: "+fres);
    }

    public static int numberOfSubarraysWithGivenSumOptimal(int[] arr, int n, int k) {
        Map<Integer, Integer> mpp = new HashMap<Integer, Integer>();
        int preSum = 0, cnt = 0;

        mpp.put(0, 1); // Setting 0 in the map.
        for (int i = 0; i < n; i++) {
            // add current element to prefix Sum:
            preSum += arr[i];

            // Calculate x-k:
            int remove = preSum - k;

            // Add the number of subarrays to be removed:
            cnt += mpp.getOrDefault(remove, 0);

            // Update the count of prefix sum
            // in the map.
            mpp.put(preSum, mpp.getOrDefault(preSum, 0) + 1);
        }
        return cnt;
    }

    public static int numberOfSubarraysWithGivenSumBetterApproach(int[] arr, int n, int k) {
        int cnt = 0; // Number of subarrays:

        for (int i = 0 ; i < n; i++) { // starting index i
            int sum = 0;
            for (int j = i; j < n; j++) { // ending index j
                // calculate the sum of subarray [i...j]
                // sum of [i..j-1] + arr[j]
                sum += arr[j];

                // Increase the count if sum == k:
                if (sum == k)
                    cnt++;
            }
        }
        return cnt;
    }

    public static int numberOfSubarraysWithGivenSum(int[] arr, int n, int k) {
        int cnt=0;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                int sum = 0;
                for(int l=i;l<=j;l++)
                    sum += arr[l];
                if(sum==k)
                    cnt++;
            }
        }
        return cnt;
    }
}
