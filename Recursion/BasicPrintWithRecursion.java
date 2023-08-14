package tuf_a2zdsacourse.Recursion;

import java.util.Scanner;

public class BasicPrintWithRecursion {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the value of n:");
        int n=sc.nextInt();
        func(n);
    }

    private static void func(int n) {
        if(n==4)
            return;
        System.out.println(n);
        n++;
        func(n);
    }
}
