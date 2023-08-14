package tuf_a2zdsacourse.binarytreeproblems;

public class InorderSuccessor {
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

        Node p=root.right.right.left;
        Node successor=inorderSuccessor(root,p);
        System.out.println("Inorder successor is: "+successor.key);
    }

    private static Node inorderSuccessor(Node root, Node p) {
        Node suc=null;
        while(root!=null){
            if(p.key>=root.key){
                root=root.right;
            }else{
                suc=root;
                root=root.left;
            }
        }
        return suc;
    }
}
