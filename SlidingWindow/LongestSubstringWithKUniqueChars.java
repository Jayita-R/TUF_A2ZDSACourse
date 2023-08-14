package tuf_a2zdsacourse.SlidingWindow;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LongestSubstringWithKUniqueChars {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter any string:");
        String st=sc.next();
        System.out.print("Enter value of k:");
        int k=sc.nextInt();
        System.out.println("Length of Longest Substring with k unique characters is: "+longestSubStringWithKUniqueChars(st,k));
    }

    private static int longestSubStringWithKUniqueChars(String st, int k) {
        int i=0,j=0;
        int n=st.length();
        int max=-1;
        Map<Character,Integer> mpp=new HashMap<>();
        while(j<n){
            char ch=st.charAt(j);
            mpp.put(ch,mpp.getOrDefault(ch,0)+1);
            if(mpp.size()<k){
                ++j;
            }else if(mpp.size()==k){
                max=Math.max(max,j-i+1);
                ++j;
            }else if(mpp.size()>k){
                while(mpp.size()>k){
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
