package tuf_a2zdsacourse.arrayproblems;

import java.util.Arrays;
import java.util.Scanner;

public class FindDuplicate {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the no.of elements");
        int n=sc.nextInt();
        int[] arr=new int[n];
        System.out.println("Enter the elements in the array");
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        //int num=duplicateBrute(arr,n);
        //int num=duplicateBetter(arr,n);
        //int num=duplicateOptimal(arr,n);
        int num=duplicateOptimalByLLCycleMethod(arr,n);
        System.out.println("Duplicate number is:"+num);


    }

    public static int duplicateOptimalByLLCycleMethod(int[] arr, int n) {
        int slow=arr[0];
        int fast=arr[0];
        do{
            slow=arr[slow];
            fast=arr[arr[fast]];
        }while(slow!=fast);
        fast=arr[0];
        while(slow!=fast){
            slow=arr[slow];
            fast=arr[fast];
        }
        return slow;
    }

    public static int duplicateOptimal(int[] arr, int n) {
        int dupNum=0;
        int i=0;
        while(i<n){
            int correct=arr[i]-1;
            if(arr[i]!=arr[correct]){
                int temp=arr[i];
                arr[i]=arr[correct];
                arr[correct]=temp;
            }else{
                i++;
            }
        }
        for(i=0;i<n;i++){
            if(arr[i]!=(i+1)){
                dupNum=arr[i];
            }
        }
        return dupNum;
    }

    private static int duplicateBetter(int[] arr, int n) {
        int[] freq=new int[n+1];
        for(int i=0;i<n;i++){
            if(freq[arr[i]]==0){
                freq[arr[i]]+=1;
            }else{
                return arr[i];
            }
        }
        return 0;
    }

    public static int duplicateBrute(int[] arr, int n) {
        Arrays.sort(arr);
        for(int i=0;i<n-1;i++){
            if(arr[i]==arr[i+1]){
                return arr[i];
            }
        }
        return 0;
    }
}
