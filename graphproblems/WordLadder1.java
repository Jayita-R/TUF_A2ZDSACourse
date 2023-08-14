package tuf_a2zdsacourse.graphproblems;

import java.util.*;

class pair {
    String first;
    int second;
    pair(String _first, int _second) {
        this.first = _first;
        this.second = _second;
    }
}

public class WordLadder1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the start word: ");
        String sWord=sc.next();
        System.out.print("Enter the target word: ");
        String tWord=sc.next();
        System.out.print("Enter the no. of elements: ");
        int n=sc.nextInt();
        String[] wordList=new String[n];
        System.out.print("Enter the words in array:");
        for(int i=0;i<n;i++){
            wordList[i]= sc.next();
        }
        WordLadder1 obj = new WordLadder1();
        int ans = obj.wordLadderLength(sWord, tWord, wordList);

        System.out.print(ans);

        System.out.println();

    }

    private int wordLadderLength(String sWord, String tWord, String[] wordList) {
        Queue<pair> q=new LinkedList<>();
        q.add(new pair(sWord,1));

        Set<String> st=new HashSet<>();
        int len=wordList.length;
        for(int i=0;i<len;i++){
            st.add(wordList[i]);
        }
        st.remove(sWord);
        while(!q.isEmpty()){
            String w=q.peek().first;
            int steps=q.peek().second;
            q.remove();
            if(w.equals(tWord)==true) return steps;

            for(int i=0;i<w.length();i++){
                for (char ch = 'a'; ch <= 'z'; ch++){
                    char replacedCharArray[] = w.toCharArray();
                    replacedCharArray[i] = ch;
                    String replacedWord = new String(replacedCharArray);

                    if(st.contains(replacedWord)==true){
                        st.remove(replacedWord);
                         q.add(new pair(replacedWord,steps+1));
                    }
                }
            }
        }
        return 0;
    }
}
