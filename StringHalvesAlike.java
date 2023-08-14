package tuf_a2zdsacourse;

import java.util.PriorityQueue;

public class StringHalvesAlike {
    public static void main(String[] args) {
        String s="edcab";
        String ans=sort(s);
        System.out.println(ans);
    }

    public static String sort(String s)
    {
        // code here
        String res="";
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(int i=0;i<s.length();i++){
            pq.add((int)s.charAt(i));
        }

        /*while(!pq.isEmpty()){
            System.out.println(pq.peek());
            pq.poll();
        }*/

        while(!pq.isEmpty()){
            int num=pq.peek();
            //System.out.println(num);
            char ch=(char)num;
            //res+=ch;
            System.out.println(ch);
            pq.poll();
        }
        return res;
    }
}
