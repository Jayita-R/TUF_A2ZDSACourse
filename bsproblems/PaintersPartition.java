package tuf_a2zdsacourse.bsproblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

//Painter's partition problem and split array largest sum both same problem.
public class PaintersPartition {
    public static void main(String[] args) {
        ArrayList<Integer> boards = new ArrayList<>(Arrays.asList(5,5,5,5));
        int k = 2;
        //int ans = findLargestMinDistance(boards, k);//bruteforce approach using linear search method
        int ans=findLargestMinDistanceBs(boards, k);//optimal approach using binary search method
        System.out.println("The answer is: " + ans);
    }

    private static int findLargestMinDistanceBs(ArrayList<Integer> boards, int k) {
        int low = Collections.max(boards);
        int high = boards.stream().mapToInt(Integer::intValue).sum();

        while(low<=high){
            int mid=(low+high)/2;
            int cntPainters=countPainters(boards, mid);
            if(cntPainters>k){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return low;
    }

    private static int findLargestMinDistance(ArrayList<Integer> boards, int k) {
        int low = Collections.max(boards);
        int high = boards.stream().mapToInt(Integer::intValue).sum();

        for (int time = low; time <= high; time++) {
            if (countPainters(boards, time) <= k) {
                return time;
            }
        }
        return low;
    }

    private static int countPainters(ArrayList<Integer> boards, int time) {
        int n = boards.size(); // size of array.
        int painters = 1;
        long boardsPainter = 0;
        for (int i = 0; i < n; i++) {
            if (boardsPainter + boards.get(i) <= time) {
                // allocate board to current painter
                boardsPainter += boards.get(i);
            } else {
                // allocate board to next painter
                painters++;
                boardsPainter = boards.get(i);
            }
        }
        return painters;
    }
}
