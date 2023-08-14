package tuf_a2zdsacourse.binarytreeproblems;

import java.util.*;

public class NodesAtDistanceOfK {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Node root=new Node(3);
        root.left=new Node(5);
        root.left.left=new Node(6);
        root.left.right=new Node(2);
        root.left.right.left=new Node(7);
        root.left.right.right=new Node(4);
        root.right=new Node(1);
        root.right.left=new Node(0);
        root.right.right=new Node(8);
        System.out.print("Enter distance val:");
        int k=sc.nextInt();
        Node target = root.left;
        List<Integer> ans=new ArrayList<>();
        ans= distanceK(root,target,k);

        for(int val:ans){
            System.out.print(val+" ");
        }
    }

    private static void markParent(Node root, Map<Node,Node> parent_track, Node target){
        Queue<Node> q=new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            Node current=q.poll();
            if(current.left!=null){
                parent_track.put(current.left,current);
                q.offer(current.left);
            }
            if(current.right!=null){
                parent_track.put(current.right,current);
                q.offer(current.right);
            }
        }
    }

    private static List<Integer> distanceK(Node root,Node target,int k){
        Map<Node,Node> parent_track=new HashMap<>();
        markParent(root,parent_track,root);
        Map<Node,Boolean> visited=new HashMap<>();
        Queue<Node> q=new LinkedList<>();
        q.offer(target);
        visited.put(target,true);
        int curr_level=0;
        while(!q.isEmpty()){
            int size=q.size();
            if(curr_level==k) break;
            curr_level++;
            for(int i=0;i<size;i++){
                Node cur=q.poll();
                if(cur.left!=null && visited.get(cur.left)==null){
                    q.offer(cur.left);
                    visited.put(cur.left,true);
                }
                if(cur.right!=null && visited.get(cur.right)==null){
                    q.offer(cur.right);
                    visited.put(cur.right,true);
                }
                if(parent_track.get(cur)!=null && visited.get(parent_track.get(cur))==null){
                    q.offer(parent_track.get(cur));
                    visited.put(parent_track.get(cur),true);
                }
            }
        }
        List<Integer> res=new ArrayList<>();
        while(!q.isEmpty()){
            Node cur=q.poll();
            res.add(cur.key);
        }
        return res;

    }

}
