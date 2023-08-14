package tuf_a2zdsacourse.arrayproblems;

import java.util.Scanner;

public class PowerOfX {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter any number:");
        double x=sc.nextDouble();
        System.out.println("Enter n value:");
        int n=sc.nextInt();
        double res=myPow(x,n);
        double ans=myPowOptimal(x,n);
        System.out.format("%.5f",ans);
    }

    public static double myPowOptimal(double x, int n) {
        double ans=1.0;
        long nn=(long)n;
        if(nn<0) nn=-1*nn;
        while(nn>0){
            if(nn%2==0){
                x=x*x;
                nn=nn/2;
            }else{
                ans=ans*x;
                nn=nn-1;
            }
        }
        if(n<0) ans=(double) 1.0/(double) ans;
        return ans;
    }

    public static double myPow(double x, int n) {
        double ans=1.0;
        long nn=(long)n;
        if(nn<0) nn=-1*nn;
        for(int i=1;i<=nn;i++){
           ans*=x;
        }
        if(n<0) ans=(double) 1.0/(double) ans;
        return ans;
    }
}
