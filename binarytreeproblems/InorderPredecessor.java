package tuf_a2zdsacourse.binarytreeproblems;

public class InorderPredecessor {
    public static void main(String[] args) {
        Node root=new Node(5);
        root.left=new Node(2);
        root.left.left=new Node(1);
        root.left.right=new Node(4);
        root.left.right.left=new Node(3);
        root.right=new Node(7);
        root.right.left=new Node(6);
        root.right.right=new Node(9);
        root.right.right.left=new Node(8);
        root.right.right.right=new Node(10);

        Node p=root.left.right.left;
        Node predecessor=inorderPredecessor(root,p);
        System.out.println("Inorder predecessor is: "+predecessor.key);
    }

    private static Node inorderPredecessor(Node root, Node p) {
        Node pred=null;
        while(root!=null){
            if(root.key>=p.key){
                root=root.left;
            }else{
                pred=root;
                root=root.right;
            }
        }
        return pred;
    }
}
