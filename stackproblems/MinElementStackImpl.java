package tuf_a2zdsacourse.stackproblems;

import java.util.Scanner;
import java.util.Stack;

//Min. element in stack implementation with extra space
public class MinElementStackImpl {
    public static void main(String[] args) {
        MyStack s=new MyStack();
        // Function calls
        s.push(3);
        s.push(5);
        System.out.println(s.getMin());
        s.push(2);
        s.push(1);
        System.out.println(s.getMin());
        System.out.println(s.pop());
        System.out.println(s.getMin());
        System.out.println(s.pop());


    }
}
