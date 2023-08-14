package tuf_a2zdsacourse.bsproblems;

import java.util.*;

public class BookAllocationProblem {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        ArrayList<Integer> ls=new ArrayList<>(Arrays.asList(12,34,67,90));
        int n=ls.size();
        System.out.print("Enter the no. of students(m): ");
        int m=sc.nextInt();
        //int ans=findPages(ls,n,m); //bruteforce approach using linear search method
        int ans=findPagesBs(ls,n,m); //optimal approach using binary search method
        System.out.println("The answer is: " + ans);
    }

    private static int findPagesBs(ArrayList<Integer> arr, int n, int m) {
        if(m>n) return -1;
        int low = Collections.max(arr);
        int high = arr.stream().mapToInt(Integer::intValue).sum();

        while(low<=high){
            int mid=(low+high)/2;
            int studs=countStudents(arr,mid);
            if(studs>m){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return low;

    }

    private static int findPages(ArrayList<Integer> arr, int n, int m) {
        if(m>n) return -1;

        int low = Collections.max(arr);
        int high = arr.stream().mapToInt(Integer::intValue).sum();

        for(int pages=low;pages<=high;pages++){
            if(countStudents(arr,pages)==m){
                return pages;
            }
        }
        return low;
    }

    private static int countStudents(ArrayList<Integer> arr, int pages) {
        int n=arr.size();
        int stud=1;
        long pagesStud=0;
        for(int i=0;i<n;i++){
            if(pagesStud+arr.get(i)<=pages){
                pagesStud+=arr.get(i);
            }else{
                stud++;
                pagesStud=arr.get(i);
            }
        }
        return stud;
    }
}
