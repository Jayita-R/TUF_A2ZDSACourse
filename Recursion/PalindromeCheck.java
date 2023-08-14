package tuf_a2zdsacourse.Recursion;


import java.util.Scanner;

public class PalindromeCheck {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter any string:");
        String s=sc.next();
        boolean ans=palindrome(s,0);
        if(ans)
            System.out.println("Palindrome");
        else
            System.out.println("Not a Palindrome");
    }

    private static boolean palindrome(String s, int i) {
        if(i>=s.length()/2)
            return true;

        if(s.charAt(i)!=s.charAt(s.length()-i-1))
            return false;

        return palindrome(s,i+1);
    }

}
