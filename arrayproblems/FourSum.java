package tuf_a2zdsacourse.arrayproblems;

import java.util.*;

public class FourSum {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the no.of elements:");
        int n=sc.nextInt();
        int []arr=new int[n];
        System.out.print("Enter elements in the array:");
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        System.out.print("Enter the target value:");
        int t= sc.nextInt();
        //List<List<Integer>> ans=fourSumBrute(arr,n,t);
        //List<List<Integer>> ans=fourSumBetter(arr,n,t);
        List<List<Integer>> ans=fourSumOptimal(arr,n,t);
        System.out.println("The quardruples are:");
        for (List<Integer> it:ans){
            for(int num:it){
                System.out.print(num+" ");
            }
            System.out.println();
        }
    }

    public static List<List<Integer>> fourSumOptimal(int[] arr, int n, int t) {
        Arrays.sort(arr);
        List<List<Integer>> ans=new ArrayList<>();
        for(int i=0;i<n;i++){
            // avoid the duplicates while moving i:
            if(i>0 && arr[i]==arr[i-1]) continue;
            for(int j=i+1;j<n;j++){
                // avoid the duplicates while moving j:
                if(j>i+1 && arr[j]==arr[j-1]) continue;
                //2 pointers
                int k=j+1;
                int l=n-1;
                while(k<l){
                    long sum=arr[i];
                    sum+=arr[j];
                    sum+=arr[k];
                    sum+=arr[l];
                    if(sum==t){
                        List<Integer> temp=new ArrayList<>();
                        temp.add(arr[i]);
                        temp.add(arr[j]);
                        temp.add(arr[k]);
                        temp.add(arr[l]);
                        ans.add(temp);

                        k++;
                        l--;
                        // skip the duplicates:
                        while(k<l && arr[k]==arr[k-1]) k++;
                        while(k<l && arr[l]==arr[l+1]) l--;
                    }else if(sum<t) k++;
                    else l--;
                }

            }
        }
        return ans;
    }

    private static List<List<Integer>> fourSumBetter(int[] arr, int n, int t) {
        Set<List<Integer>> st=new HashSet<>();

        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                Set<Long> hashset = new HashSet<>();
                for(int k=j+1;k<n;k++){
                    long sum=arr[i]+arr[j];
                    sum+=arr[k];
                    long fourth=t-sum;
                    if(hashset.contains(fourth)){
                        List<Integer> temp = new ArrayList<>();
                        temp.add(arr[i]);
                        temp.add(arr[j]);
                        temp.add(arr[k]);
                        temp.add((int) fourth);
                        Collections.sort(temp);
                        st.add(temp);
                    }
                    hashset.add((long)arr[k]);

                }
            }
        }
        List<List<Integer>> ans = new ArrayList<>(st);
        return ans;
    }

    public static List<List<Integer>> fourSumBrute(int[] arr, int n, int t) {
        Set<List<Integer>> set=new HashSet<>();

        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                for(int k=j+1;k<n;k++){
                    for(int l=k+1;l<n;l++){
                        // taking bigger data type
                        // to avoid integer overflow:
                        long sum = (long)arr[i] + arr[j];
                        sum+=arr[k];
                        sum+=arr[l];

                        if(sum==t){
                            List<Integer> temp=Arrays.asList(arr[i],arr[j],arr[k],arr[l]);
                            Collections.sort(temp);
                            set.add(temp);
                        }
                    }
                }
            }
        }
        List<List<Integer>> ans = new ArrayList<>(set);
        return ans;



    }
}
