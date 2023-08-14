package tuf_a2zdsacourse;

import java.util.Scanner;

public class CharacterHashing {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter a string: ");
        String s=sc.next();

        //precompute
        int[] hash=new int[26];
        for(int i=0;i<s.length();i++){
            hash[s.charAt(i)-'a']++;
        }



        System.out.print("Enter the no.of queries");
        int q=sc.nextInt();
        int i=0;
        while(i<q) {
            char ch = sc.next().charAt(0);
            i++;

            //fetch
            System.out.print(hash[ch-'a']+" ");

        }


    }
}
