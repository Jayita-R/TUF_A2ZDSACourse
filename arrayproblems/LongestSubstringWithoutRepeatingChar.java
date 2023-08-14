package tuf_a2zdsacourse.arrayproblems;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class LongestSubstringWithoutRepeatingChar {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the string:");
        String st=sc.next();
        //int len=lengthOfSubString(st); //naive approach
        int lenString=lengthOfSubStringOptimal1(st);//Optimal approach1
        int lenSt=lengthOfSubStringOptimal2(st);//Optimal approach1
        System.out.println("Length is:"+lenSt);
    }

    public static int lengthOfSubStringOptimal2(String s) {
        HashMap< Character, Integer > mpp = new HashMap < Character, Integer > ();

        int left = 0, right = 0;
        int n = s.length();
        int len = 0;
        while (right < n) {
            if (mpp.containsKey(s.charAt(right))) left = Math.max(mpp.get(s.charAt(right)) + 1, left);

            mpp.put(s.charAt(right), right);

            len = Math.max(len, right - left + 1);
            right++;
        }
        return len;
    }

    public static int lengthOfSubStringOptimal1(String st) {
        if(st.length()==0) return 0;
        HashSet<Character> set=new HashSet<>();
        int l=0;
        int maxans=Integer.MIN_VALUE;
        for(int r=0;r<st.length();r++){
            if(set.contains(st.charAt(r))){
                while(l<r && set.contains(st.charAt(r))){
                    set.remove(st.charAt(l));
                    l++;
                }

            }
            set.add(st.charAt(r));
            maxans=Math.max(maxans,r-l+1);
        }
        return maxans;
    }

    public static int lengthOfSubString(String st) {
        if(st.length()==0) return 0;
        int maxans=Integer.MIN_VALUE;
        for(int i=0;i<st.length();i++){
            HashSet<Character> set=new HashSet<>();
            for(int j=i;j<st.length();j++){
                if(set.contains(st.charAt(j))){
                    maxans=Math.max(maxans,j-i);
                    break;
                }
                set.add(st.charAt(j));
            }
        }
        return maxans;
    }
}
