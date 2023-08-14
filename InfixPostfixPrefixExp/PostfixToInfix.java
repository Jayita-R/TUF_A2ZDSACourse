package tuf_a2zdsacourse.InfixPostfixPrefixExp;

import java.util.Scanner;
import java.util.Stack;

public class PostfixToInfix {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter postfix expression:");
        String exp=sc.next();
        System.out.print("Infix expression :"+postfixToInfix(exp));

    }

    private static String postfixToInfix(String exp) {
        Stack<String> st=new Stack<>();
        for(int i=0;i<exp.length();i++){
            if(isOperand(exp.charAt(i))){
              st.push(exp.charAt(i)+"");
            }else{
                String op1=st.peek();
                st.pop();
                String op2=st.peek();
                st.pop();
                st.push("("+op2+exp.charAt(i)+op1+")");
            }
        }
        return st.peek();
    }

    private static boolean isOperand(char x) {
        return ((x>='a' && x<='z') || (x>='A' && x<='Z'));
    }
}
