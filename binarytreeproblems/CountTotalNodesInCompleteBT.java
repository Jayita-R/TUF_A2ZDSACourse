package tuf_a2zdsacourse.binarytreeproblems;

public class CountTotalNodesInCompleteBT {
    public static void main(String[] args) {
        Node  root = new Node(1);
        root . left = new Node(2);
        root . right = new Node(3);
        root . left . left = new Node(4);
        //root . left . right = new Node(5);
        //root . right . left = new Node(6);
        //By using any traversal we can count total no.of nodes
        /*int count[]=new int[1];
        inOrderTrav(root, count);*/
        //Using Height property also we can count the no. of nodes
        int res=countNodes(root);

        //System.out.println("The total number of nodes in the given complete binary tree are: "+count[0]);

        System.out.println("The total number of nodes in the given complete binary tree are: "+res);
    }

    private static int countNodes(Node root) {
        if(root==null) return 0;
        int lh=heightOfLeft(root);
        int rh=heightOfRight(root);
        if(lh==rh) return (1<<lh)-1;
        int leftN=countNodes(root.left);
        int rightN=countNodes(root.right);

        return 1+leftN+rightN;

    }

    private static int heightOfLeft(Node root) {
        int h=0;
        while(root!=null){
            h++;
            root=root.left;
        }
        return h;
    }

    private static int heightOfRight(Node root) {
        int h=0;
        while(root!=null){
            h++;
            root=root.right;
        }
        return h;
    }

    private static void inOrderTrav(Node root, int[] count) {
        if(root==null) return;
        count[0]++;
        inOrderTrav(root.left,count);
        inOrderTrav(root.right,count);
    }
}
