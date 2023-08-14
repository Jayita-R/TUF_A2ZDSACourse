package tuf_a2zdsacourse.InfixPostfixPrefixExp;

import java.util.Scanner;
import java.util.Stack;

public class PrefixToInfix {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the prefix expression:");
        String exp=sc.next();
        System.out.println("Infix expression is:"+prefixToInfix(exp));
    }

    private static String prefixToInfix(String exp) {
        Stack<String> st=new Stack<>();
        for(int i=exp.length()-1;i>=0;i--) {
            char c = exp.charAt(i);

            if (isOperator(c)) {
                String val1 = st.pop();
                String val2 = st.pop();

                String temp = "(" + val1 + c + val2 + ")";
                st.push(temp);
            } else {
                st.push(c + "");
            }
        }
        return st.pop();
    }

    private static boolean isOperator(char c) {
        switch(c){
            case '+':
            case '-':
            case '*':
            case '/':
            case '%':
            case '^':
                return true;
        }
        return false;
    }
}
