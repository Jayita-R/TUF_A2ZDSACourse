package tuf_a2zdsacourse.InfixPostfixPrefixExp;

import java.util.Scanner;
import java.util.Stack;

public class PrefixToPostfix {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter prefix expression:");
        String exp=sc.next();
        System.out.print("Postfix expression :"+prefixToPostfix(exp));
    }

    private static String prefixToPostfix(String exp) {
        Stack<String> st=new Stack<>();
        for(int i=exp.length()-1;i>=0;i--){

            if(isOperator(exp.charAt(i))){
                String op1=st.peek();
                st.pop();
                String op2=st.peek();
                st.pop();
                st.push(op1+op2+exp.charAt(i));
            }else{
                st.push(exp.charAt(i)+"");
            }
        }
        return st.pop();
    }

    private static boolean isOperator(char x) {
        switch(x){
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
