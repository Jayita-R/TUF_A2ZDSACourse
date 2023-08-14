package tuf_a2zdsacourse.binarytreeproblems;

import java.util.*;

class Tuple {
    Node node;
    int row;
    int col;
    public Tuple(Node _node, int _row, int _col) {
        node = _node;
        row = _row;
        col = _col;
    }
}

public class VerticalOrderTraversal {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(10);
        root.left.left.right = new Node(5);
        root.left.left.right.right = new Node(6);
        root.right = new Node(3);
        root.right.left = new Node(9);
        root.right.right = new Node(10);

        List < List < Integer >> list = new ArrayList< >();
        list = findVertical(root);

        System.out.println("The Vertical Traversal is : ");
        for (List< Integer > it: list) {
            for (int nodeVal: it) {
                System.out.print(nodeVal + " ");
            }
            System.out.println();
        }
    }


    private static List<List<Integer>> findVertical(Node root) {
        TreeMap<Integer,TreeMap<Integer, PriorityQueue<Integer>>> map=new TreeMap<>();
        Queue< Tuple > q = new LinkedList < Tuple > ();
        q.offer(new Tuple(root,0,0));
        while(!q.isEmpty()){
            Tuple t=q.poll();
            Node n=t.node;
            int x=t.row;
            int y=t.col;

            if(!map.containsKey(x)){
                map.put(x,new TreeMap<>());
            }
            if(!map.get(x).containsKey(y)){
                map.get(x).put(y,new PriorityQueue<>());
            }
            map.get(x).get(y).offer(n.key);
            if(n.left!=null) {
                q.offer(new Tuple(n.left,x-1,y+1));
            }
            if(n.right!=null) {
                q.offer(new Tuple(n.right,x+1,y+1));
            }
        }
        List < List < Integer >> list = new ArrayList < > ();
        for (TreeMap < Integer, PriorityQueue < Integer >> ys: map.values()) {
            list.add(new ArrayList < > ());
            for (PriorityQueue < Integer > nodes: ys.values()) {
                while (!nodes.isEmpty()) {
                    list.get(list.size() - 1).add(nodes.poll());
                }
            }
        }
        return list;
    }
}
