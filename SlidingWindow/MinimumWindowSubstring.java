package tuf_a2zdsacourse.SlidingWindow;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MinimumWindowSubstring {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter any string:");
        String s=sc.next();
        System.out.print("Enter another string:");
        String t=sc.next();
        System.out.println("Minimum window substring is: "+findMinimumWindowSubstring(s, t));

    }

    private static String findMinimumWindowSubstring(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) {
            return "";
        }

        int n = s.length();
        int minLen = Integer.MAX_VALUE;
        int startInd = 0;

        //Map<Character,Integer> mpp=new HashMap<>();
        Map<Character, Integer> substrMap = new HashMap<>();

        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            substrMap.put(c, substrMap.getOrDefault(c, 0) + 1);
        }
        int count = substrMap.size();

        int i = 0, j = 0;

        while (j < n) {
            char cRight = s.charAt(j);
            if (substrMap.containsKey(cRight)) {
                substrMap.put(cRight, substrMap.get(cRight) - 1);
                if (substrMap.get(cRight) == 0) {
                    count -= 1;
                }
            }

            while (count <= 0) {
                char cLeft = s.charAt(i);
                if (substrMap.containsKey(cLeft)) {
                    substrMap.put(cLeft, substrMap.get(cLeft) + 1);
                    // map.get(cLeft) means cLeft is the start character(position) of curr window
                    // pay attention to the duplicated characters.
                    if (substrMap.get(cLeft) >= 1) {
                        count += 1;
                    }
                }
                // Get the min window
                if (j - i + 1 < minLen) {
                    startInd = i;
                    minLen = j - i + 1;
                }
                i++;
            }
            j++;
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(startInd, startInd + minLen);
    }

}
