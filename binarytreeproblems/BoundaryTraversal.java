package tuf_a2zdsacourse.binarytreeproblems;

import java.util.ArrayList;

public class BoundaryTraversal {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(3);
        root.left.left.right = new Node(4);
        root.left.left.right.left = new Node(5);
        root.left.left.right.right = new Node(6);
        root.right = new Node(7);
        root.right.right = new Node(8);
        root.right.right.left = new Node(9);
        root.right.right.left.left = new Node(10);
        root.right.right.left.right = new Node(11);

        ArrayList< Integer > boundaryTraversal;
        boundaryTraversal = printBoundary(root);

        System.out.println("The Boundary Traversal is : ");
        for (int i = 0; i < boundaryTraversal.size(); i++) {
            System.out.print(boundaryTraversal.get(i) + " ");
        }

    }

    private static ArrayList<Integer> printBoundary(Node root) {
        ArrayList<Integer> ans=new ArrayList<>();
        if(isLeaf(root)==false) ans.add(root.key);
        addLeftBoundary(root, ans);
        addLeaves(root, ans);
        addRightBoundary(root, ans);
        return ans;
    }

    private static void addRightBoundary(Node root, ArrayList<Integer> ans) {
        ArrayList<Integer> tmp=new ArrayList<>();
        Node cur=root.right;
        while(cur!=null){
            if(isLeaf(cur)==false) tmp.add(cur.key);
            if(cur.right!=null) cur=cur.right;
            else cur=cur.left;
        }
        int i;
        for(i=tmp.size()-1;i>=0;i--){
            ans.add(tmp.get(i));
        }
    }

    private static void addLeaves(Node root, ArrayList<Integer> ans) {
        if(isLeaf(root)){
            ans.add(root.key);
            return;
        }
        if(root.left!=null) addLeaves(root.left,ans);
        if(root.right!=null) addLeaves(root.right,ans);
    }

    private static void addLeftBoundary(Node root, ArrayList<Integer> ans) {
        Node cur=root.left;
        while(cur!=null){
            if(isLeaf(cur)==false) ans.add(cur.key);
            if(cur.left!=null) cur=cur.left;
            else cur=cur.right;
        }
    }

    private static boolean isLeaf(Node root) {
        return (root.left==null) && (root.right==null);
    }
}
