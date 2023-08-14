package tuf_a2zdsacourse.SlidingWindow;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PickToys {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter any string:");
        String st=sc.next();
        System.out.println("John can max. pick toys : "+pickToys(st));
    }

    private static int pickToys(String st) {
        int i=0,j=0;
        int n=st.length();
        int max=-1;
        Map<Character,Integer> mpp=new HashMap<>();
        while(j<n){
            char ch=st.charAt(j);
            mpp.put(ch,mpp.getOrDefault(ch,0)+1);
            if(mpp.size()<2){
                ++j;
            }else if(mpp.size()==2){
                max=Math.max(max,j-i+1);
                ++j;
            }else if(mpp.size()>2){
                while(mpp.size()>2){
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
