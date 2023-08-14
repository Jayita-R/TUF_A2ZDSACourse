package tuf_a2zdsacourse.Recursion;

import java.util.Scanner;

public class PrintNumbersFromNToOneRecursion {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the value of n:");
        int n= sc.nextInt();
        //printNumbers(n,1);
        printNumbers2(n,n); //As striver's solu.
    }

    private static void printNumbers2(int i, int n) {
        if(i<1)
            return;
        System.out.println(i);
        printNumbers2(i-1,n);
    }

    private static void printNumbers(int n, int i) {
        if(n<i)
            return;

        System.out.println(n);
        printNumbers(n-1,i);

    }
}
