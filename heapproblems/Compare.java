package tuf_a2zdsacourse.heapproblems;

import java.util.Comparator;
import java.util.Map;

public class Compare implements Comparator<Map.Entry<Integer,Integer>>{
    public int compare(Map.Entry<Integer, Integer> a,
                       Map.Entry<Integer, Integer> b)
    {
        // b is at top and a is at bottom - have that in
        // mind
        if (a.getValue() == b.getValue()) // when freq same
            return a.getKey().compareTo(
                    b.getKey()); // smaller val stays at top
        return b.getValue().compareTo(
                a.getValue()); // higher freq stays at top
    }
}