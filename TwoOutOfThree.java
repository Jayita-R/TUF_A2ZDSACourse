package tuf_a2zdsacourse;

import java.util.ArrayList;
import java.util.List;

public class TwoOutOfThree {
    public static void main(String[] args) {
        int nums1[]={1,1,3,2};
        int nums2[]={2,3};
        int nums3[]={3};
        List<Integer> ls=twoOutOfThree(nums1,nums2,nums3);
        for(int val:ls){
            System.out.print(ls+" ");
        }
    }

    private static List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        List<Integer> res=new ArrayList<Integer>();
        List<Integer> res1=new ArrayList<Integer>();
        List<Integer> res2=new ArrayList<Integer>();
        List<Integer> res3=new ArrayList<Integer>();
        for(int i=0;i<nums1.length;i++){
            res1.add(nums1[i]);
        }
        for(int i=0;i<nums2.length;i++){
            res2.add(nums2[i]);
        }
        for(int i=0;i<nums3.length;i++){
            res3.add(nums3[i]);
        }


        for(int i=0;i<res1.size();i++){
            if(((res2.contains(res1.get(i))==true && res1.contains(res1.get(i))==true) ||  res3.contains(res1.get(i))) &&
                    res.contains(res1.get(i))==false){
                res.add(res1.get(i));
            }
        }
        /*for(int val:res){
            System.out.println(val);
        }*/

        for(int i=0;i<res2.size();i++){
            if(res1.contains(res2.get(i))==true && res3.contains(res2.get(i))==true &&
                    res.contains(res2.get(i))==false){
                res.add(res2.get(i));
            }
        }

        for(int i=0;i<res3.size();i++){
            if(res1.contains(res3.get(i))==true && res2.contains(res3.get(i))==true &&
                    res.contains(res3.get(i))==false){
                res.add(res3.get(i));
            }
        }
        return res;
    }
}
