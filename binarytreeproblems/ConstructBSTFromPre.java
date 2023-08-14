package tuf_a2zdsacourse.binarytreeproblems;

import java.util.Scanner;

public class ConstructBSTFromPre {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter no. of elements:");
        int n=sc.nextInt();
        int[] arr=new int[n];
        System.out.println("Enter the elements in array:");
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }

        Node res=bstFromPre(arr);
        System.out.println(res.key);

    }

    private static Node bstFromPre(int[] arr) {
        return bstFromPreBuild(arr,Integer.MAX_VALUE,new int[]{0});
    }

    private static Node bstFromPreBuild(int[] A, int bound, int[] i) {
        if(i[0]==A.length || A[i[0]]>bound) return null;
        Node root=new Node(A[i[0]++]);
        root.left=bstFromPreBuild(A,root.key,i);
        root.right=bstFromPreBuild(A,bound,i);

        return root;
    }
}
