package tuf_a2zdsacourse;

public class StringReverseWords {
    public static void main(String[] args) {
        String s="aba";
        int cnt=partitionString(s);
        System.out.println(cnt);
    }

    //private static String reverseWords(String S) {
    public static int partitionString(String s) {
            String res="";
            int cnt=1;
            for(int i=0;i<s.length();i++){
                char x=s.charAt(i);
                if(res.length()>=1 && res.contains(Character.toString(x))==true){
                    res="";
                    ++cnt;
                    System.out.println(res);
                }else if(res.contains(Character.toString(x))==false){
                    res+=x;
                    System.out.println(res);
                }
            }
            return cnt;
    }
}
