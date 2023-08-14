package tuf_a2zdsacourse.Recursion;

import java.util.Scanner;

public class PrintNameNTimes {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter value of n:");
        int n=sc.nextInt();
        //printName(n);
        printName2(1,n); //As striver's solution

    }

    private static void printName2(int i, int n) {
        if(i>n){
            return;
        }
        System.out.println("jay");
        printName2(i+1,n);
    }

    private static void printName(int n) {
        if(n==0)
            return;
        System.out.println("Jayita");
        printName(--n);
    }
}
