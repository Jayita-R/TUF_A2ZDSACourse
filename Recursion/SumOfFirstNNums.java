package tuf_a2zdsacourse.Recursion;

import java.util.Scanner;

public class SumOfFirstNNums {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter value of n:");
        int n=sc.nextInt();
        int sum=0;
        funcSum(n,sum); //parameterised way
    }

    private static void funcSum(int i, int sum) {
        if(i<1){
            System.out.println(sum);
            return;
        }
        funcSum(i-1,sum+i);

    }
}
