package tuf_a2zdsacourse.LinkedList;


import java.util.ArrayList;

class Node {
    int num;
    Node next;
    Node(int val) {
        num = val;
        next = null;
    }
}
public class PalindromicLL {
    static Node insertNode(Node head,int val) {
        Node newNode = new Node(val);
        if(head == null) {
            head = newNode;
            return head;
        }

        Node temp = head;
        while(temp.next != null) temp = temp.next;

        temp.next = newNode;
        return head;
    }

    static Node reverse(Node ptr) {
        Node current=ptr;
        Node pre=null;
        Node next=null;
        while(current!=null) {
            next = current.next;
            current.next = pre;
            pre=current;
            current=next;
        }
        return pre;
    }

    static boolean isPalindrome(Node head) {
        if(head==null||head.next==null) return true;

        Node slow = head;
        Node fast = head;

        while(fast.next!=null && fast.next.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        slow.next = reverse(slow.next);
        slow = slow.next;
        Node dummy = head;

        while(slow!=null) {
            if(dummy.num != slow.num) return false;
            dummy = dummy.next;
            slow = slow.next;
        }
        return true;
    }
    /* // This is extreme naive approach where we are using an extra O(n) space to store the elements in arraylist.
    static boolean isPalindrome(Node head) {
        ArrayList<Integer> arr=new ArrayList<>();
        while(head != null) {
            arr.add(head.num);
            head = head.next;
        }
        for(int i=0;i<arr.size()/2;i++)
            if(arr.get(i) != arr.get(arr.size()-i-1)) return false;
        return true;
    }*/

    public static void main(String args[]) {
        Node head = null;
        head=insertNode(head,1);
        head=insertNode(head,2);
        head=insertNode(head,3);
        head=insertNode(head,4);
        head=insertNode(head,2);
        head=insertNode(head,1);
        if(isPalindrome(head)==true)
            System.out.println("True");
        else
            System.out.println("False");

    }
}
