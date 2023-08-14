package tuf_a2zdsacourse.stackproblems;

//min. stack implementation with no extra space
public class MinStackImpl {
    public static void main(String[] args) {
        MyCustomStack s=new MyCustomStack();
        // Function calls
        s.push(3);
        s.push(5);
        System.out.println(s.getMin());
        s.push(2);
        s.push(1);
        System.out.println(s.getMin());
        s.pop();
        System.out.println(s.getMin());
        s.pop();
        System.out.println(s.top());
        System.out.println(s.getMin());
    }
}
