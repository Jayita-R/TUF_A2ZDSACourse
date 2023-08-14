package tuf_a2zdsacourse;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CharacterHashingWithHashmap {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter a string: ");
        String s=sc.next();
        //precompute
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++)
        {
            if (map.containsKey(s.charAt(i)))
            {
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            }
            else
            {
                map.put(s.charAt(i), 1);
            }
        }

        // Traverse through map and print frequencies
        for (Map.Entry<Character,Integer> entry : map.entrySet())
        {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
