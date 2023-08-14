package tuf_a2zdsacourse.binarytreeproblems;

import java.util.ArrayList;
import java.util.Stack;

public class PostOrderTraversal {
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

        //ArrayList< Integer > postOrder;
        //postOrder = postOrderTrav(root);

        ArrayList< Integer > postOrder;
        postOrder = postOrderTravUsingOneStack(root);

        //ArrayList<Integer> postOrder = new ArrayList<>();
        //postOrderTravRec(root, postOrder);


        System.out.println("The postOrder Traversal is : ");
        for (int i = 0; i < postOrder.size(); i++) {
            System.out.print(postOrder.get(i) + " ");
        }
    }

    private static ArrayList<Integer> postOrderTravUsingOneStack(Node cur) {
        ArrayList < Integer > postOrder = new ArrayList < > ();
        if (cur == null) return postOrder;

        Stack < Node > st = new Stack < > ();
        while (cur != null || !st.isEmpty()) {

            if (cur != null) {
                st.push(cur);
                cur = cur.left;
            } else {
                Node temp = st.peek().right;
                if (temp == null) {
                    temp = st.peek();
                    st.pop();
                    postOrder.add(temp.key);
                    while (!st.isEmpty() && temp == st.peek().right) {
                        temp = st.peek();
                        st.pop();
                        postOrder.add(temp.key);
                    }
                } else cur = temp;
            }
        }
        return postOrder;

    }

    private static ArrayList<Integer> postOrderTrav(Node curr) {
        ArrayList < Integer > postOrder = new ArrayList < > ();
        if (curr == null) return postOrder;

        Stack< Node > s1 = new Stack < > ();
        Stack < Node > s2 = new Stack < > ();
        s1.push(curr);
        while (!s1.isEmpty()) {
            curr = s1.peek();
            s1.pop();
            s2.push(curr);
            if (curr.left != null)
                s1.push(curr.left);
            if (curr.right != null)
                s1.push(curr.right);
        }
        while (!s2.isEmpty()) {
            postOrder.add(s2.peek().key);
            s2.pop();
        }
        return postOrder;
    }

    private static void postOrderTravRec(Node root, ArrayList<Integer> postOrder) {
        if(root==null)
            return;
        postOrderTravRec(root.left,postOrder);
        postOrderTravRec(root.right,postOrder);
        postOrder.add(root.key);
    }
}
