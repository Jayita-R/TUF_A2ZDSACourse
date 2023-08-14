package tuf_a2zdsacourse.bsproblems;

import java.util.Scanner;

public class SqrtOfNumber {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number:");
        int num=sc.nextInt();
        //int ans=floorSqrt(num); //bruteforce approach using linear search method
        int ans=floorSqrtBS(num); // Optimal approach using binary search
        System.out.println("The floor of square root of " + num + " is: " + ans);
    }

    private static int floorSqrtBS(int num) {
        int low=1,high=num;
        while(low<=high){
            long mid=(low+high)/2;
            long val=mid*mid;
            if(val<=(long)num){
                low=(int)mid+1;
            }else{
                high=(int)mid-1;
            }
        }
        return high;
    }

    private static int floorSqrt(int num) {
        int ans=0;
        for(long i=1;i<=num;i++){
            long val=i*i;
            if(val<=(long)num){
                ans=(int)i;
            }else{
                break;
            }
        }
        return ans;
    }
}
