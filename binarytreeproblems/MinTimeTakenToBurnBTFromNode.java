package tuf_a2zdsacourse.binarytreeproblems;

import java.util.*;

public class MinTimeTakenToBurnBTFromNode {
    public static void main(String[] args) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.left.right = new Node(7);
        root.right = new Node(3);
        root.right.left = new Node(5);
        root.right.right = new Node(6);
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the value of node:");
        int start=sc.nextInt();
        int res=timeToBurnTree(root,start);
        System.out.print("Min. time taken to burn the node is: "+res);

    }
    private static int timeToBurnTree(Node root,int start){
        Map<Node,Node> mpp=new HashMap<>();
        Node tar=bfsToMapParents(root,mpp,start);
        int maxi=findMaxDist(mpp,tar);
        return maxi;
    }

    private static Node bfsToMapParents(Node root, Map<Node, Node> mpp, int start) {
        Queue<Node> q=new LinkedList<>();
        q.offer(root);
        Node res=new Node(-1);
        while(!q.isEmpty()){
            Node cur=q.poll();
            if(cur.key==start) res=cur;
            if(cur.left!=null){
                mpp.put(cur.left,cur);
                q.offer(cur.left);
            }
            if(cur.right!=null){
                mpp.put(cur.right,cur);
                q.offer(cur.right);
            }
        }
        return res;
    }

    private static int findMaxDist(Map<Node, Node> mpp, Node tar) {
        Queue<Node> q=new LinkedList<>();
        q.offer(tar);
        Map<Node,Integer> vis=new HashMap<>();
        vis.put(tar,1);
        int maxi=0;
        while(!q.isEmpty()){
            int sz=q.size();
            int fl=0;
            for(int i=0;i<sz;i++){
                Node cur=q.poll();
                if(cur.left!=null && vis.get(cur.left)==null){
                    fl=1;
                    vis.put(cur.left,1);
                    q.offer(cur.left);
                }
                if(cur.right!=null && vis.get(cur.right)==null){
                    fl=1;
                    vis.put(cur.right,1);
                    q.offer(cur.right);
                }
                if(mpp.get(cur)!=null && vis.get(mpp.get(cur))==null){
                    fl=1;
                    vis.put(mpp.get(cur),1);
                    q.offer(mpp.get(cur));
                }
            }
            if(fl==1) ++maxi;
        }
        return maxi;
    }
}
