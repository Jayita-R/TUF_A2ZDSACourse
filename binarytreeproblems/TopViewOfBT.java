package tuf_a2zdsacourse.binarytreeproblems;

import java.util.*;

class pair{
    Node n;
    int data;
    public pair(Node _node,int _val){
        n=_node;
        data=_val;
    }
}

public class TopViewOfBT {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.left = new Node(6);
        root.right = new Node(3);
        root.right.right = new Node(7);

        ArrayList <Integer> list = new ArrayList< >();
        list = topViewOfBT(root);

        System.out.println("The top View Traversal is : ");
        for (int nodeVal: list) {
            System.out.print(nodeVal + " ");
        }
    }

    private static ArrayList<Integer> topViewOfBT(Node root) {
        ArrayList<Integer> ls=new ArrayList<>();
        Queue<pair> q=new LinkedList<>();
        Map<Integer,Integer> map=new TreeMap<>();
        q.offer(new pair(root,0));
        while(!q.isEmpty()){
            pair it=q.remove();
            int hd=it.data;
            Node temp=it.n;
            if(map.get(hd)==null) map.put(hd,temp.key);
            if(temp.left!=null){
                q.offer(new pair(temp.left,hd-1));
            }
            if(temp.right!=null){
                q.offer(new pair(temp.right,hd+1));
            }
        }

        for(Map.Entry<Integer,Integer> it:map.entrySet()){
            ls.add(it.getValue());
        }
        return ls;

    }
}
