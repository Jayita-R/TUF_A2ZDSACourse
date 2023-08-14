package tuf_a2zdsacourse.Recursion;

import java.util.Scanner;

public class SumFirstNNumsFunctional {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the value of n ");
        int n= sc.nextInt();
        int res=sumOfNums(n);
        System.out.println("Sum is: "+res);
    }

    private static int sumOfNums(int n) {
        if(n==0)
            return 0;

        return n+sumOfNums(n-1);
    }
}
