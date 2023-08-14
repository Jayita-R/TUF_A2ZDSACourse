package tuf_a2zdsacourse.InfixPostfixPrefixExp;

import java.util.Scanner;
import java.util.Stack;

public class EvaluatePostfixExp {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter postfix expression:");
        String exp=sc.next();
        System.out.println("Final ans is: "+evaluatePostfix(exp));

    }

    private static int evaluatePostfix(String exp) {
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<exp.length();i++){
            char c=exp.charAt(i);

            if(Character.isDigit(c)){
                st.push(c - '0');
            }else{
                int val1=st.pop();
                int val2=st.pop();

                switch (c) {
                    case '+':
                        st.push(val2 + val1);
                        break;
                    case '-':
                        st.push(val2 - val1);
                        break;
                    case '/':
                        st.push(val2 / val1);
                        break;
                    case '*':
                        st.push(val2 * val1);
                        break;
                }
            }
        }
        return st.pop();
    }
}
