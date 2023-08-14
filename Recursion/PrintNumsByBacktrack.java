package tuf_a2zdsacourse.Recursion;

import java.util.Scanner;

public class PrintNumsByBacktrack {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the value of n:");
        int n=sc.nextInt();
        printNumsBacktrack(n,n);
    }

    private static void printNumsBacktrack(int i, int n) {
        if(i<1)
            return;
        printNumsBacktrack(i-1,n);
        System.out.println(i);
    }
}
