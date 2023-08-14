package tuf_a2zdsacourse.arrayproblems;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter no. of elements:");
        int n=sc.nextInt();
        int[] arr=new int[n];
        System.out.print("Enter the elements:");
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        int res=longestConsecutiveSequence(arr);
        int fres=longestConsecutiveSequenceOptimal(arr);
        System.out.println("Longest length of consecutive sequence is: "+fres);
    }

    public static int longestConsecutiveSequenceOptimal(int[] arr) {
        Set< Integer > hashSet = new HashSet< Integer >();
        for (int num: arr) {
            hashSet.add(num);
        }

        int longestStreak = 0;

        for (int num: arr) {
            if (!hashSet.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                while (hashSet.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }

                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
    }

    public static int longestConsecutiveSequence(int[] arr) {
        if(arr.length == 0 || arr == null){
            return 0;
        }
        Arrays.sort(arr);
        int ans = 1;
        int prev = arr[0];
        int cur = 1;

        for(int i = 1;i < arr.length;i++){
            if(arr[i] == prev+1){
                cur++;
            }
            else if(arr[i] != prev){
                cur = 1;
            }
            prev = arr[i];
            ans = Math.max(ans, cur);
        }
        return ans;
    }
}
