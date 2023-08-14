package tuf_a2zdsacourse.graphproblems;

import java.util.HashMap;
import java.util.Map;

public class MostStonesRemoved {
    public static void main(String[] args) {
        int n=6;
        int[][] stones={{0, 0}, {0, 2},
                {1, 3}, {3, 1},
                {3, 2}, {4, 3}};
        MostStonesRemoved ob=new MostStonesRemoved();
        int ans = ob.maxRemove(stones, n);
        System.out.println("The maximum number of stones we can remove is: " + ans);
    }

    private int maxRemove(int[][] stones, int n) {
        int maxRow=0;
        int maxCol=0;
        for(int i=0;i<n;i++){
            maxRow=Math.max(maxRow,stones[i][0]);
            maxCol=Math.max(maxCol,stones[i][1]);
        }
        DisjointSet ds=new DisjointSet(maxRow+maxCol+1);
        HashMap<Integer,Integer> mpp=new HashMap<>();
        for(int i=0;i<n;i++){
            int nRow=stones[i][0];
            int nCol=stones[i][1]+maxRow+1;
            ds.unionBySize(nRow,nCol);
            mpp.put(nRow,1);
            mpp.put(nCol,1);
        }
        int cnt=0;
        for(Map.Entry<Integer,Integer> it:mpp.entrySet()){
            if(ds.findUPar(it.getKey())==it.getKey()){
                cnt++;
            }
        }
        return n-cnt;
    }
}
