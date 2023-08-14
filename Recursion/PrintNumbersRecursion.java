package tuf_a2zdsacourse.Recursion;

import java.util.Scanner;

public class PrintNumbersRecursion {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the value of n:");
        int n=sc.nextInt();
        printNums(1,n);
    }

    private static void printNums(int i, int n) {
        if(i>n)
            return;
        System.out.println(i);
        printNums(i+1,n);
    }
}
