package tuf_a2zdsacourse.arrayproblems;

import java.util.ArrayList;
import java.util.Scanner;

public class RearrangeArrayBySign {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the no. of elements:");
        int n=sc.nextInt();
        int[] arr=new int[n];
        System.out.print("Enter the elements:");
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        //int[] ans=rearrangeArray(arr,n);
        //int[] res=rearrangeArrayOptimal(arr,n);
        int[] fres=rearrangeArrayAnotherVariety(arr,n);
        System.out.print("Rearranged array is:");
        for(int i=0;i<n;i++){
            System.out.print(fres[i]+" ");
        }

    }

    public static int[] rearrangeArrayAnotherVariety(int[] arr, int n) {
        // Define 2 ArrayLists, one for storing positive
        // and other for negative elements of the array.
        ArrayList<Integer> pos = new ArrayList<>();
        ArrayList<Integer> neg = new ArrayList<>();
        int[] res=new int[n];

        // Segregate the array into positives and negatives.
        for (int i = 0; i < n; i++) {
            if (arr[i] > 0)
                pos.add(arr[i]);
            else
                neg.add(arr[i]);
        }

        // If positives are lesser than the negatives.
        if (pos.size() < neg.size()) {

            // First, fill array alternatively till the point
            // where positives and negatives are equal in number.
            for (int i = 0; i < pos.size(); i++) {
                res[2*i]=pos.get(i);
                res[2*i+1]=neg.get(i);
            }

            // Fill the remaining negatives at the end of the array.
            int index = pos.size() * 2;
            for (int i = pos.size(); i < neg.size(); i++) {
                res[index]=neg.get(i);
                index++;
            }
        }

        // If negatives are lesser than the positives.
        else {
            // First, fill array alternatively till the point
            // where positives and negatives are equal in number.
            for (int i = 0; i < neg.size(); i++) {
                res[2*i]=pos.get(i);
                res[2*i+1]=neg.get(i);
            }

            // Fill the remaining positives at the end of the array.
            int index = neg.size() * 2;
            for (int i = neg.size(); i < pos.size(); i++) {
                res[index]=pos.get(i);
                index++;
            }
        }
        return res;
    }

    public static int[] rearrangeArrayOptimal(int[] arr, int n) {
        int posIndex=0,negIndex=1;
        int[] ans=new int[n];
        for(int i=0;i<n;i++){
            if(arr[i]<0){
                ans[negIndex]=arr[i];
                negIndex+=2;
            }else{
                ans[posIndex]=arr[i];
                posIndex+=2;
            }
        }
        return ans;
    }

    public static int[] rearrangeArray(int[] arr, int n) {
        ArrayList<Integer> pos=new ArrayList<>();
        ArrayList<Integer> neg=new ArrayList<>();

        for(int i=0;i<n;i++){
            if(arr[i]<0) neg.add(arr[i]);
            else pos.add(arr[i]);
        }

        for(int i=0;i<n/2;i++){
            arr[2*i]=pos.get(i);
            arr[2*i+1]=neg.get(i);
        }

        return arr;
    }
}
