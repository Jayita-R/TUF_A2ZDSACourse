package tuf_a2zdsacourse.stackproblems;

import java.util.Stack;

public class MyStack {
    Stack<Integer> s;
    Stack<Integer> ss;

    MyStack(){
        s=new Stack<>();
        ss=new Stack<>();
    }

    void push(int a){
        s.push(a);
        if(ss.size()==0 || ss.peek()>=a){
            ss.push(a);
        }
        return;
    }

    int pop(){
        if(s.size()==0){
            return -1;
        }
        int ans=s.peek();
        s.pop();
        if(ans==ss.peek())
            ss.pop();
        return ans;
    }

    int getMin(){
        if(ss.size()==0)
            return -1;
        return ss.peek();
    }
}
