package tuf_a2zdsacourse.arrayproblems;

import java.util.ArrayList;
import java.util.Scanner;

public class CountInversions {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the no.of elements:");
        int n=sc.nextInt();
        int[] arr=new int[n];
        System.out.println("Enter the elements in array");
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }

        int tCnt=countPairsBrute(arr,n);
        //int cnt=merge(arr,0,n-1); //optimal sol. using merge sort algo
        System.out.println("Total pairs is:"+tCnt);
    }

    public static int countPairsBrute(int[] arr, int n) {
        int cnt=0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(arr[i]>arr[j])
                    cnt++;
            }
        }
        return cnt;

    }

    private static int merge(int[] arr, int low, int high) {
        int cnt=0;
        if(low>=high) return cnt;
        int mid=(low+high)/2;
        cnt+=merge(arr,low,mid);
        cnt+=merge(arr,mid+1,high);
        cnt+=mergeSort(arr,low,mid,high);

        return cnt;


    }

    public static int mergeSort(int[] arr, int low, int mid, int high) {
        int cnt=0;
        int left=low;
        int right=mid+1;

        ArrayList<Integer> temp=new ArrayList<>();
        while(left<=mid && right<=high){
            if(arr[left]<=arr[right]){
                temp.add(arr[left]);
                left++;
            }
            else{
                cnt+=(mid-left+1);
                temp.add(arr[right]);
                right++;
            }
        }

        while(left<=mid){
            temp.add(arr[left]);
            left++;
        }
        while(right<=high){
            temp.add(arr[right]);
            right++;
        }

        for(int i=low;i<=high;i++){
            arr[i]=temp.get(i-low);
        }


        return cnt;

    }
}
