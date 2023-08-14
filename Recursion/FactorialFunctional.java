package tuf_a2zdsacourse.Recursion;

import java.util.Scanner;

public class FactorialFunctional {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter a value of n:");
        int n= sc.nextInt();
        int fact=factFunc(n);
        System.out.println("Factorial is: "+fact);
    }

    private static int factFunc(int n) {
        if(n==0)
            return 1;

        return n*factFunc(n-1);
    }
}
