package tuf_a2zdsacourse.binarytreeproblems;

public class CheckForBalancedBT {
    public static void main(String[] args) {
        Node root = new Node(4);
        root.left = new Node(7);
        root.right = new Node(8);
        root.right.left = new Node(1);
        root.right.right = new Node(0);
        root.right.left.left = new Node(3);
        root.right.left.right = new Node(5);

        //boolean balanced=balancedTree(root);
        boolean balanced=isBalanced(root);
        System.out.println("Is the tree balanced? : "+balanced);
    }

    private static boolean balancedTree(Node root) {
        if(root==null)
            return true;
        int lh=findHeight(root.left);
        int rh=findHeight(root.right);

        if(Math.abs(lh-rh)>1) return false;
        boolean left=balancedTree(root.left);
        boolean right=balancedTree(root.right);
        if(!left || !right) return false;
        return true;
    }

    public static int findHeight(Node root) {
        if(root == null) return 0;

        int lh = findHeight(root.left);
        int rh = findHeight(root.right);

        return 1 + Math.max(lh, rh);
    }

    public static boolean isBalanced(Node root) {
        return dfsHeight (root) != -1;
    }
    public static int dfsHeight (Node root) {
        if (root == null) return 0;

        int leftHeight = dfsHeight(root.left);
        if (leftHeight == -1) return -1;
        int rightHeight = dfsHeight(root.right);
        if (rightHeight == -1) return -1;

        if (Math.abs(leftHeight - rightHeight) > 1) return -1;
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
