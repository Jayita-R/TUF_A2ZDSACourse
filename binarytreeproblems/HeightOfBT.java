package tuf_a2zdsacourse.binarytreeproblems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

//maximum depth of binary tree- count of nodes of the longest path
public class HeightOfBT {
    public static void main(String[] args) {
        Node root = new Node(12);
        root.left = new Node(2);
        root.right = new Node(5);
        root.left.right = new Node(10);
        root.right.left = new Node(3);
        root.right.right = new Node(4);
        root.right.left.left = new Node(8);
        root.right.left.right = new Node(11);
        root.right.left.left.left = new Node(30);

        //int h = maxDepth(root);
        int h=maxDepthUsingLevelOrderTrav(root);
        System.out.println("Height of Binary Tree is: "+h);

    }

    private static int maxDepthUsingLevelOrderTrav(Node root) {
        if( root == null ){
            return 0;
        }

        LinkedList<Node> queue = new LinkedList<>();
        queue.addLast(root);

        int level = 0;

        while( queue.size() > 0 ){
            int size = queue.size();

            while( size-- > 0 ){
                Node remNode = queue.removeFirst();
                if( remNode.left != null ){
                    queue.addLast( remNode.left );
                }
                if( remNode.right != null ){
                    queue.addLast( remNode.right );
                }
            }

            level++;
        }

        return level;
    }

    public static int maxDepth(Node root) {
        if(root == null) return 0;

        int lh = maxDepth(root.left);
        int rh = maxDepth(root.right);

        return 1 + Math.max(lh, rh);
    }
}
