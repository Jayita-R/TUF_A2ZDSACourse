package tuf_a2zdsacourse.Recursion;

import java.util.Scanner;

public class PrintNumsFromNToOneByBacktrack {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the value of n:");
        int n= sc.nextInt();
        printNumsNToOneByBacktrack(1,n);
    }

    private static void printNumsNToOneByBacktrack(int i, int n) {
        if(i>n)
            return;
        printNumsNToOneByBacktrack(i+1,n);
        System.out.println(i);
    }
}
