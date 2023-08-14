package tuf_a2zdsacourse.SlidingWindow;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LongestSubstringWithNoRepeatingChars {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter any string:");
        String st=sc.next();
        System.out.println("Length of Longest Substring with no repeating character is: "
                +longestSubStringWithNoRepeatingChars(st));
    }

    private static int longestSubStringWithNoRepeatingChars(String st) {
        int i=0,j=0;
        int n=st.length();
        int max=0;
        Map<Character,Integer> mpp=new HashMap<>();
        while(j<n){
            char ch=st.charAt(j);
            mpp.put(ch,mpp.getOrDefault(ch,0)+1);
            if(mpp.size()==(j-i+1)){
                max=Math.max(max,j-i+1);
                ++j;
            }else if(mpp.size()<(j-i+1)){
                while(mpp.size()<(j-i+1)){
                    mpp.put(st.charAt(i),mpp.get(st.charAt(i))-1);
                    if(mpp.get(st.charAt(i))==0){
                        mpp.remove(st.charAt(i));
                    }
                    ++i;
                }
                ++j;
            }
        }
        return max;
    }
}
