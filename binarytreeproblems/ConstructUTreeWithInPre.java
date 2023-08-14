package tuf_a2zdsacourse.binarytreeproblems;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ConstructUTreeWithInPre {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the no. of elements in pre:");
        int n= sc.nextInt();
        int[] pre=new int[n];
        System.out.println("Enter preorder:");
        for(int i=0;i<n;i++){
            pre[i]=sc.nextInt();
        }
        System.out.print("Enter the no. of elements in inorder:");
        int m= sc.nextInt();
        int[] in=new int[m];
        System.out.println("Enter inorder:");
        for(int i=0;i<n;i++){
            in[i]=sc.nextInt();
        }
        Node root=buildTree(pre,in);
        System.out.print(root.key);

    }

    private static Node buildTree(int[] pre, int[] in) {
        Map< Integer, Integer > inMap = new HashMap< Integer, Integer >();

        for (int i = 0; i < in.length; i++) {
            inMap.put(in[i], i);
        }

        Node root = buildTreeWithPreIn(pre, 0, pre.length - 1, in, 0,
                in.length - 1, inMap);
        return root;
    }

    private static Node buildTreeWithPreIn(int[] pre, int preSt, int preEnd, int[] in, int inSt, int inEnd,
                                           Map<Integer, Integer> inMap) {
        if (preSt > preEnd || inSt > inEnd) return null;

        Node root = new Node(pre[preSt]);
        int inRoot = inMap.get(root.key);
        int numsLeft = inRoot - inSt;

        root.left = buildTreeWithPreIn(pre, preSt + 1, preSt + numsLeft, in,
                inSt, inRoot - 1, inMap);
        root.right = buildTreeWithPreIn(pre,preSt + numsLeft + 1, preEnd, in,
                inRoot + 1, inEnd, inMap);

        return root;
    }
}
