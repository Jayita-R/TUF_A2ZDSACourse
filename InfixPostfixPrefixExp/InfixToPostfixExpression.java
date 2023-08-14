package tuf_a2zdsacourse.InfixPostfixPrefixExp;

import java.util.Scanner;
import java.util.Stack;

public class InfixToPostfixExpression {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the infix expression:");
        String exp=sc.next();
        System.out.print("Postfix expression is: "+infixToPostfix(exp));

    }

    private static String infixToPostfix(String exp) {
        String res="";
        // initializing empty stack
        Stack< Character > st = new Stack < > ();
        for(int i=0;i<exp.length();i++){
            char c = exp.charAt(i);

            // If the scanned character is an
            // operand, add it to output.
            if (Character.isLetterOrDigit(c))
                res += c;
            else if(c=='(')
                st.push(c);
            else if(c==')'){
                while(!st.isEmpty() && st.peek()!='('){
                    res+=st.pop();
                }
                st.pop();
            }else{
                while(!st.isEmpty() && prec(c)<=prec(st.peek())){
                    res+=st.pop();
                }
                st.push(c);
            }
        }
        // pop all the operators from the stack
        while (!st.isEmpty()) {
            if (st.peek() == '(')
                return "Invalid Expression";
            res += st.pop();
        }
        return res;
    }

    // A utility function to return
    // precedence of a given operator
    // Higher returned value means
    // higher precedence
    private static int prec(char ch) {
        switch (ch) {
            case '+':
            case '-':
                return 1;

            case '*':
            case '/':
                return 2;

            case '^':
                return 3;
        }
        return -1;
    }
}
