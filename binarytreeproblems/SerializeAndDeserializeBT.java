package tuf_a2zdsacourse.binarytreeproblems;

import java.util.LinkedList;
import java.util.Queue;

public class SerializeAndDeserializeBT {
    public static void main(String[] args) {
        Node root=new Node(1);
        root.left=new Node(2);
        root.left.left=new Node(4);
        root.left.right=new Node(5);
        root.right=new Node(3);
        root.right.right=new Node(6);

        String ans=serialize(root);
        System.out.println(ans);
        Node res=deserialize(ans);
        System.out.println(res.key);
    }

    private static Node deserialize(String ans) {
        if(ans=="") return null;
        Queue<Node> q=new LinkedList<>();
        String[] values=ans.split(" ");
        Node root=new Node(Integer.parseInt(values[0]));
        q.add(root);
        for(int i=1;i<values.length;i++){
            Node pt=q.poll();
            if(!values[i].equals("n")){
                Node left=new Node(Integer.parseInt(values[i]));
                pt.left=left;
                q.add(left);
            }
            if(!values[++i].equals("n")){
                Node right=new Node(Integer.parseInt(values[i]));
                pt.right=right;
                q.add(right);
            }
        }
        return root;
    }

    private static String serialize(Node root) {
        if(root==null) return "";
        Queue<Node> q=new LinkedList<>();
        StringBuilder res=new StringBuilder();
        q.add(root);
        while(!q.isEmpty()){
            Node temp=q.poll();
            if(temp==null){
                res.append("n ");
                continue;
            }
            res.append(temp.key+" ");
            q.add(temp.left);
            q.add(temp.right);
        }
        return res.toString();
    }
}
