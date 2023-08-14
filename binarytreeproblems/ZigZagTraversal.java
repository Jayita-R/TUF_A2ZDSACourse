package tuf_a2zdsacourse.binarytreeproblems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class ZigZagTraversal {
    public static void main(String[] args) {
        int i, j;
        Node root = new Node(3);
        root.left = new Node(9);
        root.right = new Node(20);
        root.right.left = new Node(15);
        root.right.right = new Node(7);
        ArrayList <ArrayList< Integer >> ans;
        ans = zigzagLevelOrder(root);
        System.out.println("Zig Zag Traversal of Binary Tree ");
        for (i = 0; i < ans.size(); i++) {
            for (j = 0; j < ans.get(i).size(); j++) {
                System.out.print(ans.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }

    private static ArrayList<ArrayList<Integer>> zigzagLevelOrder(Node root) {
        Queue<Node> q=new LinkedList<>();
        ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
        if(root==null){
            return ans;
        }
        q.offer(root);
        boolean flag=true;
        while(!q.isEmpty()){
            int lNum=q.size();
            ArrayList<Integer> subList=new ArrayList<>(lNum);
            for(int i=0;i<lNum;i++){
                int index=i;
                if(q.peek().left!=null) q.offer(q.peek().left);
                if(q.peek().right!=null) q.offer(q.peek().right);
                if(flag==true) subList.add(q.poll().key);
                else subList.add(0,q.poll().key);
            }
            flag=!flag;
            ans.add(subList);
        }
        return ans;
    }
}
