package tuf_a2zdsacourse.binarytreeproblems;

import java.util.*;

public class LevelOrderTraversal {
    public static void main(String[] args) {
        Node root = new Node(20);
        root.left = new Node(10);
        root.right = new Node(30);
        root.left.left = new Node(5);
        root.left.right = new Node(15);
        //root.right.left = new Node(25);
        //root.right.right = new Node(35);

        //ArrayList< Integer > levelOrder;
        //levelOrder = levelOrderTrav(root);

        ArrayList< Integer > levelOrder;
        levelOrder = levelOrderTravRev(root);


        System.out.println("The reverse levelOrder Traversal is : ");
        for (int i = 0; i < levelOrder.size(); i++) {
            System.out.print(levelOrder.get(i) + " ");
        }
    }

    private static ArrayList<Integer> levelOrderTrav(Node root) {
        Queue<Node> queue = new LinkedList<Node>();
        ArrayList<Integer> wrapList = new ArrayList<Integer>();

        if(root == null) return wrapList;

        queue.offer(root);
        while(!queue.isEmpty()){

            if(queue.peek().left != null)
                queue.offer(queue.peek().left);

            if(queue.peek().right != null)
                queue.offer(queue.peek().right);

            wrapList.add(queue.poll().key);
        }
        return wrapList;
    }

    private static ArrayList<Integer> levelOrderTravRev(Node node) {
        ArrayList<Integer> list=new ArrayList<Integer>();
        Queue<Node> q=new LinkedList<>();
        Stack<Node> st=new Stack<>();
        q.offer(node);
        while(!q.isEmpty()){
            if(q.peek().right!=null){
                q.offer(q.peek().right);
            }
            if(q.peek().left!=null){
                q.offer(q.peek().left);
            }
            Node del=q.peek();
            st.push(del);
            q.poll();

        }

        while(!st.isEmpty()){
            list.add(st.peek().key);
            st.pop();
        }

        return list;
    }
}
