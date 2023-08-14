package tuf_a2zdsacourse.binarytreeproblems;


class Node{
    int key;
    Node left,right;

    public Node(int item) {
        key = item;
        left=right=null;
    }
}
public class BinaryTreeImpl {
    Node root;

    public BinaryTreeImpl(int key) {
        root = new Node(key);
    }

    public BinaryTreeImpl() {
        root=null;
    }

    public static void main(String[] args) {
        BinaryTreeImpl btree=new BinaryTreeImpl();
        btree.root=new Node(1);
        btree.root.left=new Node(2);
        btree.root.right=new Node(3);
        btree.root.left.left=new Node(4);

    }
}
