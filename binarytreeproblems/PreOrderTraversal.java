package tuf_a2zdsacourse.binarytreeproblems;

import java.util.ArrayList;
import java.util.Stack;

public class PreOrderTraversal {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.left = new Node(8);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.right.right.left = new Node(9);
        root.right.right.right = new Node(10);

        //ArrayList< Integer > preOrder;
        //preOrder = preOrderTrav(root);

        ArrayList< Integer > preOrder=new ArrayList<>();
        preOrderTravRec(root,preOrder);


        System.out.println("The inOrder Traversal is : ");
        for (int i = 0; i < preOrder.size(); i++) {
            System.out.print(preOrder.get(i) + " ");
        }
    }

    private static ArrayList<Integer> preOrderTrav(Node root) {
        ArrayList<Integer> preOrder=new ArrayList<>();
        if(root==null)
            return preOrder;

        Stack<Node> s=new Stack<>();
        s.push(root);
        while(!s.isEmpty()){
            Node topNode = s.peek();
            preOrder.add(topNode.key);
            s.pop();
            if (topNode.right != null)
                s.push(topNode.right);
            if (topNode.left != null)
                s.push(topNode.left);
        }
        return preOrder;

    }

    private static void preOrderTravRec(Node root, ArrayList<Integer> preOrder) {
        if(root==null)
            return;
        preOrder.add(root.key);
        preOrderTravRec(root.left,preOrder);
        preOrderTravRec(root.right,preOrder);
    }
}
