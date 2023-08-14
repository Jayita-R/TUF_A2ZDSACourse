package tuf_a2zdsacourse.heapproblems;

import java.util.PriorityQueue;
import java.util.Scanner;

public class KClosestPointsToOrigin {
    public static void main(String[] args) {
        KClosestPointsToOrigin kcpo=new KClosestPointsToOrigin();
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the no. of elements:");
        int n=sc.nextInt();
        System.out.println("Enter the elements in x:");
        int[] x=new int[n];
        for(int i=0;i<n;i++){
            x[i]=sc.nextInt();
        }
        System.out.println("Enter the elements in y:");
        int[] y=new int[n];
        for(int i=0;i<n;i++){
            y[i]=sc.nextInt();
        }
        System.out.println("Enter the value of k:");
        int k=sc.nextInt();
        kcpo.kClosestPoints(x, y, n, k);

    }

    public void kClosestPoints(int[] x, int[] y, int n, int k) {
        // Create a priority queue
        PriorityQueue<Pair> pq = new PriorityQueue<>();

        // Pushing all the points
        // in the queue
        for(int i = 0; i < n; i++)
        {
            pq.add(new Pair(x[i], y[i]));
        }

        // Print the first K elements
        // of the queue
        for(int i = 0; i < k; i++)
        {

            // Remove the top of the queue
            // and store in a temporary pair
            Pair p = pq.poll();

            // Print the first (x)
            // and second (y) of pair
            System.out.println(p.first +
                    " " + p.second);
        }
    }

    class Pair implements Comparable<Pair>
    {
        int first, second;
        Pair(int a, int b)
        {
            first = a;
            second = b;
        }

        public int compareTo(Pair o)
        {
            int x1 = first * first;
            int y1 = second * second;
            int x2 = o.first * o.first;
            int y2 = o.second * o.second;
            return (x1 + y1) - (x2 + y2);
        }
    }
}
