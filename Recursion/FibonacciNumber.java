package tuf_a2zdsacourse.Recursion;

import java.util.Scanner;

//Example of multiple recursion calls
public class FibonacciNumber {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter n:");
        int n= sc.nextInt();
        int fibNum=fibonacci(n);
        System.out.println(n+"th fibonacci number is: "+fibNum);

    }

    private static int fibonacci(int n) {
        if(n<=1)
            return n;
        int last=fibonacci(n-1);
        int slast=fibonacci(n-2);
        return last+slast;
    }
}
