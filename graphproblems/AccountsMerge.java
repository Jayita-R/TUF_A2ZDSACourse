package tuf_a2zdsacourse.graphproblems;

import java.util.*;

public class AccountsMerge {
    public static void main(String[] args) {
        List<List<String>> accounts = new ArrayList() {
            {
                add(new ArrayList<String>(Arrays.asList("John", "j1@com", "j2@com", "j3@com")));
                add(new ArrayList<String>(Arrays.asList("John", "j4@com")));
                add(new ArrayList<String>(Arrays.asList("Raj", "r1@com", "r2@com")));
                add(new ArrayList<String>(Arrays.asList("John", "j1@com", "j5@com")));
                add(new ArrayList<String>(Arrays.asList("Raj", "r2@com", "r3@com")));
                add(new ArrayList<String>(Arrays.asList("Mary", "m1@com")));

            }
        };

        AccountsMerge obj = new AccountsMerge();
        List<List<String>> ans = obj.accountsMerge(accounts);

        int n = ans.size();
        for (int i = 0; i < n; i++) {
            System.out.print(ans.get(i).get(0) + ": ");
            int size = ans.get(i).size();
            for (int j = 1; j < size; j++) {
                System.out.print(ans.get(i).get(j) + " ");
            }

            System.out.println("");
        }
    }

    private List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n=accounts.size();
        DisjointSet ds=new DisjointSet(n);
        HashMap<String,Integer> mpp=new HashMap<>();
        for(int i=0;i<n;i++){
            for(int j=1;j<accounts.get(i).size();j++){
                String mail=accounts.get(i).get(j);
                if(mpp.containsKey(mail)==false){
                    mpp.put(mail,i);
                }else{
                    ds.unionBySize(i,mpp.get(mail));
                }

            }
        }

        ArrayList<String>[] mergedMail=new ArrayList[n];
        for(int i=0;i<n;i++) mergedMail[i]=new ArrayList<String>();
        for(Map.Entry<String,Integer> it:mpp.entrySet()){
            String mail=it.getKey();
            int node=ds.findUPar(it.getValue());
            mergedMail[node].add(mail);
        }

        List<List<String>> ans=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(mergedMail[i].size()==0) continue;
            Collections.sort(mergedMail[i]);
            List<String> temp=new ArrayList<>();
            temp.add(accounts.get(i).get(0));
            for(String it:mergedMail[i]){
                temp.add(it);
            }
            ans.add(temp);
        }
        return ans;
    }
}
