package tuf_a2zdsacourse.binarytreeproblems;

public class DiameterOfBT {
    public static void main(String[] args) {
        Node root = new Node(5);
        root.left = new Node(9);
        root.right = new Node(4);
        root.right.left = new Node(7);
        root.right.left.left = new Node(2);
        root.right.left.left.left = new Node(12);
        root.right.right = new Node(8);
        root.right.right.right = new Node(0);
        root.right.right.left = new Node(1);
        root.right.right.left.left = new Node(3);

        int d=diameterOfBinaryTree(root);
        System.out.println("Diameter of tree is: "+d);
    }

    public static int diameterOfBinaryTree(Node root) {
        int[] diameter = new int[1];
        height(root, diameter);
        return diameter[0];
    }

    private static int height(Node node, int[] diameter) {
        if (node == null) {
            return 0;
        }
        int lh = height(node.left, diameter);
        int rh = height(node.right, diameter);
        diameter[0] = Math.max(diameter[0], lh + rh);
        return 1 + Math.max(lh, rh);
    }
}
