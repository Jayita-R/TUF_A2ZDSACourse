package tuf_a2zdsacourse.InfixPostfixPrefixExp;

import java.util.Scanner;
import java.util.Stack;

public class PostfixToPrefix {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter postfix expression:");
        String exp=sc.next();
        System.out.print("Prefix expression :"+postfixToPrefix(exp));
    }

    private static String postfixToPrefix(String exp) {
        Stack<String> st=new Stack<>();
        for(int i=0;i<exp.length();i++){

            if(isOperator(exp.charAt(i))){
                String op1=st.peek();
                st.pop();
                String op2=st.peek();
                st.pop();
                st.push(exp.charAt(i)+op2+op1);
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
