package tuf_a2zdsacourse.arrayproblems;

import java.util.*;
import java.util.stream.Collectors;

public class NextGreaterPermutation {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter no. of elements:");
        int n=sc.nextInt();
        int[] arr=new int[n];
        System.out.print("Enter the elements:");
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        //List<Integer> A= Arrays.asList(new Integer[]{2,1,5,4,3,0,0});
        List<Integer> ans=nextGreaterElement(arr);

        System.out.print("The next permutation is:");
        for(int i=0;i<ans.size();i++){
            System.out.print(ans.get(i) + " ");
        }
    }

    public static List<Integer> nextGreaterElement(int[] arr) {
        List<Integer> A=Arrays.stream(arr).boxed().collect(Collectors.toList());
        //step 1:find the breakpoint
        int n=A.size();
        int ind=-1;
        for(int i=n-2;i>=0;i--){
            if(A.get(i)<A.get(i+1)){
                ind=i;
                break;
            }
        }
        // If break point does not exist:
        if (ind == -1) {
            // reverse the whole array:
            Collections.reverse(A);
            return A;
        }
        // Step 2: Find the next greater element
        //         and swap it with arr[ind]:

        for (int i = n - 1; i > ind; i--) {
            if (A.get(i) > A.get(ind)) {
                int tmp = A.get(i);
                A.set(i, A.get(ind));
                A.set(ind, tmp);
                break;
            }
        }
        // Step 3: reverse the right half:
        List<Integer> sublist = A.subList(ind + 1, n);
        Collections.reverse(sublist);

        return A;
    }
}
