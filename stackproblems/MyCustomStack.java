package tuf_a2zdsacourse.stackproblems;

import java.util.Stack;

public class MyCustomStack {
    Stack<Integer> s;
    int minEle;

    public MyCustomStack() {
        s=new Stack<>();
    }
    void push(int x){
        if(s.size()==0){
            s.push(x);
            minEle=x;
        }
        else{
            if(x>=minEle)
                s.push(x);
            else if(x<minEle) {
                s.push(2 * x - minEle);
                minEle = x;
            }
        }
    }

    void pop(){
        if(s.size()==0)
            return;
        else{
            if(s.peek()>=minEle)
                s.pop();
            else if(s.peek()<minEle){
                minEle=2*minEle-s.peek();
                s.pop();
            }
        }
    }

    int top(){
        if(s.size()==0)
            return -1;
        else{
            if(s.peek()>=minEle)
                return s.peek();
            else if(s.peek()<minEle)
                return minEle;
        }
        return 0;
    }

    int getMin(){
        if(s.size()==0)
            return -1;
        return minEle;
    }
}
