package com.maximumEraserValue.hashMapApproach;

import java.util.HashMap;
import java.util.Map;

public class Code {
    public static void main(String [] args){
        int [] nums = {4,2,4,5,6};
        //int [] nums = {558,508,782,32,187,103,370,607,619,267,984,10};
        System.out.println(maximumUniqueSubarray(nums));
    }

    public static int maximumUniqueSubarray(int[] nums) {
        int tempSum = 0;
        int actualSum = 0;
        int x = 0;
        int [] sumSeq = new int [nums.length];
        Map<Integer,Integer> numsMap = new HashMap<>();
        for(int i = 0; i<nums.length;i++) {
            tempSum = tempSum + nums[i];
            sumSeq[i] = tempSum;
        }
        tempSum = 0;
        for(int i = 0; i<nums.length;i++) {
            if (numsMap.get(nums[i]) != null && numsMap.get(nums[i]) >= x) {
                if(x==0) {
                    tempSum = sumSeq[i-1] - 0;
                }else{
                    tempSum = sumSeq[i-1] - sumSeq[x-1];
                }
                x=numsMap.get(nums[i])+1;
                numsMap.remove(nums[i]);
                numsMap.put(nums[i], i);
                if (tempSum > actualSum)
                    actualSum = tempSum;
                tempSum = 0;
            }else if(numsMap.get(nums[i]) != null && numsMap.get(nums[i]) < x){
                numsMap.remove(nums[i]);
                numsMap.put(nums[i], i);
            }else if(numsMap.get(nums[i]) == null)
                numsMap.put(nums[i],i);
        }
        if(x!=0){
            tempSum = sumSeq[nums.length-1] - sumSeq[x-1];
        }else{
            tempSum = sumSeq[sumSeq.length-1];
        }

        if(tempSum>actualSum)
            actualSum=tempSum;
        return actualSum;
    }

}
