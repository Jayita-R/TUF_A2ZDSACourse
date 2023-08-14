package tuf_a2zdsacourse;

import java.util.ArrayList;
import java.util.List;

public class StringProblem {
    public static void main(String[] args) {
        String s="abcdefghij";
        int k=3;
        char fill='x';

        String[] ans=divideString(s,k,fill);
        for(int i=0;i<ans.length;i++){
            System.out.print(ans[i]+" ");
        }

    }
    public static String[] divideString(String s, int k, char fill) {
        //int ind=0;
        List<String> ls=new ArrayList<>();
        int i=0;
        while(i<s.length()){
            String ans=madeString(s,i,k,fill);
            ls.add(ans);
            i+=k;
            //++ind;
        }
        int len=ls.size();
        String[] str=new String[len];
        for(int j=0;j<len;j++){
            str[j]=ls.get(j);
        }
        return str;
    }
    public static String madeString(String s,int st,int k,char fill){
        String ans="";
        for(int i=st;i<s.length();i++){
            if(ans.length()!=k){
                ans+=s.charAt(i);
            }else if(ans.length()==k){
                return ans;
            }
        }
        if(ans.length()!=k){
            for(int i=ans.length()+1;i<=k;i++){
                ans+=fill;
            }
        }
        return ans;
    }
}

