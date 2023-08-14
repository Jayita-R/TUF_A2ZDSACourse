package tuf_a2zdsacourse.arrayproblems;

import java.util.Scanner;

//This technique is only applicable if prev.row last element is smaller than next row first element.
public class SearchInSortedMatrix {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter row:");
        int r=sc.nextInt();
        System.out.print("Enter col:");
        int c=sc.nextInt();
        int[][] arr=new int[r][c];
        System.out.println("Enter values in the matrix:");
        for (int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                arr[i][j]=sc.nextInt();
            }
        }
        System.out.println("Enter target value:");
        int target= sc.nextInt();
        boolean ans=searchInMatrix(arr,r,c,target);//naive approach
        boolean res=searchInMatrixByBinarySearch(arr,r,c,target); //Efficient approach
        System.out.println(res);

    }

    public static boolean searchInMatrixByBinarySearch(int[][] arr, int r, int c, int target) {
        int low=0;
        if(arr.length==0) return false;
        int high=(r*c)-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(arr[mid/c][mid%c]==target){
                return true;
            }else if(arr[mid/c][mid%c]<target){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return false;
    }

    public static boolean searchInMatrix(int[][] arr, int r, int c, int target) {
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(arr[i][j]==target)
                    return true;
            }
        }
        return false;
    }
}
