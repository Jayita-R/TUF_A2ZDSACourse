package tuf_a2zdsacourse.binarytreeproblems;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ConstructUTreeWithInPost {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the no. of elements in post:");
        int n= sc.nextInt();
        int[] po=new int[n];
        System.out.println("Enter postorder:");
        for(int i=0;i<n;i++){
            po[i]=sc.nextInt();
        }
        System.out.print("Enter the no. of elements in inorder:");
        int m= sc.nextInt();
        int[] in=new int[m];
        System.out.println("Enter inorder:");
        for(int i=0;i<n;i++){
            in[i]=sc.nextInt();
        }
        Node root=buildTree(po,in);
        System.out.print(root.key);

    }

    private static Node buildTree(int[] po, int[] in) {
        Map< Integer, Integer > hm = new HashMap< Integer, Integer >();

        for (int i = 0; i < in.length; i++) {
            hm.put(in[i], i);
        }

        Node root = buildTreeWithPostIn(in, 0, in.length - 1, po, 0,
                po.length - 1, hm);
        return root;
    }

    private static Node buildTreeWithPostIn(int[] in, int is, int ie, int[] po, int ps, int pe,
                                            Map<Integer, Integer> hm) {
        if (ps > pe || is > ie) return null;

        Node root = new Node(po[pe]);
        int ri = hm.get(root.key);
        int nL = ri - is;

        root.left = buildTreeWithPostIn(in, is, ri-1, po,
                ps, ps+nL-1, hm);
        root.right = buildTreeWithPostIn(in,ri+1, ie, po,
                ps+nL, pe-1, hm);

        return root;
    }
}
