package tuf_a2zdsacourse.binarytreeproblems;

import java.util.ArrayList;

public class MorrisInOrderTrav {
    public static void main(String[] args) {
        Node root=new Node(1);
        root.left=new Node(2);
        root.left.left=new Node(4);
        root.left.right=new Node(5);
        root.left.right.right=new Node(6);
        root.right=new Node(3);
        ArrayList<Integer> ans=morrisInorderTrav(root);
        System.out.println("InOrder list is:");
        for(int val:ans){
            System.out.print(val+" ");
        }
    }

    private static ArrayList<Integer> morrisInorderTrav(Node root) {
        ArrayList<Integer> inord=new ArrayList<>();
        Node cur=root;
        while(cur!=null){
            if(cur.left==null){
                inord.add(cur.key);
                cur=cur.right;
            }
            else{
                Node prev=cur.left;
                while(prev.right!=null && prev.right!=cur){
                    prev=prev.right;
                }

                if(prev.right==null){
                    prev.right=cur;
                    cur=cur.left;
                }else{
                    prev.right=null;
                    inord.add(cur.key);
                    cur=cur.right;
                }
            }
        }
        return inord;
    }
}
